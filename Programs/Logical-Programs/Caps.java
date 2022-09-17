package simple;

import java.util.Scanner;
interface i{
	public abstract void m1();
}
interface j extends i{
	public abstract void m2();
}
abstract class AC1 implements j{
	public abstract void m3();
	public void m4(){
		System.out.println("AC1 m4 method");
	}
}
abstract class AC2 extends AC1{
	public abstract void m5();
	public void m6(){
		System.out.println("AC2 m6 method");
	}
}
class C extends AC2{
	public void m1(){
		System.out.println("C class m1 method");
	}
	public void m2(){
		System.out.println("C class m2 method");
	}
	public void m3(){
		System.out.println("C class m2 method");
	}
	public void m5(){
		System.out.println("C class m2 method");
	}
}
public class Caps {
	public static void main(String[] args) {
		i obj=new C();
		obj.m1();
		System.out.println("============");
		j obj1=new C();
		obj1.m1();
		obj1.m2();
		System.out.println("============");
		AC1 obj2=new C();
		obj2.m1();
		obj2.m2();
		obj2.m3();
		obj2.m4();
		System.out.println("============");
		AC2 obj3=new C();
		obj3.m1();
		obj3.m2();
		obj3.m3();
		obj3.m4();
		obj3.m5();
		obj3.m6();
	}
}
