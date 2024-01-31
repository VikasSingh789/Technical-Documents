package com.practice;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class StreamsExampleMap {

	int id;
	String name;
	int dept;
	int sal;

	public StreamsExampleMap(int id, String name, int dept, int sal) {
		super();
		this.id = id;
		this.name = name;
		this.dept = dept;
		this.sal = sal;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getDept() {
		return dept;
	}

	public void setDept(int dept) {
		this.dept = dept;
	}

	public int getSal() {
		return sal;
	}

	public void setSal(int sal) {
		this.sal = sal;
	}

	public static void main(String[] args) {

		StreamsExampleMap s1 = new StreamsExampleMap(2, "akash", 1, 1000);
		StreamsExampleMap s2 = new StreamsExampleMap(1, "vikas", 1, 2000);
		StreamsExampleMap s3 = new StreamsExampleMap(3, "Abhishek", 2, 3000);
		StreamsExampleMap s4 = new StreamsExampleMap(4, "Baron", 2, 5000);
		StreamsExampleMap s5 = new StreamsExampleMap(5, "Catherine", 3, 5000);

		Map<Integer, StreamsExampleMap> map = new HashMap<Integer, StreamsExampleMap>();

		map.put(1, s1);
		map.put(2, s2);
		map.put(3, s3);
		map.put(4, s4);
		map.put(5, s5);

		List<StreamsExampleMap> list = Arrays.asList(s1, s2, s3, s4, s5);

		// Fetch Highest Salary with Employee Name From Each Department
		System.out.println("Fetch Highest Salary with Employee Name From Each Department\n");
		Map<Integer, Optional<StreamsExampleMap>> m = list.stream().collect(Collectors.groupingBy(
				StreamsExampleMap::getDept, Collectors.maxBy(Comparator.comparing(StreamsExampleMap::getSal))));
		m.entrySet().forEach(n -> {
			StreamsExampleMap values = n.getValue().get();
			System.out.println("From Department:- " + n.getKey() + ",  " + values.getName()
					+ " has Highest Salary with " + values.getSal());
		});

		System.out.println("===============================================================");

		// Fetch Employee Name by Sorting in Descending Order by Collecting the Result
		System.out.println("Fetch Employee Name by Sorting in Descending Order by Collecting the Result\n");
		Map<Integer, StreamsExampleMap> result = map.entrySet().stream()
				.sorted(Comparator.comparing(entry -> entry.getValue().getName(), Comparator.reverseOrder()))
				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
		result.entrySet().stream().forEach(n -> System.out.println(n.getValue().getName()));

		System.out.println("\nor Print Directly: WithOut Storing the Result\n");

		// Print Directly: WithOut Storing the Result
		map.entrySet().stream()
				.sorted(Map.Entry
						.comparingByValue(Comparator.comparing(StreamsExampleMap::getName, Comparator.reverseOrder())))
				.forEach(n -> System.out.println(n.getKey() + " " + n.getValue().getName()));

		System.out.println("===============================================================");

		String arr[] = { "car", "bus", "bus", "train", "car", "car" };
		Map<String, Integer> map1 = new HashMap<>();
		for (String str : arr) {
			if (map1.containsKey(str)) {
				map1.put(str, map1.get(str) + 1);
			} else {
				map1.put(str, 1);
			}
		}

		// Fetch Element based on Most repeated Occurances and Collect the Result
		System.out.println("Fetch Element based on Most repeated Occurances\n");
		Map<String, Integer> mapResult = map1.entrySet().stream()
				.sorted((Map.Entry.<String, Integer>comparingByValue()).reversed())
				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
		mapResult.entrySet().stream().map(Map.Entry::getKey).forEach(n -> System.out.println(n));

		System.out.println("\nor Print Directly: WithOut Storing the Result\n");
		map1.entrySet().stream()
				.sorted((Map.Entry.<String, Integer>comparingByValue()).reversed()
						.thenComparing(Map.Entry.<String, Integer>comparingByValue()))
				.forEach(n -> System.out.println(n.getKey()));

		// input:- { "car", "bus", "bus", "train", "car", "car" };
		// output:- car, bus, train //print Based on Most repeated Occurances

		System.out.println("===============================================================");

		// Inp = {apple: 40, mango: 32, orange: 68, grapes: 25, banana: 32 }
		// Out = {grapes: 25, mango: 32, banana: 32, apple: 40, orange: 68}

		Map<String, Integer> mapOfFruits = new TreeMap<>();
		mapOfFruits.put("apple", 40);
		mapOfFruits.put("mango", 32);
		mapOfFruits.put("orange", 68);
		mapOfFruits.put("grapes", 25);
		mapOfFruits.put("banana", 32);
		Map<String, Integer> sortedByCount = mapOfFruits.entrySet().stream()
				.sorted((Map.Entry.<String, Integer>comparingByValue())
						.thenComparing(Map.Entry.<String, Integer>comparingByKey().reversed()))
				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
		System.out.println(sortedByCount);

		System.out.println("===============================================================");

		// Inp = "Always be a good heart person"
		// Out = "a be good heart Always person"

		String str3 = "Always be a good heart person";
		String sp[] = str3.split(" ");
		Map<String, Integer> pam = new HashMap<String, Integer>();
		for (String s : sp) {
			pam.put(s, s.length());
		}
		System.out.println(pam);
		pam = pam.entrySet().stream()
				.sorted((Map.Entry.<String, Integer>comparingByValue()).thenComparing(Map.Entry.comparingByKey()))
				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
		for (Map.Entry<String, Integer> b : pam.entrySet()) {
			System.out.print(b.getKey() + " ");
		}

		System.out.println("\n===============================================================");

		// inp = “abCAcBDac”
		// out = “a=3,b=2,c=3,d=1”

		String str = "abCAcBDac";
		str = str.replaceAll(str, str.toLowerCase());
		char ch[] = str.toCharArray();
		Map<Character, Integer> map2 = new TreeMap<Character, Integer>();

		for (int i = 0; i < ch.length; i++) {
			if (map2.containsKey(ch[i])) {
				map2.put(ch[i], map2.get(ch[i]) + 1);
			} else {
				map2.put(ch[i], 1);
			}
		}
		for (Map.Entry<Character, Integer> obj : map2.entrySet()) {
			System.out.print(obj.getKey() + "=" + obj.getValue() + ",");
		}

		System.out.println("\n===============================================================");

		// Filter based on stream and key from given Map Object
		Map<StreamsExampleMap, String> map5 = new HashMap<>();
		map5.put(s1, "Course1");
		map5.put(s2, "Course2");
		map5.put(s3, "Course1");
		map5.put(s4, "Course3");

		// Fetch Key When Condition Matches and Collect the Result
		System.out.println("Fetch Key When Condition Matches and Collect the Result\n");
		List<StreamsExampleMap> resuluOfFilters = map5.entrySet().stream().filter(k -> "Course1".equals(k.getValue()))
				.map(Map.Entry::getKey).collect(Collectors.toList());
		resuluOfFilters.stream().forEach(n -> System.out.println(n.getName()));

		System.out.println("\n===============================================================");

		// Fetch Only Key and Value and Print Result Directly When Condition Matches
		System.out.println("Fetch Only Key and Value and Print Directly When Condition Matches\n");
		map5.entrySet().stream().filter(n -> "Course1".equals(n.getValue()))
				.forEach(n -> System.out.println(n.getKey().getName() + " " + n.getValue()));

		System.out.println("\n===============================================================");

		// Fetch Only Key and Print Result Directly When Condition Matches
		System.out.println("Fetch Only Key and Print Directly When Condition Matches\n");
		map5.entrySet().stream().filter(k -> "Course1".equals(k.getValue())).map(Map.Entry::getKey)
				.forEach(n -> System.out.println(n.getName()));

	}

}
