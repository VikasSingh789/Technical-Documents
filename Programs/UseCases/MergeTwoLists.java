package com.programs;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MergeTwoLists {
	public static void main(String[] args) {
		
		List<Integer> list1 = Arrays.asList(1, 2, 3);
		List<Integer> list2 = Arrays.asList(1, 3, 4);
		Stream.concat(list1.stream(), list2.stream()).distinct().forEach(System.out::println);
		//or
		List<Integer> finalList = Stream.concat(list1.stream(), list2.stream()).distinct().collect(Collectors.toList());
		System.out.println(finalList);
		
	}
}