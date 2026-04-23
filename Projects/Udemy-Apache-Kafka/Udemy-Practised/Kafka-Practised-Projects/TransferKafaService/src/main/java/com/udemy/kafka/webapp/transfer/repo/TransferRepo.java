package com.udemy.kafka.webapp.transfer.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.udemy.kafka.webapp.transfer.entity.TransferEntity;

@Repository
public interface TransferRepo extends JpaRepository<TransferEntity, Long> {

}
