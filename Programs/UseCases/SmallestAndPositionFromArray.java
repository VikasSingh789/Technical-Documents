package com.practice;

public class SmallestAndPositionFromArray {

	public static void main(String[] args) {
		int arr[] = {5,4,3,2};
		int secmin = arr[0];
		int position = 0;
		int min = arr[0];
		for(int i=0;i<arr.length;i++) {
			if(arr[i]<min) {
				min=arr[i];
			}
		}
		for(int i=0;i<arr.length;i++) {
			if(arr[i]<secmin && arr[i]!=min) {
				secmin = arr[i];
				position = i+1;
			}
		}
		System.out.println("Second largest Number "+secmin+" Position is "+position);
		
        }

	}


