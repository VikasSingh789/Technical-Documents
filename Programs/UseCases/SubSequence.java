package com.programs;

public class SubSequence {

	static boolean isSubsequence(String s, String t) {
		int n = s.length();
		int m = t.length();

		int i = 0, j = 0;
		while (i < n && j < m) {
			if (s.toCharArray()[i] == t.toCharArray()[j]) {
				i++;
			}
			j++;
		}

		return (i == n);
	}

	public static void main(String[] args) {
		System.out.println(isSubsequence("abc", "ahbgdc"));
		System.out.println(isSubsequence("abcz", "ahbgdc"));
	}
}

//Input:- s= abc, target = ahbgdc
//Output:- true

//Input:- s= abcz, target = ahbgdc
//Output:- false