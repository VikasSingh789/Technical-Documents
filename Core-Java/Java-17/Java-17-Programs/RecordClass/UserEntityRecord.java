package com.programs.java17.recordClass;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record UserEntityRecord(Long id, String name, String email, String phone, String address) {
	
	public UserEntityRecord(Long id, String name, String email, String phone) {
		this(id, name, email, phone, null);
	}
	
	public UserEntityRecord(Long id, String name) {
		this(id, name, null, null, null);
	}

}
