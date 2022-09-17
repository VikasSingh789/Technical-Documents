package com.programs;

import java.util.Map;
import java.util.TreeMap;

public class CountDuplicatesStringsOccurances {
	
	public static void duplicateString(String str) {
		String strArr[] = str.split(" ");
		TreeMap<String, Integer> map = new TreeMap<String, Integer>();
		for (String string : strArr) {
			if(map.containsKey(string)) {
				map.put(string, map.get(string)+1);
			}
			else {
				map.put(string, 1);
			}
		}
		System.out.println(map);
		for (Map.Entry<String,Integer> string1 : map.entrySet()) {
			if(string1.getValue()==1) {
				//System.out.print(string1.getKey()+" contains "+string1.getValue()+" times" );
				System.out.print(string1.getKey()+" " );
			} 		
			}
		
		
	}

	public static void main(String[] args) {
		
		String str = "I am doing java java";
		duplicateString(str);

	}

}
