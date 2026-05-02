package com.programs;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FindAllMissingNumberFromArray {
	public static void main(String[] args) {
		int arr[] = { 1, 1, 2, 4, 6, 7 };
		int max = Arrays.stream(arr).max().getAsInt();
		int min = Arrays.stream(arr).min().getAsInt();
		
		Set<Integer> collect = Arrays.stream(arr) // IntStream
				.boxed() // Convert to Stream<Integer>
				.collect(Collectors.toSet());
		List<Integer> result = IntStream.rangeClosed(min, max).boxed().filter(n -> !collect.contains(n)).collect(Collectors.toList());
		System.out.println(result);
	}
}

//Boxed:- boxed() is used to convert primitive streams -> Wrapper Object Streams
//Example:-
//intStream -> Stream<Integer>
//LongStream -> Stream<Long>

//Why do we Need ?
//So that, It can be used with Collections Operations like .collect, map and set.
//Without Use, We can't collect the Result
//Set<Integer> collect = Arrays.stream(arr).collect(Collectors.toSet()); // Can't Collect. Compile Error. Use boxed()