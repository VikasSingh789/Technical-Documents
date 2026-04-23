package com.udemy.kafka.webapp.withdrwal.handler;

import org.springframework.kafka.annotation.KafkaHandler;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import com.udemy.kafka.webapp.withdrwal.dto.WithdrawalRequestedEvent;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
@KafkaListener(topics = "withdraw-money-topic", containerFactory = "kafkaListenerContainerFactory")
public class WithdrawalRequestedEventHandler {

    @KafkaHandler
    public void handle(@Payload WithdrawalRequestedEvent withdrawalRequestedEvent) {
        log.info("Received a new withdrawal event: {} ", withdrawalRequestedEvent);
    }
}
