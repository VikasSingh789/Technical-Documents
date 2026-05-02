package com.programs;

public class ShortestPalindrome {
	
	public static boolean isPalindrome(String str) {
		char ch[] = str.toCharArray();
		String rev = "";
		for (int i = ch.length - 1; i >= 0; i--) {
			rev = rev + ch[i];
		}
		if (rev.equals(str)) {
			return true;
		}
		return false;
	}

	public static String shortestPalindrome(String str) {
		int length = 0;
		for (int i = 0; i < str.length(); i++) {
			String checkString = str.substring(i);
			length = length + i;
			if (isPalindrome(checkString) && length <= i) {
				return "Shortest palindrome is " + checkString + " With Lenght " + length;
			}
		}
		return "No Palindrome Found";
	}

	public static void main(String[] args) {
		String s = "abaaddaa";
		System.out.println(ShortestPalindrome.shortestPalindrome(s));
	}
}