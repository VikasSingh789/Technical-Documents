package com.programs;

public class MinWindowSizeSubArray {
	
	public static int minSubArrayLen(int[] nums, int target) {
	    int left = 0, sum = 0;
	    int minLength = nums.length + 1;

	    for (int right = 0; right < nums.length; right++) {
	        sum += nums[right];

	        while (sum >= target) {
	            minLength = Math.min(minLength, right - left + 1);
	            sum -= nums[left++];
	        }
	    }

	    return minLength == nums.length + 1 ? 0 : minLength;
	}
	
	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 4};
		int target = 7;
		System.out.println(minSubArrayLen(arr, target));
	}

}

//Input:- { 1, 2, 3, 4}
//Output:- 2 => No. of Indexes to match the Target Value
