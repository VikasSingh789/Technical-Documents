package com.programs;

public class BalancedParanthesis {

	static int balancedParanthesis(String s) {
		int openBrackets = 0;
		int addBrackets = 0;
		for (char c : s.toCharArray()) {
			if (c == '(') {
				openBrackets++;
			} else if (c == ')') {
				if (openBrackets > 0) {
					openBrackets--; // match one '('
				} else {
					addBrackets++;// need one '('
				}
			}
		}
		return addBrackets + openBrackets;
	}

	public static void main(String[] args) {
		System.out.println(balancedParanthesis("((()"));
		System.out.println(balancedParanthesis("((())"));
	}
}

//Input:- ((()
//Output:- 2
//Input:- ((())
//Output:- 1