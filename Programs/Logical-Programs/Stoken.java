package com.venk;

import java.util.Scanner;
import java.util.StringTokenizer;

public class Stoken {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String st=new Scanner(System.in).nextLine();
		//System.out.println(st);
		
		
		StringTokenizer stz=new StringTokenizer(st);
		
		while (stz.hasMoreElements()) {
			/*String nav=(String)stz.nextElement();*/
			System.out.println(stz.nextElement());
		}
	}

}
