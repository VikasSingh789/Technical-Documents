package com.programs;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

public class BetweenOccuranceinArray {

	static void withJava7(int[] inputArray) {
		Map<String, Integer> outputMap = new LinkedHashMap<>();

		// Java7
		for (int a : inputArray) {
			int range = (a - 1) / 10 + 1;
			String key = "between " + ((range - 1) * 10 + 1) + " to " + (range * 10);
			outputMap.put(key, outputMap.getOrDefault(key, 0) + 1);
		}

		System.out.println(outputMap);
	}

	static void withJava8(int[] inputArray) {
		Map<String, Integer> outputMap = new LinkedHashMap<>();
		Arrays.stream(inputArray).mapToObj(a -> {
			int range = (a - 1) / 10 + 1;
			return "between " + ((range - 1) * 10 + 1) + " to " + (range * 10);
		}).forEach(key -> outputMap.put(key, outputMap.getOrDefault(key, 0) + 1));

		System.out.println(outputMap);
	}

	public static void main(String[] args) {

		int[] inputArray = { 1, 5, 6, 10, 17, 19, 25, 30, 75, 100 };
		BetweenOccuranceinArray.withJava7(inputArray);
		BetweenOccuranceinArray.withJava8(inputArray);
	}
}

//input:-   { 1, 5, 6, 10, 17, 19, 25, 30, 75, 100 }
//output:-  {between 1 to 10=4, between 11 to 20=2, between 21 to 30=2, between 71 to 80=1, between 91 to 100=1}
