package com.nt.string;

import java.util.Scanner;

public class RevString {

	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		System.out.println("enter the number");
		/*String str=scan.nextLine();
		char c[]=str.toCharArray();
		for(int i=c.length-1;i>=0;i--){
			System.out.print(c[i]);
		}*/
		int sum=0;
		int n=scan.nextInt();
		int temp=n;
		while(n>0){
			int rem=n%10;
			n=n/10;
			sum=sum+(rem*rem*rem);
		}
		if(temp==sum)
		System.out.println("armstrong");
		else
			System.out.println("Not Armstrong");
	}

}
