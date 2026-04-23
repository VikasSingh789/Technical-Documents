package com.udemy.saga.webapp.order.events;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaymentProcessedEvent {
	
	private Long orderId;
	private Long paymentId;
	
}
