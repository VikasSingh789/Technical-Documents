package com.saga.webapp.stock.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.saga.webapp.stock.dto.DeliveryEvent;
import com.saga.webapp.stock.dto.PaymentEvent;
import com.saga.webapp.stock.entity.Stock;
import com.saga.webapp.stock.repo.StockRepository;

@Service
public class StockService {
	
	@Autowired
	private StockRepository repository;

	@Autowired
	private KafkaTemplate<String, PaymentEvent> kafkaTemplate;

	@KafkaListener(topics = "reversed-stock", groupId = "stock-group")
	public void reverseStock(String event) {
		System.out.println("Inside reverse stock for order "+event);
		
		try {
			DeliveryEvent deliveryEvent = new ObjectMapper().readValue(event, DeliveryEvent.class);

			Stock inv = this.repository.findByItem(deliveryEvent.getOrder().getItem());

			inv.setQuantity(inv.getQuantity() + deliveryEvent.getOrder().getQuantity());
			repository.save(inv);

			PaymentEvent paymentEvent = new PaymentEvent();
			paymentEvent.setOrderRequest(deliveryEvent.getOrder());
			paymentEvent.setType("PAYMENT_REVERSED");
			kafkaTemplate.send("reversed-payments", paymentEvent);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
