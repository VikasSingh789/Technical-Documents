package simple;
import java.util.Scanner;
public class integertobinary {

	
	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		System.out.println("enter the integer value to convert in to binary");
		int n=scan.nextInt();
		String s=Integer.toBinaryString(n);
		System.out.println("binary value for given number is:\n"+s);

	}

}
