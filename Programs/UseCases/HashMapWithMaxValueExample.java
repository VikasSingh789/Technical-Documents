package com.programs;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class HashMapWithMaxValueExample {
	
	//Find Maximum value with Corresponding Key from Map Object using Java7 Without Collections
	static void withoutCollections(Map<String, Integer> map) {
		int tempValue = 0;
		String tempKey = "";

		for (Map.Entry<String, Integer> filters : map.entrySet()) {

			if (filters.getValue() >= tempValue) {
				tempValue = filters.getValue();
				tempKey = filters.getKey();
			}
		}
		System.out.println(tempKey + " " + tempValue);
	}

	//Find Maximum value with Corresponding Key from Map Object using Java7 with Collections
	static void withCollections(Map<String, Integer> map) {
		int max = Collections.max(map.values());

		for (Map.Entry<String, Integer> filters : map.entrySet()) {

			if (filters.getValue() >= max) {
				System.out.println(filters.getKey() + " " + filters.getValue());
			}
		}
	}
	
	//Find Maximum value with Corresponding Key from Map Object using Java8 using Streams
	static void withJava8Streams(Map<String, Integer> map) {
		Entry<String, Integer> maxValue = map.entrySet().stream().max(Comparator.comparing(Map.Entry::getValue)).get();
		System.out.println(maxValue.getKey() + " " + maxValue.getValue());
	}

	public static void main(String[] args) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("vikas", 1);
		map.put("vivek", 2);
		map.put("abc", 4);
		map.put("akash", 3);

		withoutCollections(map);
		withCollections(map);
		withJava8Streams(map);

	}

}



