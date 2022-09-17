package com.nt.string;

import java.util.Scanner;

public class Multiplicationmatrix {

	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		System.out.println("enter the order of matrix");
		int m=scan.nextInt();
	    int n=scan.nextInt();
		int a[][]=new int[m][n];
		int b[][]=new int[m][n];
		int c[][]=new int[m][n];
		int sum;
		System.out.println("enter the values for A");
		for(int i=0;i<m;i=i+1){
		for (int j=0;j<n;j=j+1){
			a[i][j]=scan.nextInt();
		}
		}
		System.out.println("enter the values for B");
		for(int i=0;i<m;i=i+1){
		for (int j=0;j<n;j=j+1){
			b[i][j]=scan.nextInt();
		}
		}
		for(int i=0;i<m;i=i+1){
			for (int j=0;j<n;j=j+1){
				sum=0;
				for(int k=0;k<n;k++){
					sum=sum+a[i][k]*b[k][j];
				}
				c[i][j]=sum;
			}
		}
			System.out.println("the multiplication of the matrix are");
			for(int i=0;i<m;i=i+1){
				for (int j=0;j<n;j=j+1){
			System.out.print(c[i][j]+" ");
			}
				System.out.println();
			}
}
}
