package com.practice;

class Parent1{
	void m1() {
		System.out.println("Parent Class");
		int a = 10/0; // UnChecked Exception
		//throw new java.io.IOException("device error"); // Checked Exception
	}
	
	void n()  {
		m1();
	}
	
	void p() {
		try{
			n();
		}catch (Exception e) {
			System.out.println(e+"-> Exception Handled in p()");
		}
		//n();
	}

}

public class ExceptionPropagationExample {

	public static void main(String[] args) throws Exception  {
		Parent1 n = new Parent1();
		n.p();
		try{
			n.m1();
		}catch(Exception e) {
			System.out.println(e+"->hi");
		}
		System.out.println("Rest of the code");
	}

}
