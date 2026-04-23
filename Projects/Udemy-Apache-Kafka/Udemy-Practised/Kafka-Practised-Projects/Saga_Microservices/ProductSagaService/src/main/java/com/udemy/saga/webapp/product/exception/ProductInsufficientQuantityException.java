package com.udemy.saga.webapp.product.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class ProductInsufficientQuantityException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	private final Long productId;
	private final Long orderId;

	public ProductInsufficientQuantityException(Long productId, Long orderId) {
		super("Product " + productId + " has insufficient quantity in the stock for order " + orderId);
		this.productId = productId;
		this.orderId = orderId;
	}
}
