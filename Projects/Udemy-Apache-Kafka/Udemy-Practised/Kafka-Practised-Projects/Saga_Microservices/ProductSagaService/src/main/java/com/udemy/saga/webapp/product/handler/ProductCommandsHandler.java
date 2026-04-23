package com.udemy.saga.webapp.product.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaHandler;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import com.udemy.saga.webapp.product.command.ReserveProductCommand;
import com.udemy.saga.webapp.product.dto.Product;
import com.udemy.saga.webapp.product.events.ProductReservationFailedEvent;
import com.udemy.saga.webapp.product.events.ProductReservedEvent;
import com.udemy.saga.webapp.product.service.ProductService;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
@KafkaListener(topics = "${products.commands.topic.name}")
public class ProductCommandsHandler {
	
	@Value("${products.commands.topic.name}")
	String productsCommandsTopicName;

	@Value("${products.events.topic.name}")
	String productEventsTopicName;

	@Autowired
	private ProductService productService;
	
	@Autowired
	private KafkaTemplate<String, Object> kafkaTemplate;

	@KafkaHandler
	public void handleCommand(@Payload ReserveProductCommand command) {
		log.info("Kafka Topic:{}",productsCommandsTopicName);
    	log.info("Conusmed Reserve Product Command:{}",command);

		try {
			Product desiredProduct = new Product(command.getProductId(), null, null, command.getProductQuantity());
			Product reservedProduct = productService.reserve(desiredProduct, command.getOrderId());
			ProductReservedEvent productReservedEvent = new ProductReservedEvent(command.getOrderId(),
					command.getProductId(), reservedProduct.getPrice(), command.getProductQuantity());
			kafkaTemplate.send(productEventsTopicName, productReservedEvent);
			log.info("Product Reserve Data Sent on Kafka Topic:{} With Data:{}",productEventsTopicName, productReservedEvent);
		} catch (Exception e) {
			log.error(e.getLocalizedMessage(), e);
			ProductReservationFailedEvent productReservationFailedEvent = new ProductReservationFailedEvent(
					command.getProductId(), command.getOrderId(), command.getProductQuantity());
			kafkaTemplate.send(productEventsTopicName, productReservationFailedEvent);
			log.info("Product Reserve Failed Data Sent on Kafka Topic:{} With Data:{}",productEventsTopicName, productReservationFailedEvent);
		}
	}
}
