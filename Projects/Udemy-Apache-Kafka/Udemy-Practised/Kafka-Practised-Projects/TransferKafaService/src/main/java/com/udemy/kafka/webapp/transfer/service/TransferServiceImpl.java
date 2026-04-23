package com.udemy.kafka.webapp.transfer.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import com.udemy.kafka.webapp.transfer.dto.DepositRequestedEvent;
import com.udemy.kafka.webapp.transfer.dto.TransferRestModel;
import com.udemy.kafka.webapp.transfer.dto.WithdrawalRequestedEvent;
import com.udemy.kafka.webapp.transfer.entity.TransferEntity;
import com.udemy.kafka.webapp.transfer.error.TransferServiceException;
import com.udemy.kafka.webapp.transfer.repo.TransferRepo;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class TransferServiceImpl {
	
	@Value("${withdraw-money-topic}")
	String withdrawMoneyTopic;
	
	@Value("${deposit-money-topic}")
	String depositMoneyTopic;
	
	@Autowired
	RestTemplate restTemplate;

	@Autowired
	KafkaTemplate<String, Object> kafkaTemplate;
	
	@Autowired
	TransferRepo transferRepo;

	@Transactional("transactionManager")
	public boolean transfer(TransferRestModel transferRestModel) {
		
		WithdrawalRequestedEvent withdrawalEvent = new WithdrawalRequestedEvent(transferRestModel.getSenderId(),
				transferRestModel.getRecepientId(), transferRestModel.getAmount());
		
		DepositRequestedEvent depositEvent = new DepositRequestedEvent(transferRestModel.getSenderId(),
				transferRestModel.getRecepientId(), transferRestModel.getAmount());
		
		TransferEntity transferEntity = new TransferEntity();
		BeanUtils.copyProperties(transferRestModel, transferEntity);

		try {
			
			//Save record to a transfer_kafka_events Table
			transferRepo.save(transferEntity);
			
			kafkaTemplate.send(withdrawMoneyTopic, withdrawalEvent);
			log.info("Sent event to withdrawal topic.");

			// Business logic that causes and error
			callRemoteServce();

			kafkaTemplate.send(depositMoneyTopic, depositEvent);
			log.info("Sent event to deposit topic");

		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new TransferServiceException(ex);
		}

		return true;
	}

	private ResponseEntity<String> callRemoteServce() throws Exception {
		String requestUrl = "http://localhost:8082/response/200";
		ResponseEntity<String> response = restTemplate.exchange(requestUrl, HttpMethod.GET, null, String.class);

		if (response.getStatusCode().value() == HttpStatus.SERVICE_UNAVAILABLE.value()) {
			throw new Exception("Destination Microservice not availble");
		}

		if (response.getStatusCode().value() == HttpStatus.OK.value()) {
			log.info("Received response from mock service: " + response.getBody());
		}
		return response;
	}

}
