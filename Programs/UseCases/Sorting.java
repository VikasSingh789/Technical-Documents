package com.programs;

public class Sorting {

	public static void main(String[] args) {

		int a[] = { 0, 1, 4, 3, 2, 0 };
		int result[] = new int[a.length];
		int index = 0;

		// First for-each loop: place zeros at the beginning
		for (int num : a) {
			if (num == 0) {
				result[index++] = 0;
			}
		}

		// Second for-each loop: add non-zero elements
		for (int num : a) {
			if (num != 0) {
				result[index++] = num;
			}
		}

		for (int i = 0; i < result.length; i++) {
			System.out.print(result[i] + " ");
		}
	}
}