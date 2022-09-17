package com.nt.Programs;

import java.util.Scanner;

public class AlternatePrimeNumbers {

	public static void main(String[] args) {
		int c;
		Scanner scan=new Scanner(System.in);
		System.out.println("enter the number");
		int n=scan.nextInt();
		int i=0;
		int y=1;
		for(i=1;i<=n;i++)
		{
			c=0;
			for(int j=1;j<=i;j++){
				if(i%j==0)
					c=c+1;
			}
				if(c==2){
				System.out.println("prime number is:"+i);
				y=y+1;
				if(y%2==0){
				System.out.println("Alternate prime number's are" +i);
				}
	}
	}
	}
}
