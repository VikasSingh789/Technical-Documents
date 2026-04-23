package com.udemy.saga.webapp.order.dto;

import java.time.LocalDateTime;
import java.util.UUID;

import com.udemy.saga.webapp.order.enums.OrderStatus;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderHistoryResponse {
	
	private Long id;
	private UUID orderId;
	private OrderStatus status;
	private LocalDateTime createdAt;
	
}
