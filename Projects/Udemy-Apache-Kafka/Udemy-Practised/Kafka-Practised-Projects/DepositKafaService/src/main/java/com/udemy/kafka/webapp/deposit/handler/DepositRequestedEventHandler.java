package com.udemy.kafka.webapp.deposit.handler;

import org.springframework.kafka.annotation.KafkaHandler;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import com.udemy.kafka.webapp.deposit.dto.DepositRequestedEvent;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
@KafkaListener(topics = "deposit-money-topic", containerFactory = "kafkaListenerContainerFactory")
public class DepositRequestedEventHandler {

	@KafkaHandler
	public void handle(@Payload DepositRequestedEvent depositRequestedEvent) {
		log.info("Received a new deposit event: {} ", depositRequestedEvent);
	}
}
