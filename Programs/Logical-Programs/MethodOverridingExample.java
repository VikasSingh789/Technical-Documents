package com.practice;

class Parent{
	static int i = 10;
	void m1() {
		System.out.println("Parent Class");
	}
}

class Child extends Parent{
	static int i = 20;
	void m1() {
		System.out.println("Child Class");
	}
}

public class MethodOverridingExample {

	public static void main(String[] args) {
		
		Parent p = new Parent();
		System.out.println(p.i);
		p.m1();
		System.out.println("===========");
		Child c = new Child();
		System.out.println(c.i);
		c.m1();
		System.out.println("===========");
		Parent pc = new Child();
		System.out.println(pc.i);
		pc.m1();
		
	}

}


// 10
// Parent Class
// ===========
// 20
// Child Class
// ===========
// 10  // 10 because static cannot be overridden
// Child Class
