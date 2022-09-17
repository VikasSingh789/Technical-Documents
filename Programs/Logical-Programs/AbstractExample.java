package simpleprograms;

interface i{
	public void m1();
	abstract void m2();
	abstract void m3();
	public int a=10;
	public default void move(){
        System.out.println("I am moving");
    }
}
interface j extends i{
	public void m1();
	abstract void m2();
}


class A implements j{
	public int a=20;
	@Override
	public void m1() {
		// TODO Auto-generated method stub
		System.out.println("m1 Method");
	}

	@Override
	public void m2() {
		// TODO Auto-generated method stub
		System.out.println("m2");
	}

	@Override
	public void m3() {
		// TODO Auto-generated method stub
		System.out.println("m3");
	}

}
public class AbstractExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		j obj=new A();
		obj.move();
		obj.m3();
		System.out.println(obj.a);
	}

}
