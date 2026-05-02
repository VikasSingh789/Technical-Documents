package com.programs;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FindFirstRepeatingCharacter {
	public static void main(String[] args) {
		String str = "aabbc";
		
		Map<Character, Long> mapResult = str.chars().mapToObj(c -> (char) c)
				.collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()));
		
		mapResult.entrySet().stream().filter(entry -> entry.getValue() > 1).map(Map.Entry::getKey).findFirst().ifPresent(System.out::println);
		//or
		Character c = mapResult.entrySet().stream().filter(entry -> entry.getValue() > 1).map(key -> key.getKey()).findFirst().orElse(null);
		System.out.println(c);
	}
}
//str.chars() gives you a stream of int values
//So we convert each int to a Character object
//Input:- aabbc
//Output:- a