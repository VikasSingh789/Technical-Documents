package com.udemy.kafka.wepapp.producer.service.impl;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;

import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import com.udemy.kafka.wepapp.producer.dto.CreateProductRestModel;
import com.udemy.kafka.wepapp.producer.dto.ProductCreatedEvent;
import com.udemy.kafka.wepapp.producer.service.ProductService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ProductServiceImpl implements ProductService {
	
	@Value("${product-kafka-topic}")
	String productCreatedtopicName;

	@Autowired
	KafkaTemplate<String, ProductCreatedEvent> kafkaTemplate;

	@Override
	public String createProductAsync(CreateProductRestModel productRestModel) throws Exception {
		log.info("In ProductServiceImpl::createProduct()");
		log.info("Product Request Object:{}",productRestModel);

		String productId = UUID.randomUUID().toString();

		ProductCreatedEvent productCreatedEvent = new ProductCreatedEvent(productId, productRestModel.getTitle(),
				productRestModel.getPrice(), productRestModel.getQuantity());

		CompletableFuture<SendResult<String, ProductCreatedEvent>> future = kafkaTemplate.send(productCreatedtopicName, productId, productCreatedEvent);
		future.whenComplete((result, exception)->{
			if(exception!=null) {
				log.error("Failed to send message: "+exception.getMessage());
			} else {
				log.info("Message Sent Successfully"+result.getRecordMetadata());
			}
		});

		log.info("***** Returning product id:"+productId);
		return productId;
	}
	
	//Note:- In above createProductAsync(), just by adding "future.join();" after future.whenComplete(..){..}.. line, It will
	//make our code Synchronous.
	//But Not to confuse code with Asynchronous and Synchronous, Below is the appropriate code i.e createProductSync(), which will make
	//our code Synchronous
	
	@Override
	public String createProductSync(CreateProductRestModel productRestModel) throws Exception {
		log.info("In ProductServiceImpl::createProductSync()");
		log.info("Product Request Object:{}",productRestModel);

		String productId = UUID.randomUUID().toString();

		ProductCreatedEvent productCreatedEvent = new ProductCreatedEvent(productId, productRestModel.getTitle(),
				productRestModel.getPrice(), productRestModel.getQuantity());
		
		ProducerRecord<String, ProductCreatedEvent> record = new ProducerRecord<>(
				productCreatedtopicName,productId,productCreatedEvent);
		record.headers().add("messageID", UUID.randomUUID().toString().getBytes());

		SendResult<String, ProductCreatedEvent> result = kafkaTemplate.send(record).get();
		log.info("Partition: " + result.getRecordMetadata().partition());
		log.info("Topic: " + result.getRecordMetadata().topic());
		log.info("Offset: " + result.getRecordMetadata().offset());
		
		log.info("***** Returning product id:"+productId);
		return productId;
	}

}
