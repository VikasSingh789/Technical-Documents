package com.practice;

class Parent2{
	void m1() throws Exception {
		System.out.println("Parent Class m1()");
	}
}

class Child2 extends Parent2{
	void m1() throws Exception {
		System.out.println("Child class m1()");
	}
}
public class ExceptionPropagationExample2 {

	public static void main(String[] args) {
		Parent2 p = new Parent2();
		try {
			p.m1();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Parent2 pc = new Child2();
		try {
			pc.m1();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
