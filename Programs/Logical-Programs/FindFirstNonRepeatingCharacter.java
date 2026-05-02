package com.programs;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FindFirstNonRepeatingCharacter {
	public static void main(String[] args) {
		String str = "aabbc";
		
		Map<Character, Long> mapResult = str.chars().mapToObj(c -> (char) c)
				.collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()));
		
		Entry<Character, Long> c = mapResult.entrySet().stream().filter(entry -> entry.getValue() == 1).findFirst().orElse(null);
		System.out.println(c);
		//or
		mapResult.entrySet().stream().filter(entry -> entry.getValue() == 1).findFirst().map(key -> key.getKey()).orElse(null);
		//or 
		mapResult.entrySet().stream().filter(entry->entry.getValue()==1).findFirst().map(Map.Entry::getKey).orElse(null);
	}
}
//str.chars() gives you a stream of int values
//So we convert each int to a Character object

//Input:- aabbc
//Output:- c