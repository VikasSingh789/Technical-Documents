package com.programs;

import java.io.FileNotFoundException;

public class CheckedExceptionPropagation {

	public static void main(String[] args) throws FileNotFoundException {
		CheckedExceptionPropagation obj = new CheckedExceptionPropagation();
		obj.method1();
		System.out.println("After handling exception");
	}

	private void method3() throws FileNotFoundException {
		System.out.println("In method3");
		throw new FileNotFoundException("File not found.."); // FileNotFoundException arises (Checked Exception)
	}

	private void method2() throws FileNotFoundException {
		System.out.println("In method2");
		method3();
	}

	private void method1() throws FileNotFoundException {
		try {
			method2();
		} catch (FileNotFoundException ex) {
			System.out.println("FileNotFoundException caught in m1() :" + ex.getMessage());
		}
	}
}

//Above Program is Example of Checked Exception because we are throwing "FileNotFoundException" which is a Checked Exception.
//We have to use "throws" keyword to Propagate the Exception, because Checked Exceptions are need to be propagated manually by using "throws" keyword.
//if we are using both "throws" and "try catch" on method1(), then Exception will not be Propagated and will get caught in method1() itself. So no use of using Both.
