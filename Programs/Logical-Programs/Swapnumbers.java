public class Swapnumbers {
	
	static void swapOnNumbers(int a, int b) {
		System.out.println("Before Swap: a= " + a + ", b= " + b);
		a=a+b;
		b=a-b;
		a=a-b;
		System.out.println("After Swap: a= " + a + ", b= " + b);
	}
	
	static void swapOnNumbersByTemp(int a, int b) {
		System.out.println("Before Swap: a= " + a + ", b= " + b);
		int temp = a;
		a=b;
		b=temp;
		System.out.println("After Swap: a= " + a + ", b= " + b);
	}

	public static void main(String[] args) {
		swapOnNumbers(10, 20);
		System.out.println();
		System.out.println("By Temporary Variable");
		swapOnNumbersByTemp(10, 20);
	}

}

//input:-   a=10, b=20
//output:-  a=20, b=10
