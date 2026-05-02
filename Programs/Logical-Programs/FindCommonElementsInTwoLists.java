package com.programs;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FindCommonElementsInTwoLists {
	public static void main(String[] args) {
		List<Integer> list1 = Arrays.asList(1, 2, 3);
		List<Integer> list2 = Arrays.asList(1, 2, 4);
		list1.stream().filter(l1 -> list2.contains(l1)).forEach(System.out::println);
		// or
		List<Integer> commonList = list1.stream().filter(l1 -> list2.contains(l1)).collect(Collectors.toList());
		commonList.stream().forEach(n -> System.out.println(n));
	}
}
//Input:-
//list1 = Arrays.asList(1,2,3);
//list2 = Arrays.asList(1,2,4);

//Output:-
//1,2