package com.programs;

import java.util.stream.IntStream;

public class Palindrome {
	public static boolean checkPalindrome(String str) {
		boolean b = IntStream.range(0, str.length() / 2).allMatch(i -> str.charAt(i) == str.charAt(str.length() - 1 - i));
		return b;
	}

	public static void main(String[] args) {
		System.out.println(checkPalindrome("madam1"));
	}
}
//Input: - Madam
//Output:- true

//Input:- Madam1
//Output:- false