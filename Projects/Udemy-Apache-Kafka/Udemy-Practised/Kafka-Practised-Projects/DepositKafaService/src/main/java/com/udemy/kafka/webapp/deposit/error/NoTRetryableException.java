package com.udemy.kafka.webapp.deposit.error;

public class NoTRetryableException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public NoTRetryableException(String message) {
		super(message);
	}

	public NoTRetryableException(Throwable throwable) {
		super(throwable);
	}

}
