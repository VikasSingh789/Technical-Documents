package com.nt.Programs;

import java.util.ArrayList;
import java.util.Scanner;

public class Duplicates {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("enter the String");
		String s=scan.nextLine();
		char[] c=s.toCharArray();
		for(int i=0;i<c.length;i++){
			int count=1;
			if(c[i]!=' '){
			for(int j=i+1;j<c.length;j++){
				if(c[i]==c[j]){
					count++;
					c[j]=' ';				
				}
				}
			if(count>1){
				System.out.println("duplicates are:"+c[i]+" contains "+count+" times");
			}
			}	
			}
		}
}
