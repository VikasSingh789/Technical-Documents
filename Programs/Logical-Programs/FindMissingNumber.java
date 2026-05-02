package com.programs;

import java.util.Arrays;

public class FindMissingNumber {

	public static int findMissingNumberFromArrayUsingGAUSS(int a[]) {
		int n;
		if (Arrays.stream(a).max().getAsInt() == a.length) {
			n = a.length;
		} else {
			n = a.length + 1;
		}
		int expectedSum = n * (n + 1) / 2;
		int actualSum = Arrays.stream(a).sum();
		return expectedSum - actualSum;
	}

	public static void findMissingNumberFromArrayUsingXOR(int a[]) {
		int x1 = 0;
		int x2 = 0;
		for (int i = 0; i < a.length - 1; i++) {
			x1 = x1 ^ a[i];
		}
		for (int i = 1; i <= a.length; i++) {
			x2 = x2 ^ i;
		}
		System.out.println(x1 ^ x2);
	}

	public static void main(String[] args) {
		int arr1[] = { 3, 1, 0, 4, 5 };
		int arr2[] = { 1, 2, 4, 5 };
		System.out.println(findMissingNumberFromArrayUsingGAUSS(arr1));
		System.out.println(findMissingNumberFromArrayUsingGAUSS(arr2));
		findMissingNumberFromArrayUsingXOR(arr2);
	}
}
//Input:- {3, 1, 0, 4, 5}
//Output:- 2
//Input:- {1, 2, 4, 5}
//Output:- 3