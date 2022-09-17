package com.nt.Logicals;

import java.util.Scanner;

public class SortingOrder {
public static void main(String[] args) {
	Scanner scan=new Scanner(System.in);
	System.out.println("enter the size of elements");
	int n=scan.nextInt();
	int a[]=new int[n];
	System.out.println("enter the elements");
	for(int i=0;i<n;i++){
		a[i]=scan.nextInt();
	}
	for(int i=0;i<n;i++){
		for(int j=i+1;j<n;j++){
			if(a[i]>a[j]){
				//true, then store the first element of an array in temp var
				
				int temp=a[i];
				a[i]=a[j];
				a[j]=temp;
			}
		}
	}
	System.out.println("sorted elements are");
	for(int i=0;i<n;i++){
		System.out.print(a[i]+" ");
	}
	System.out.println("\nsecond largest element is");
	System.out.println(a[1]);
}
}
