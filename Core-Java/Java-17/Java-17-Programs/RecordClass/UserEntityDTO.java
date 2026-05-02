package com.programs.java17.recordClass;

public class UserEntityDTO {

	public static void main(String[] args) {
		UserEntity ue = new UserEntity(1L, "Vikas", "email", "phone", "address");
		UserEntityRecord uer = new UserEntityRecord(ue.getId(), ue.getName());
		System.out.println(uer);
		
		UserEntity ueo = new UserEntity(1L, "Vikas", "email", "phone", "address");
		UserEntityObjectRecord ueor = new UserEntityObjectRecord(ueo);
		System.out.println(ueor);
	}

}
