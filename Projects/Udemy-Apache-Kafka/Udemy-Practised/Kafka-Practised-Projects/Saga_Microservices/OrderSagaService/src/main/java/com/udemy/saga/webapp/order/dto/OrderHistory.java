package com.udemy.saga.webapp.order.dto;

import java.time.LocalDateTime;

import com.udemy.saga.webapp.order.enums.OrderStatus;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderHistory {
	
	private Long id;
	private Long orderId;
	private OrderStatus status;
	private LocalDateTime createdAt;
	
}
