package com.udemy.saga.webapp.order.command;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProcessPaymentCommand {
	
	private Long orderId;
	private Long productId;
	private BigDecimal productPrice;
	private Integer productQuantity;
	
}
