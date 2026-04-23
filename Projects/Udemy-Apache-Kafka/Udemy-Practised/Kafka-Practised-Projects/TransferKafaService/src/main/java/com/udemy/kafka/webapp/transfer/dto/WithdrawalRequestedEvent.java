package com.udemy.kafka.webapp.transfer.dto;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WithdrawalRequestedEvent {
	private String senderId;
	private String recepientId;
	private BigDecimal amount;

}