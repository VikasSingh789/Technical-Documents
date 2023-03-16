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
		
		System.out.println("second smallest Number:- "+secmin+" found in position:-"+position);
		
		int max = arr[0];
		int secmax = arr[1];
		for(int i=0;i<arr.length;i++){
			if(arr[i]>max){
				max = arr[i];
			}
		}
		
		int secMaxPosition = 0;
		for(int i=0;i<arr.length;i++) {
			if(arr[i]>=secmax && arr[i]!=max) {
				secmax = arr[i];
				secMaxPosition=i+1;
			}
		}
		System.out.println("second largest Number:- "+secmax+" found in position:-"+secMaxPosition);
		
        }

	}


