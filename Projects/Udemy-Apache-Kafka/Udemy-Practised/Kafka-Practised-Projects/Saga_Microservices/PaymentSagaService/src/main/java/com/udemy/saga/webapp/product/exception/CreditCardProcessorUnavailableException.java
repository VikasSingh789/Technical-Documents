package com.udemy.saga.webapp.product.exception;

public class CreditCardProcessorUnavailableException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public CreditCardProcessorUnavailableException(Throwable cause) {
		super(cause);
	}
}
