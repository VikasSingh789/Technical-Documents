package com.udemy.kafka.wepapp.consumer.error;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class RetryableException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public RetryableException(String message) {
		super(message);
	}

	public RetryableException(Throwable throwable) {
		super(throwable);
	}

}
