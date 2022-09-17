package com.programs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamsExample {
	
	public int id;
	public String name;
	public int age;

	public StreamsExample(int id, String name, int age) {
		this.id = id;
		this.name = name;
		this.age = age;
	}

	public static void main(String[] args) {
		
		StreamsExample s1 = new StreamsExample(1,"vikas",27);
		StreamsExample s2 = new StreamsExample(2,"Akash",25);
		StreamsExample s3 = new StreamsExample(3,"Abhishek",19);
		
		List<StreamsExample> list = new ArrayList<>();
		list.add(s1);
		list.add(s2);
		list.add(s3);
		//List<Integer> persons = list.stream().filter(x->x.age>25).map(x->x.age).collect(Collectors.toList());
		List<String> persons = list.stream().filter(x->x.age>25).map(y->y.name).collect(Collectors.toList());
		System.out.println(persons);
		List<String> names = Arrays.asList("Vikas","Akash","Bindu","Darshan","Charan","Duggu","Das");
		List<String> FilteredSorted = names.stream().filter(x->x.startsWith("D")).sorted().collect(Collectors.toList());
		System.out.println(FilteredSorted);
		System.out.println("Before Sort:-"+names);
		Collections.sort(names, Collections.reverseOrder());
		System.out.println("Reverse Sort:-"+names);
		List<?> SortedNames = names.stream().sorted().collect(Collectors.toList());
		System.out.println("Sort:-"+SortedNames);
		List<?> filteredNames = names.stream().filter(x->x.startsWith("v")).collect(Collectors.toList());
		System.out.println("Filtered:-"+filteredNames);
		
		Map<String, String> cityMap = new HashMap<>();

		cityMap.put("Tokyo", "Japan");
		cityMap.put("Berlin", "Germany");
		cityMap.put("Kyoto", "Japan");
		cityMap.put("Belgrade", "Serbia");
		cityMap.put("Madrid", "Spain");
		
		Map filtered = cityMap.entrySet().stream().filter(x->x.getValue().equalsIgnoreCase("Japan")).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
		System.out.println(filtered);
		String keyFiltered = cityMap.entrySet().stream().filter(x->x.getValue().equalsIgnoreCase("Japan")).map(Map.Entry::getKey).collect(Collectors.joining(", "));
		System.out.println(keyFiltered);
	}
}
