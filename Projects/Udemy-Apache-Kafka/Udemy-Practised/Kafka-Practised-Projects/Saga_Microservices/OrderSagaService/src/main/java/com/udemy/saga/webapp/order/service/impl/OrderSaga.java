package com.udemy.saga.webapp.order.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaHandler;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import com.udemy.saga.webapp.order.command.ApproveOrderCommand;
import com.udemy.saga.webapp.order.command.ProcessPaymentCommand;
import com.udemy.saga.webapp.order.command.ReserveProductCommand;
import com.udemy.saga.webapp.order.enums.OrderStatus;
import com.udemy.saga.webapp.order.events.OrderApprovedEvent;
import com.udemy.saga.webapp.order.events.OrderCreatedEvent;
import com.udemy.saga.webapp.order.events.PaymentProcessedEvent;
import com.udemy.saga.webapp.order.events.ProductReservedEvent;
import com.udemy.saga.webapp.order.service.OrderHistoryService;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
@KafkaListener(topics={
        "${orders.events.topic.name}",
        "${products.events.topic.name}",
        "${payments.events.topic.name}"
})
public class OrderSaga {
	
	@Value("${orders.events.topic.name}")
	String orderEventsTopicName;
	
	@Value("${products.events.topic.name}")
	String productsEventsTopicName;
	
	@Value("${payments.events.topic.name}")
	String paymentsEventsTopicName;
	
	@Value("${products.commands.topic.name}")
	String productsCommandsTopicName;
	
	@Value("${payments.commands.topic.name}")
	String paymentsCommandsTopicName;
	
	@Value("${orders.commands.topic.name}")
	String ordersCommandsTopicName;

	@Autowired
    private KafkaTemplate<String, Object> kafkaTemplate;
	
	@Autowired
    private OrderHistoryService orderHistoryService;
	
    @KafkaHandler
    public void handleEvent(@Payload OrderCreatedEvent event) {
    	log.info("Kafka Topic:{}",orderEventsTopicName);
    	log.info("Consumed Order Created Event:{}",event);

        ReserveProductCommand command = new ReserveProductCommand(
                event.getProductId(),
                event.getProductQuantity(),
                event.getOrderId()
        );

        kafkaTemplate.send(productsCommandsTopicName,command);
        log.info("Sent Reserve Product Data on Kafka Topic:{} With Data:{}",productsCommandsTopicName, command);
        orderHistoryService.add(event.getOrderId(), OrderStatus.CREATED);
    }

    @KafkaHandler
    public void handleEvent(@Payload ProductReservedEvent event) {
    	log.info("Kafka Topic:{}",productsEventsTopicName);
    	log.info("Consumed Product Reserved Event:{}",event);

        ProcessPaymentCommand processPaymentCommand = new ProcessPaymentCommand(event.getOrderId(),
                event.getProductId(),event.getProductPrice(), event.getProductQuantity());
        kafkaTemplate.send(paymentsCommandsTopicName,processPaymentCommand);
        log.info("Sent Process Payment Command Data on Kafka Topic:{} With Data:{}",paymentsCommandsTopicName, processPaymentCommand);
    }

    @KafkaHandler
    public void handleEvent(@Payload PaymentProcessedEvent event) {
    	log.info("Kafka Topic:{}",paymentsEventsTopicName);
    	log.info("Consumed Payment Processed Event:{}",event);
    	
        ApproveOrderCommand approveOrderCommand = new ApproveOrderCommand(event.getOrderId());
        kafkaTemplate.send(ordersCommandsTopicName, approveOrderCommand);
        log.info("Sent Approve Order Command Data on Kafka Topic:{} With Data:{}",ordersCommandsTopicName, approveOrderCommand);
    }

    @KafkaHandler
    public void handleEvent(@Payload OrderApprovedEvent event) {
    	log.info("Kafka Topic:{}",orderEventsTopicName);
    	log.info("Consumed Order Approved Event:{}",event);
        orderHistoryService.add(event.getOrderId(), OrderStatus.APPROVED);
    }
}
