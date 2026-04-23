package com.udemy.saga.webapp.product.dto;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Payment {
	
	private Long id;
	private Long orderId;
	private Long productId;
	private BigDecimal productPrice;
	private Integer productQuantity;
	
}
