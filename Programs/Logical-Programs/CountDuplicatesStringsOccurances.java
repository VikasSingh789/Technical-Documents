package com.programs;

import java.util.Map;
import java.util.TreeMap;

public class CountDuplicatesStringsOccurances {
	
	public static void duplicateString(String str) {
		String strArr[] = str.split(" ");
		TreeMap<String, Integer> map = new TreeMap<String, Integer>();
		for (String string : strArr) {
			if (map.containsKey(string)) {
				map.put(string, map.get(string) + 1);
			} else {
				map.put(string, 1);
			}
		}
		System.out.println(map);
		for (Map.Entry<String, Integer> word : map.entrySet()) {
			if (word.getValue() > 1) {
				System.out.println(word.getKey() + " contains " + word.getValue() + " times");
			}
		}
	}

	public static void main(String[] args) {

		String str = "I am doing java java";
		duplicateString(str);

	}
}

//Input:-  I am doing java java
//Output:- java contains 2 times
