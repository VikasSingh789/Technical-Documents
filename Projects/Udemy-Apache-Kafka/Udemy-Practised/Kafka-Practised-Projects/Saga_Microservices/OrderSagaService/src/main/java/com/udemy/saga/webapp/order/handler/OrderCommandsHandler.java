package com.udemy.saga.webapp.order.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaHandler;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import com.udemy.saga.webapp.order.command.ApproveOrderCommand;
import com.udemy.saga.webapp.order.service.OrderService;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
@KafkaListener(topics = "${orders.commands.topic.name}")
public class OrderCommandsHandler {
	
	@Value("${orders.commands.topic.name}")
	String orderCommandsTopicName;

	@Autowired
	private OrderService orderService;

	@KafkaHandler
	public void handleCommand(@Payload ApproveOrderCommand approveOrderCommand) {
		log.info("In OrderCommandsHandler::handleCommand()");
    	log.info("Kafka Topic:{}",orderCommandsTopicName);
    	log.info("Consumed Approve Order Command Data:{}",approveOrderCommand);
    	
		orderService.approveOrder(approveOrderCommand.getOrderId());
	}
}
