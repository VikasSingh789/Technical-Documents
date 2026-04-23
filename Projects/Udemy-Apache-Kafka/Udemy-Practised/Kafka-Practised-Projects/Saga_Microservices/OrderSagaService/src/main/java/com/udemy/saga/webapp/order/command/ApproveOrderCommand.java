package com.udemy.saga.webapp.order.command;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApproveOrderCommand {
	
	private Long orderId;
	
}
