package com.saga.webapp.payments.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.saga.webapp.payments.constants.PaymentConstants;
import com.saga.webapp.payments.dto.OrderEvent;
import com.saga.webapp.payments.dto.OrderRequest;
import com.saga.webapp.payments.dto.PaymentEvent;
import com.saga.webapp.payments.entity.Payment;
import com.saga.webapp.payments.repo.PaymentRepository;

@Service
public class PaymentService {
	
	@Autowired
	private PaymentRepository repository;

	@Autowired
	private KafkaTemplate<String, OrderEvent> kafkaTemplate;

	@KafkaListener(topics = PaymentConstants.KAFKA_TOPIC_REVERSED_PAYMENTS, groupId = PaymentConstants.KAFKA_PAYMENT_GROUP_ID)
	public void reversePayment(String event) {
		System.out.println("Inside reverse payment for order "+event);
		
		try {
			PaymentEvent paymentEvent = new ObjectMapper().readValue(event, PaymentEvent.class);

			OrderRequest order = paymentEvent.getOrderRequest();

			Iterable<Payment> payments = this.repository.findByOrderId(order.getOrderId());

			payments.forEach(p -> {
				p.setStatus("FAILED");
				repository.save(p);
			});

			OrderEvent orderEvent = new OrderEvent();
			orderEvent.setOrderRequest(paymentEvent.getOrderRequest());
			orderEvent.setType("ORDER_REVERSED");
			kafkaTemplate.send("reversed-orders", orderEvent);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
