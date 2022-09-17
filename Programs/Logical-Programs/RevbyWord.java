package com.nt.string;

import java.util.LinkedHashSet;
import java.util.Scanner;

public class RevbyWord {

	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		System.out.println("enter the String");
		String str=scan.nextLine();
		String words[]=str.split(" ");
		String rev="";
		for(int i=0;i<words.length;i++){
			for(int j=words[i].length()-1;j>=0;j--){
				rev+=words[i].charAt(j);
			}
			System.out.print(rev+" ");
		rev="";	
		}
		}
	}
