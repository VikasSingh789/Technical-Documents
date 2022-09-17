package com.programs;

public class ReverseStringByWord {
	
			//Vikas Singh
			//sakiV hgniS
			//Singh Vikas
			//hgniS sakiV
	
	static void swapString(String rev) {
		
		String arr[] = rev.split(" ");
		String swap = "";
		for(int i=arr.length-1;i>=0;i--) {
		swap = swap+arr[i]+" ";	
		}
		System.out.println(swap.trim());
	}

	public static void main(String[] args) {
		
		StringBuffer sb = new StringBuffer("Vikas Singh");
		swapString(sb.reverse().toString());
	}

}
