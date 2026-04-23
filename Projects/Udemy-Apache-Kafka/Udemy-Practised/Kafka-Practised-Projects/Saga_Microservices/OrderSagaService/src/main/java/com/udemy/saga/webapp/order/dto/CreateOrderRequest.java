package com.udemy.saga.webapp.order.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateOrderRequest {
	private Long customerId;
	private Long productId;
	private Integer productQuantity;
}
