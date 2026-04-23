package com.udemy.kafka.wepapp.consumer.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.annotation.KafkaHandler;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;

import com.udemy.kafka.wepapp.consumer.dto.ProductCreatedEvent;
import com.udemy.kafka.wepapp.consumer.entity.ProcessEventEntity;
import com.udemy.kafka.wepapp.consumer.error.NoTRetryableException;
import com.udemy.kafka.wepapp.consumer.error.RetryableException;
import com.udemy.kafka.wepapp.consumer.repo.ProcessedEventRepo;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
@KafkaListener(topics="product-created-events-topic")
public class ProductCreatedEventHandler {
	
	@Value("${product-kafka-topic}")
    String topicName;
	
	@Autowired
	RestTemplate restTemplate;
	
	@Autowired
	ProcessedEventRepo processedEventRepo;
	
	@Transactional
	@KafkaHandler
	public void handleProductCreated(@Payload ProductCreatedEvent productCreatedEvent,
			@Header(value="messageID", required=false) String messageId,
			@Header(KafkaHeaders.RECEIVED_KEY) String messageKey) {
		log.info("Consumed Messages from Topic:{}",topicName);
		log.info("Messages are:{}",productCreatedEvent);
		
		//NotRetryable Code:
		//if(true) throw new NoTRetryableException("Error Occured. No Need to Consume this Message Again");
//		log.info("Consumed Messages from Topic:{}",topicName);
//		log.info("Messages are:{}",productCreatedEvent);
//		
//		String apiUrl = "http://localhost:8082/response/200";
//		
//		try {
//			ResponseEntity<String> response = restTemplate.exchange(apiUrl, HttpMethod.GET, null, String.class);
//			if(response.getStatusCode().value() == HttpStatus.OK.value()) {
//				log.info("Received Response from mock Service: "+response.getBody());
//			}
//		} catch(ResourceAccessException ex) {
//			throw new RetryableException(ex);
//		} catch(HttpServerErrorException ex) {
//			throw new NoTRetryableException(ex);
//		} catch(Exception ex) {
//			throw new NoTRetryableException(ex);
//		}
		
		ProcessEventEntity existingRecord = processedEventRepo.findByMessageId(messageId);
		if(existingRecord!=null) {
			log.info("Found Duplicate MessageID",messageId);
			return;
		}
		
		try {
			ProcessEventEntity processEventEntity = new ProcessEventEntity();
			processEventEntity.setMessageId(messageId);
			processEventEntity.setProductId(productCreatedEvent.getProductId());
			processedEventRepo.save(processEventEntity);
		} catch (DataIntegrityViolationException ex) {
			throw new NoTRetryableException(ex);
		}
	}
}
