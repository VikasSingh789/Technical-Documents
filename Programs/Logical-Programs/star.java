package simple;
import java.util.Scanner;
public class SwapString {
	static void swapString(String a, String b) {
		System.out.println("Before Swap: a= " + a + ", b= " + b);
		a = a.concat("0" + b);
		b = a.split("0")[0];
		a = a.split("0")[1];
		System.out.println("After Swap: a= " + a + ", b= " + b);
	}

	public static void main(String args[]) {
		String a = "Vikas";
		String b = "Singh";
		swapString(a, b);
	}
}


//input:-  a=Vikas, b=Singh
//output:- a=Singh, b=Vikas
