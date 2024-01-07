package com.nt.Programs;

import java.util.Scanner;

public  class NearPalindrome{
	public static boolean Checkpalin(int num) {
		int sum = 0;
		int temp = num;

		while (num > 0) {
			int rem = num % 10;
			sum = sum * 10 + rem;
			num = num / 10;
		}

		if (temp == sum) {
			return true;
		}
		return false;
	}

	public static void main(String[] args) {
		int num = 122;
		int a = 0, b = 0, forw = 0, back = 0;
		if (Checkpalin(num)) {
			System.out.println("Given Number is Palindrome");
		} else {
			for (int i = num + 1; i <= (num + 1000); i++) {
				if (Checkpalin(i)) {
					a = i;
					System.out.println("Forward Nearest Palindrome is:" + i);
					forw = i - num;
					break;
				}
			}
			for (int i = num - 1; i >= num - 1000; i--) {
				if (Checkpalin(i)) {
					b = i;
					System.out.println("Backward Nearest Palindrome is:" + i);
					back = num - i;
					break;
				}
			}
			if (forw > back) {
				System.out.println("Nearest Palindrome is:" + b);
			} else {
				System.out.println("Nearest Palindrome is:" + a);
			}
		}
	}
}

//input:- 122

//output:-
//Forward Nearest Palindrome is:131
//Backward Nearest Palindrome is:121
//Nearest Palindrome is:121
