package com.udemy.saga.webapp.order.controller;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.udemy.saga.webapp.order.dto.CreateOrderRequest;
import com.udemy.saga.webapp.order.dto.CreateOrderResponse;
import com.udemy.saga.webapp.order.dto.Order;
import com.udemy.saga.webapp.order.dto.OrderHistoryResponse;
import com.udemy.saga.webapp.order.service.OrderHistoryService;
import com.udemy.saga.webapp.order.service.OrderService;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequestMapping("/orders")
public class OrdersController {

	@Autowired
	private OrderService orderService;

	@Autowired
	private OrderHistoryService orderHistoryService;

	@PostMapping("/placeOrder")
	@ResponseStatus(HttpStatus.ACCEPTED)
	public CreateOrderResponse placeOrder(@RequestBody @Valid CreateOrderRequest request) {
		log.info("In CreateOrderResponse::placeOrder()");
    	log.info("Order Placed Request:{}",request);
		var order = new Order();
		BeanUtils.copyProperties(request, order);
		Order createdOrder = orderService.placeOrder(order);

		var response = new CreateOrderResponse();
		BeanUtils.copyProperties(createdOrder, response);
		return response;
	}

	@GetMapping("/orderHistoryById/{orderId}")
	@ResponseStatus(HttpStatus.OK)
	public List<OrderHistoryResponse> getOrderHistory(@PathVariable Long orderId) {
		return orderHistoryService.findByOrderId(orderId).stream().map(orderHistory -> {
			OrderHistoryResponse orderHistoryResponse = new OrderHistoryResponse();
			BeanUtils.copyProperties(orderHistory, orderHistoryResponse);
			return orderHistoryResponse;
		}).toList();
	}
}
