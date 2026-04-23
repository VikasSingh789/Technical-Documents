package com.udemy.kafka.wepapp.consumer.error;

public class NoTRetryableException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public NoTRetryableException(String message) {
		super(message);
	}

	public NoTRetryableException(Throwable throwable) {
		super(throwable);
	}

}
