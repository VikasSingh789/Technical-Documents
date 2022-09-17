package com.nt.string;

import java.util.LinkedHashSet;
import java.util.Scanner;

public class Removeduplicates {

	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		System.out.println("enter the String");
		String str=scan.nextLine();
		char[] ch=str.toCharArray();
		LinkedHashSet<Character> chars=new LinkedHashSet<Character>();
		for(char c:ch){
			chars.add(c);
		}
		StringBuilder sb=new StringBuilder();
		for(Character cha:chars){
			sb.append(cha);
		}
		System.out.println("String after removing duplicates="+sb.toString());

	}

}
