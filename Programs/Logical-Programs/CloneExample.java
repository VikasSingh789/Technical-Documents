package simpleprograms;

class Test1{
	int a;
	int b;
}
class Test2 implements Cloneable{
	int a;
	int b;
	Test1 c=new Test1();
	public Object clone() throws CloneNotSupportedException 
	{ 
		return super.clone(); 
	} 
}
public class CloneExample {

	public static void main(String[] args) throws CloneNotSupportedException {
		Test2 t1=new Test2();
		t1.a=10;
		t1.b=20;
		t1.c.a=30;
		t1.c.b=40;
		Test2 t2=(Test2)t1.clone();
		t2.a=100;
		System.out.println(t1.a+" "+t1.b+" "+t1.c.a+" "+t1.c.b);
		System.out.println(t2.a+" "+t2.b+" "+t2.c.a+" "+t1.c.b);
	}

}
