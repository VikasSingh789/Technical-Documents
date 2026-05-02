package com.programs.java17.recordClass;

public class RecordClass {

	public static void main(String[] args) {
		PersonRecord pr = new PersonRecord(1, "Vikas");
		System.out.println(pr.age() + " " + pr.name());

		int personAge = pr.age();
		System.out.println(personAge);
		pr.account();
		pr.bank();

		PersonRecord constr = new PersonRecord();
		System.out.println(constr.age());

		System.out.println(new PersonRecord(personAge, "Vikas"));
		pr.distanceFromOrigin();
	}

}
