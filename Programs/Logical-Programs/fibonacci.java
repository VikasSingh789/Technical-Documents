package simple;

import java.util.Scanner;
public class fibonacci {
	public static void main(String[] args){ 
		Scanner scan=new Scanner(System.in);
		int a=0;
		int b=0;
		int c=1;
		System.out.println("enter the limit");
		int d=scan.nextInt();
		System.out.println(" "+b);
		for(int i=0;i<d;i=i+1){
			System.out.println(" "+c);
			a=b;
			b=c;
			c=a+b;
	}
	}
}