package com.udemy.saga.webapp.product.events;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductReservationFailedEvent {
	private Long productId;
	private Long orderId;
	private Integer productQuantity;
}
