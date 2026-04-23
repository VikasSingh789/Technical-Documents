package com.saga.webapp.order.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.saga.webapp.order.constants.OrderConstants;
import com.saga.webapp.order.dto.OrderEvent;
import com.saga.webapp.order.entity.Order;
import com.saga.webapp.order.repo.OrderRepository;

@Service
public class OrderService {

	@Autowired
	private OrderRepository orderRepository;

	@KafkaListener(topics = OrderConstants.KAFKA_TOPIC_REVERSED_ORDER, groupId = OrderConstants.KAFKA_ORDER_GROUP_ID)
	public void reverseOrder(String event) {
		System.out.println("Reverse Order Event ::" + event);

		try {
			OrderEvent orderEvent = new ObjectMapper().readValue(event, OrderEvent.class);
			Optional<Order> order = orderRepository.findById(orderEvent.getOrderRequest().getOrderId());
			order.ifPresent(o -> {
				o.setStatus(OrderConstants.FAILED);
				orderRepository.save(o);
			});
		} catch (Exception e) {
			System.out.println("Exception Occured while reverting Order Details");
		}
	}

}
