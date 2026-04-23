package com.udemy.kafka.webapp.deposit.config;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.listener.DeadLetterPublishingRecoverer;
import org.springframework.kafka.listener.DefaultErrorHandler;
import org.springframework.kafka.support.serializer.ErrorHandlingDeserializer;
import org.springframework.kafka.support.serializer.JsonDeserializer;
import org.springframework.kafka.support.serializer.JsonSerializer;
import org.springframework.util.backoff.FixedBackOff;

import com.udemy.kafka.webapp.deposit.dto.DepositRequestedEvent;
import com.udemy.kafka.webapp.deposit.error.NoTRetryableException;
import com.udemy.kafka.webapp.deposit.error.RetryableException;

@Configuration
public class KafkaDepositConsumerConfig {
	
	@Autowired
	Environment environment;

	@Bean
	ConsumerFactory<String, DepositRequestedEvent> consumerFactory() {
		// Configure the JsonDeserializer
	    JsonDeserializer<DepositRequestedEvent> jsonDeserializer = new JsonDeserializer<>(DepositRequestedEvent.class);
	    jsonDeserializer.addTrustedPackages("com.udemy.kafka.webapp.deposit.dto");
	    // This is crucial: ignore type headers from producer
	    jsonDeserializer.setUseTypeHeaders(false);

	    // Wrap with ErrorHandlingDeserializer
	    ErrorHandlingDeserializer<DepositRequestedEvent> errorHandlingDeserializer = new ErrorHandlingDeserializer<>(jsonDeserializer);

	    Map<String, Object> config = new HashMap<>();
	    config.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, environment.getProperty("spring.kafka.consumer.bootstrap-servers"));
	    config.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
	    config.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, errorHandlingDeserializer.getClass());
	    config.put(ConsumerConfig.GROUP_ID_CONFIG, environment.getProperty("spring.kafka.consumer.group-id"));
	    config.put(ConsumerConfig.ISOLATION_LEVEL_CONFIG, 
				environment.getProperty("spring.kafka.consumer.isolation-level", "READ_COMMITTED").toLowerCase());

	    return new DefaultKafkaConsumerFactory<String, DepositRequestedEvent>(config, new StringDeserializer(), errorHandlingDeserializer);
	}
	
	@Bean
	ConcurrentKafkaListenerContainerFactory<String, DepositRequestedEvent> kafkaListenerContainerFactory(
			ConsumerFactory<String, DepositRequestedEvent> consumerFactory, KafkaTemplate<String, DepositRequestedEvent> kafkaTemplate) {
		
		DefaultErrorHandler errorHandler = new DefaultErrorHandler(new DeadLetterPublishingRecoverer(kafkaTemplate), new FixedBackOff(5000, 3));
		errorHandler.addNotRetryableExceptions(NoTRetryableException.class);
		errorHandler.addRetryableExceptions(RetryableException.class);
		
		ConcurrentKafkaListenerContainerFactory<String, DepositRequestedEvent> factory = new ConcurrentKafkaListenerContainerFactory<>();
		factory.setConsumerFactory(consumerFactory);
		factory.setCommonErrorHandler(errorHandler);
		
		return factory;
	}
	
	@Bean
	KafkaTemplate<String, DepositRequestedEvent> kafkaTemplate(ProducerFactory<String, DepositRequestedEvent> producerFactory){
		return new KafkaTemplate<String, DepositRequestedEvent>(producerFactory);
	}
	
	@Bean
	ProducerFactory<String, DepositRequestedEvent> producerFactory() {
		Map<String, Object> config = new HashMap<>();
		config.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, environment.getProperty("spring.kafka.consumer.bootstrap-servers"));
		config.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);
		config.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
		return new DefaultKafkaProducerFactory<>(config);
	}
}
