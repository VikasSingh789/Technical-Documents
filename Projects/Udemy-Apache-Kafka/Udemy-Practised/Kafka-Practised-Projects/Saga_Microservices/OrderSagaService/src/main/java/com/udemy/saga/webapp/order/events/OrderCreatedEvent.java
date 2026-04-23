package com.udemy.saga.webapp.order.events;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderCreatedEvent {
	
	private Long orderId;
	private Long customerId;
	private Long productId;
	private Integer productQuantity;
	
}
