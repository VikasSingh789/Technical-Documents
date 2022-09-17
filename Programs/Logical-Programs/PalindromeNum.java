package com.venk;

import java.util.Scanner;

public class PalindromeNum {

	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		System.out.println("enter the number");
		int n=scan.nextInt();
		int temp=n;
		String st="";
		while(temp>0){
			st=st+temp%10;
			temp=temp/10;
		}
		temp=Integer.parseInt(st);
		if(n==temp){
			System.out.println("Palindrom numb");
		}
		else{
			System.out.println("not palin");
			
		}
	}

}
