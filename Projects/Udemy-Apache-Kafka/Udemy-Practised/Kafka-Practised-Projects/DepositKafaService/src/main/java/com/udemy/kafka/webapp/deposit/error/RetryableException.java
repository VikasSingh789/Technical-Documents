package com.udemy.kafka.webapp.deposit.error;

public class RetryableException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public RetryableException(String message) {
		super(message);
	}

	public RetryableException(Throwable throwable) {
		super(throwable);
	}

}
