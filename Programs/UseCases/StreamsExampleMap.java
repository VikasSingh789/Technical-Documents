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
		
		System.out.println("--------------------------------------");
		
		//Inp = {apple: 40, mango: 32, orange: 68, grapes: 25, banana: 32 }
		//Out = {grapes: 25, mango: 32, banana: 32, apple: 40, orange: 68}
		
		Map<String,Integer> map1 = new TreeMap<>();
		map1.put("apple", 40);
		map1.put("mango", 32);
		map1.put("orange", 68);
		map1.put("grapes", 25);
		map1.put("banana", 32);
		Map<String, Integer> sortedByCount = map1.entrySet()
                .stream()
                .sorted((Map.Entry.<String,Integer>comparingByValue())
                .thenComparing(Map.Entry.<String,Integer>comparingByKey().reversed()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
		System.out.println(sortedByCount);
		
		System.out.println("--------------------------------------");
		
		// Inp = "Always be a good heart person"
		// Out = "a be good heart Always person”
		
		String str3 = "Always be a good heart person";
		String sp[] = str3.split(" ");
		Map<String,Integer> pam = new HashMap();
		for(String s : sp) {
			pam.put(s, s.length());
		}
		System.out.println(pam);
		Map<String,Integer> s = pam.entrySet()
					.stream()
					.sorted((Map.Entry.<String,Integer>comparingByValue())
					.thenComparing(Map.Entry.comparingByKey()))
					.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1,e2)->e1,LinkedHashMap::new));
		for(Map.Entry<String,Integer> b: s.entrySet()) {
			System.out.print(b.getKey()+" ");
		}
		System.out.println();
		System.out.println("--------------------------------------");
		
		//inp = “abCAcBDac”
		//out = “a=3,b=2,c=3,d=1”
		
		String str = "abCAcBDac";
		str=str.replaceAll(str, str.toLowerCase());
		char ch[]=str.toCharArray();
		Map<Character,Integer> map2 = new TreeMap();
		
		for (int i=0; i<ch.length;i++) {
			if(map2.containsKey(ch[i])) {
				map2.put(ch[i], map2.get(ch[i])+1);
			}else {
				map2.put(ch[i], 1);
			}
		}
		System.out.println(map2);
		for(Map.Entry<Character, Integer> obj : map2.entrySet()) {
			System.out.print(obj.getKey()+"="+obj.getValue()+",");
		}

	}

}
