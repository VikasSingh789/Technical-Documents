package com.nt.Programs;

import java.util.Scanner;

public class Recursion {
	public void m1(int x,int y){
			if(x<=y){
				System.out.println(x);
				x++;
				this.m1(x,y);
			}	
			else{
				return;
			}
		}
	public static void main(String[] args) {
		System.out.println("enter the number");
		Scanner scan=new Scanner(System.in);
		//int n=scan.nextInt();
		int m=scan.nextInt();
		Recursion r=new Recursion();		
		r.m1(1,m);

	}

}
