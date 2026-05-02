package com.programs;

public class SmallestPalindromeFinder {

	public static void main(String[] args) {
		String input = "abaabaa";
		String smallestPalindrome = findSmallestPalindrome(input);

		if (smallestPalindrome != null) {
			System.out.println("Smallest Palindrome:" + smallestPalindrome);
		} else {
			System.out.println("No palindrome found!");
		}

	}

	public static String findSmallestPalindrome(String str) {
		if (str == null || str.isEmpty()) {
			return null;
		}

		String smallest = null;

		// Iterate through all substrings
		for (int i = 0; i < str.length(); i++) {
			for (int j = i + 2; j <= str.length(); j++) {
				String sub = str.substring(i, j);

				// Check if substring is palindrome
				if (isPalindrome(sub)) {
					// Update smallest palindrome
					if (smallest == null || sub.length() < smallest.length()) {
						smallest = sub;
					}
				}
			}
		}
		return smallest;
	}

	private static boolean isPalindrome(String str) {
		String temp = "";
		for (int i = str.length() - 1; i >= 0; i--) {
			temp = temp + str.charAt(i);
		}
		return temp.equals(str);
	}
}