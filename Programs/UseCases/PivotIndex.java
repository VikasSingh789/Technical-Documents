package com.programs;

import java.util.Arrays;

public class PivotIndex {

	private static int findPivotIndex(int[] arr) {
		int totalSum = Arrays.stream(arr).sum();
		int leftSum = 0;
		for (int i = 0; i < arr.length; i++) {
			int rightSum = totalSum - leftSum - arr[i];
			if (leftSum == rightSum) {
				return i;
			}
			leftSum += arr[i];
		}
		return -1;
	}

	public static void main(String[] args) {
		int[] arr1 = {1, 2, 3, 2, 1};
		int[] arr2 = { 1, 2, 3, 8, 0, 3, 2, 1 };
		System.out.println(findPivotIndex(arr1));
		System.out.println(findPivotIndex(arr2));
	}

}


//Input:- {1, 2, 3, 2, 1}
//Output:- 2 =>Index

//Input:- { 1, 2, 3, 8, 0, 3, 2, 1 }
//Output:- 3 =>Index
//It has nothing to do with Element 8. It Just check from Which Index, Left and Right Sun is Same.