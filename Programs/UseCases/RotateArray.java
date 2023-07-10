package com.practice;

public class RotateArray {
	
	public static void main(String[] args) {
		int arr[] = {1,3,5,-1,2,0};
		
		int len = arr.length;
		
		for(int i=0;i<3;i++) {
			
			int last = arr[len-1];
			
			for(int j=len-1;j>0;j--) {
				arr[j] = arr[j-1];
			}
			arr[0]=last;
		}
		
		for(int a : arr) {
			System.out.println(a);
		}
	}

}
