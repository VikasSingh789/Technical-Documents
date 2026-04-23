package com.saga.webapp.order.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.saga.webapp.order.constants.OrderConstants;
import com.saga.webapp.order.dto.OrderEvent;
import com.saga.webapp.order.dto.OrderRequest;
import com.saga.webapp.order.entity.Order;
import com.saga.webapp.order.repo.OrderRepository;

@RestController
@RequestMapping("/api/order")
public class OrderController {

	@Autowired
	private OrderRepository orderRepository;

	@Autowired
	private KafkaTemplate<String, OrderEvent> kafkaTemplate;

	@PostMapping("/placeOrder")
	public void createOrder(@RequestBody OrderRequest orderRequest) {

		Order order = new Order();
		order.setAmount(orderRequest.getAmount());
		order.setItem(orderRequest.getItem());
		order.setQuantity(orderRequest.getQuantity());
		order.setStatus(OrderConstants.STATUS);

		try {
			order = orderRepository.save(order);
			orderRequest.setOrderId(order.getId());

			OrderEvent event = new OrderEvent();
			event.setOrderRequest(orderRequest);
			event.setType(OrderConstants.KAFKA_STATUS_ORDER_CREATED);

			kafkaTemplate.send(OrderConstants.KAFKA_TOPIC_NEW_ORDER, event);
		} catch (Exception e) {
			order.setStatus(OrderConstants.FAILED);
			orderRepository.save(order);
		}

	}

}
