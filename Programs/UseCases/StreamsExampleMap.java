package com.practice;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class StreamsExampleMap {

	int id;
	String name;

	public StreamsExampleMap(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public static void main(String[] args) {

		StreamsExampleMap s1 = new StreamsExampleMap(1, "vikas");
		StreamsExampleMap s2 = new StreamsExampleMap(2, "akash");
		StreamsExampleMap s3 = new StreamsExampleMap(3, "Abhishek");

		Map<Integer, StreamsExampleMap> map = new HashMap<Integer, StreamsExampleMap>();

		// Map<Integer,StreamsExampleMap> map= new ConcurrentHashMap<Integer,StreamsExampleMap>();
		map.put(1, s1);
		map.put(2, s2);
		map.put(3, s3);
		// map.put(null, s1); // Executes during HashMap, but will get NPE while using ConcurrentHashmap

		System.out.println("By Using For Loop");
		for (Map.Entry<Integer, StreamsExampleMap> m : map.entrySet()) {
			StreamsExampleMap filter = m.getValue();
			// map.put(null, s3);
			System.out.println(m.getKey() + ":" + filter.id + ":" + filter.name);
		}

		System.out.println("--------------------------------------");

		System.out.println("By Using Iterator");
		Set set = map.entrySet();
		Iterator<Map.Entry<Integer, StreamsExampleMap>> itr = set.iterator();
		while (itr.hasNext()) {
			Map.Entry<Integer, StreamsExampleMap> value = itr.next();
			System.out.println(value.getKey() + ":" + value.getValue().name.toString());
		}

		System.out.println("--------------------------------------");

		System.out.println("By Using Streams");
		map.entrySet().stream().forEach(n -> {
			System.out.println(n.getKey() + ":" + n.getValue().name);
		});

	}

}
