package com.saga.webapp.stock.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderRequest {

	private String item;
	private int quantity;
	private double amount;
	private String paymentMethod;
	private long orderId;
	private String address;

}
