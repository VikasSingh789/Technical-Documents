package com.nt.Programs;

import java.util.Scanner;

public  class NearPalindrome{
	public static boolean Checkpalin(int num){
		int sum=0;
		int temp=num;
		while(num>0){
		int rem=num%10;
		sum=sum*10+rem;
		num=num/10;
		}
		if(temp==sum){
			return true;
		}
		return false;
	}
	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		System.out.println("enter the number");
		int num=scan.nextInt();
		int a=0,b=0,forw=0,back=0;	
		if(Checkpalin(num)){
			System.out.println("given String is palindrome");
		}
			else{
				for(int i=num+1;i<=(num+1000);i++){
					if(Checkpalin(i)){
						a=i;
						System.out.println("forward nearest palindrome is:"+i);
						forw=i-num;
						break;
					}
				}
				for(int i=num-1;i>=num-1000;i--){
					if(Checkpalin(i)){
						b=i;
						System.out.println("backward nearest palindrome is:"+i);
						back=num-i;
						break;
					}
				}
			if(forw>back){
				System.out.println("nearest palindrome is:"+b);
			}
			else{
				System.out.println("nearest palindrome is:"+a);
			}
			}	
		/*int sum=0;
		int temp=num;
		while(num>0){
		int rem=num%10;
		sum=sum*10+rem;
		num=num/10;
		}
		if(temp==sum){
		System.out.println("palindrome");
	}
		else{
			System.out.println("not a palindrome");
		}
*/
}
}