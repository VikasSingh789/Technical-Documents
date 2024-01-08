package com.practice;

public class RotateArray {
	
	static int[] rotateBruteForce(int[] nums, int k) {
		for (int i = 0; i < k; i++) {
			for (int j = nums.length - 1; j > 0; j--) {

				int temp = nums[j];
				nums[j] = nums[j - 1];
				nums[j - 1] = temp;
			}
		}
		return nums;
	}

	static int[] rotateArray(int[] arr, int k) {
		for (int i = 0; i < k; i++) {

			int last = arr[arr.length - 1];

			for (int j = arr.length - 1; j > 0; j--) {
				arr[j] = arr[j - 1];
			}
			arr[0] = last;
		}
		return arr;
	}

	public static void main(String[] args) {
		int arr[] = { 1, 2, 3, 4, 5, 6 };
		//arr = rotateArray(arr, 3);
		arr = rotateBruteForce(arr, 3);

		for (int a : arr) {
			System.out.print(a + " ");
		}
	}
}

//input:-   1, 2, 3, 4, 5, 6  ,rotatePosition = 3
//output:-  4 5 6 1 2 3
