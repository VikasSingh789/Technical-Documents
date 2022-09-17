package com.venk;

import java.util.Scanner;

public class NearPalin {
	public static boolean checkPalin(int num){
		String st="";
		int temp=num;
		while(temp>0){
			st=st+temp%10;
			temp=temp/10;
		}
		temp=Integer.parseInt(st);
		if(temp==num){
			return true;
		}
		return false;
	}
	public static void main(String[] args) {
		
		int forw=0,back=0,forP=0,bacP=0;
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the number");
		int num=sc.nextInt();
		
		if(checkPalin(num)){
			System.out.println("its Palindrome numb");
		}
		else{
			
			for(int i=num+1;i<=(num+1000);i++){
				if(checkPalin(i)){
					forP=i;
					System.out.println("Forward nearest Palin is"+i);
					forw=i-num;
					break;
				}
				
				
			}
			for(int i=num-1;i>num-1000;i--){
				if(checkPalin(i)){
					bacP=i;
					System.out.println("Backward nearest Palin is"+i);
					back=num-i;
					break;
				}
			}
			
			if(forw>back){
				System.out.println("Nearest palin is "+bacP);
			}
			else{
				System.out.println("Nearest Palin is "+forP);
			}
		}

	}

}
