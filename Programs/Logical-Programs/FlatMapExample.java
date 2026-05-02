package com.programs;

import java.util.List;
import java.util.stream.Collectors;

public class FlatMapExample {
	public static void main(String[] args) {
		List<String> words = List.of("Hungry", "Coders");
		List<Character> characters = words.stream().flatMap(word -> word.chars().mapToObj(c -> (char) c))
				.collect(Collectors.toList());
		System.out.println(characters);
		characters.stream().forEach(n -> System.out.print(n));
	}
}

//Input:- List.of("Hungry","Coders")
//Output:- HungryCoders