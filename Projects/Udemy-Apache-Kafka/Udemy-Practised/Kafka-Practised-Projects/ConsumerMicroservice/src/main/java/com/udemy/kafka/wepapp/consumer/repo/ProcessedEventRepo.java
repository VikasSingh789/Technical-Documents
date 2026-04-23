package com.udemy.kafka.wepapp.consumer.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.udemy.kafka.wepapp.consumer.entity.ProcessEventEntity;

@Repository
public interface ProcessedEventRepo extends JpaRepository<ProcessEventEntity, Long> {
	
	ProcessEventEntity findByMessageId(String messageId);

}
