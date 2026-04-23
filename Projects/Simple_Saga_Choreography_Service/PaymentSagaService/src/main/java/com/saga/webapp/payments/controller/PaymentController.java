package com.saga.webapp.payments.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.saga.webapp.payments.constants.PaymentConstants;
import com.saga.webapp.payments.dto.OrderEvent;
import com.saga.webapp.payments.dto.OrderRequest;
import com.saga.webapp.payments.dto.PaymentEvent;
import com.saga.webapp.payments.entity.Payment;
import com.saga.webapp.payments.repo.PaymentRepository;


@RestController
public class PaymentController {
	
	@Value("{spring.kafka.consumer.group-id}")
	String paymentGroupId;
	
	@Autowired
	private PaymentRepository paymentRepository;
	
	@Autowired
	private KafkaTemplate<String, PaymentEvent> kafkaTemplate;
	
	@Autowired
	private KafkaTemplate<String, OrderEvent> orderKafkaTemplate;
	
	@KafkaListener(topics = PaymentConstants.KAFKA_TOPIC_NEW_ORDER, groupId = "{spring.kafka.consumer.group-id}")
	public void processPayment(String event) throws Exception {
		System.out.println("processPayment event : "+event);
		
		OrderEvent orderEvent = new ObjectMapper().readValue(event, OrderEvent.class);
		OrderRequest orderRequest = orderEvent.getOrderRequest();
		
		Payment payment = new Payment();
		payment.setAmount(orderRequest.getAmount());
		payment.setMode(orderRequest.getPaymentMethod());
		payment.setOrderId(orderRequest.getOrderId());
		payment.setStatus(PaymentConstants.PAYMENT_SUCCESS);
		
		try {
			if(orderRequest.getAmount()>=0) {
				throw new Exception("Address not present");
			}
			paymentRepository.save(payment);
			
			PaymentEvent paymentEvent = new PaymentEvent();
			paymentEvent.setOrderRequest(orderRequest);
			paymentEvent.setType(PaymentConstants.PAYMENT_CREATED);
			
			kafkaTemplate.send(PaymentConstants.KAFKA_TOPIC_NEW_PAYMENT, paymentEvent);
			
		} catch (Exception e) {
			payment.setOrderId(orderRequest.getOrderId());
			payment.setStatus(PaymentConstants.FAILED);
			paymentRepository.save(payment);
			
			//Reverting the Order
			OrderEvent oe = new OrderEvent();
			oe.setOrderRequest(orderRequest);
			oe.setType(PaymentConstants.KAFKA_STATUS_ORDER_REVERSED);
			
			orderKafkaTemplate.send(PaymentConstants.KAFKA_TOPIC_REVERSED_ORDER,oe);
		}
		
		
	}

}
