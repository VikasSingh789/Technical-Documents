package com.programs;

class Parent {
	public void m1() {
		System.out.println("Hi");
	}
}

class Child extends Parent {
	public void m1() throws Exception {
		System.out.println("Hello there");
	}
}

public class ExceptionHandlingExample {

	public static void main(String[] args) {
		Parent p = new Parent();
		p.m1();

		Parent c = new Child();
		c.m1();

	}

}

//Above Program will throw Exception Because Child class m1() declares "throws Exception", so this Declaration also needs to be done in Parent m1() as well since its a Paresnt Class.
//Once we also declares "throws Exception" on parent class m1(), Will face the Exception again because "p.m1()" is directly calling from Main Method.
//So, Ultimately in Main Method also, we have to Declare "throws Exception" on Main Method or Handle the Exception by using "try catch" on "p.m1()".
