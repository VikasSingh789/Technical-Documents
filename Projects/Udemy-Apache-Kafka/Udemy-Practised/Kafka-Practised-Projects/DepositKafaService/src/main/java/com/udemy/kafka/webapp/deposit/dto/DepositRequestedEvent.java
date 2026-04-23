package com.udemy.kafka.webapp.deposit.dto;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DepositRequestedEvent {

	private String senderId;
	private String recepientId;
	private BigDecimal amount;

}