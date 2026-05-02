package com.programs;

public class ReverseString {

	static void reverseString(char s[], int left, int right) {
		if (left >= right)
			return;

		// swap characters
		char temp = s[left];
		s[left] = s[right];
		s[right] = temp;

		reverseString(s, left + 1, right - 1);
	}

	public static void main(String[] args) {
		String str = "hello";
		char[] s = str.toCharArray();
		reverseString(s, 0, s.length - 1);
		System.out.println("Reversed String: " + new String(s));
	}
}