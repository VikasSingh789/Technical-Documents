package com.programs.java17.recordClass;

public record PersonRecord(int age, String name) implements Bank, Account {

	public PersonRecord() {
		this(1, "Vikas");
	}

	public void distanceFromOrigin() {
		System.out.println(age + " " + name);
	}

	@Override
	public void bank() {
		int age1 = 20;
		System.out.println("Bank Age=" + age1);

	}

	@Override
	public void account() {
		int age1 = 30;
		System.out.println("Account Age=" + age1);
	}

}
