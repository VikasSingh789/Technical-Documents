package com.programs;

public class SwapWithXor {

	public static void main(String[] args) {
		int a = 5;
		int b = 10;

		System.out.println("Before swap: a =" + a + ", b=" + b);

		a = a ^ b;
		b = a ^ b;
		a = a ^ b;

		System.out.println("After swap: a = " + a + ", b=" + b);
	}
}

//Input:- a = 5, b = 10
//Output:- a = 10, b = 5