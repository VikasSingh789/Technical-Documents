package simpleprograms;

class Clone1{
	int x,y;
}
class Clone2 implements Cloneable{
	int a,b;
	Clone1 c1 = new Clone1();
	public Object clone() throws CloneNotSupportedException {
		//return super.clone();  --> Shallow Copy
		Clone2 c2= (Clone2)super.clone();  //--> Deep Copy
		c2.c1 = new Clone1();
		return c2;
	}
}

public class CloneExample2 {
	public static void main(String[] args) throws CloneNotSupportedException {
		Clone2 c2= new Clone2();
		c2.a=10;
		c2.b=20;
		c2.c1.x=100;
		c2.c1.y=100;
		System.out.println(c2.a+" "+c2.b+" "+c2.c1.x+" "+c2.c1.y);
		
		Clone2 c21 = (Clone2)c2.clone();

		c21.a=100;
		c21.c1.x=101;
		System.out.println(c21.a+" "+c21.b+" "+c21.c1.x+" "+c21.c1.y);
		
	}

}
