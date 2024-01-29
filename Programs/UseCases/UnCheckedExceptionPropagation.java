package com.programs;

public class UnCheckedExceptionPropagation {

	public static void main(String[] args) {
		UnCheckedExceptionPropagation obj = new UnCheckedExceptionPropagation();
		obj.method1();
		System.out.println("After handling exception...");
	}

	private void method3() {
		System.out.println("In method3");
		int result = 10 / 0; // Arithematic Exception will arises (UnChecked Exception)
		System.out.println(result);
	}

	// This method will forward the exception
	private void method2() {
		System.out.println("In method2");
		method3();
	}

	// Exception will be handled here
	private void method1() {
		try {
			method2();
		} catch (Exception e) {
			System.out.println("Exception caught in m1():" + e.getMessage());
		}
	}
}

//Exception will be Handled in method1() Once Exception Occurs in method3(), because method1() handing the Exception using "try catch".
//Note:- We are not using "Throws" Keyword to Propagate the Exception because this is Unchecked Exception and Unchecked Exception's are by default propagated.