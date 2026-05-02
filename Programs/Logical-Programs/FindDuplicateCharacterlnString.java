package com.programs;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FindDuplicateCharacterlnString {
	public static void main(String[] args) {
		String str = "programming";
		Map<Character, Long> mapResult = str.chars().mapToObj(c -> (char) c)
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		mapResult.entrySet().stream().filter(n -> n.getValue() > 1)
				.forEach(entry -> System.out.println(entry.getKey() + " -> " + entry.getValue()));
	}
}

//str.chars() gives you a stream of int values //So we convert each int to a Character object

//Input:- programming

//Output:-
//r -> 2
//g -> 2
//m -> 2