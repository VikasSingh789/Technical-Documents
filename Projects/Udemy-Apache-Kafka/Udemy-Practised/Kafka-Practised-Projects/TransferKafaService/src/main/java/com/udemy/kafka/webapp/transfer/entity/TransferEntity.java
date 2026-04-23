package com.udemy.kafka.webapp.transfer.entity;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="transfer_kafka_events")
public class TransferEntity {
	
	@Id
	@GeneratedValue
	private Long transferId;
	
	@Column(name = "sender_id", nullable = false)
	private String senderId;
	
	@Column(name = "recepient_id", nullable = false)
	private String recepientId;
	
	private BigDecimal amount;

}
