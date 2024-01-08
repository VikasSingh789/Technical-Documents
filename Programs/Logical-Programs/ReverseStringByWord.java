package com.programs;

public class ReverseStringByWord {
	static void revStringByWord1(String rev) {

		String arr[] = rev.split(" ");
		String swap = "";
		for (int i = arr.length - 1; i >= 0; i--) {
			swap = swap + arr[i] + " ";
		}
		System.out.println(swap.trim());
	}

	static void revStringByWord2(String str) {
		String words[] = str.split(" ");
		for (int i = 0; i < words.length; i++) {
			String rev = "";
			for (int j = words[i].length() - 1; j >= 0; j--) {
				rev += words[i].charAt(j);
			}
			System.out.print(rev + " ");
		}
	}

	public static void main(String[] args) {

		StringBuffer sb = new StringBuffer("Vikas Singh");
		revStringByWord1(sb.reverse().toString());
		System.out.println("==================");
		String str = "Vikas Singh";
		revStringByWord2(str);

	}
}

//output:-
//Vikas Singh
//sakiV hgniS
//Singh Vikas
//hgniS sakiV
