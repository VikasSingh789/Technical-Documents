package com.practice;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class StreamsExampleMap {

	int id;
	String name;

	public StreamsExampleMap(int id, String name) {
		super();
		this.id = id;
		this.name = name;
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

	public static void main(String[] args) {

		StreamsExampleMap s1 = new StreamsExampleMap(1, "vikas");
		StreamsExampleMap s2 = new StreamsExampleMap(2, "akash");
		StreamsExampleMap s3 = new StreamsExampleMap(3, "Abhishek");
		StreamsExampleMap s4 = new StreamsExampleMap(4, "venkatesh");

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
		
//		Inp = "Always be a good heart person"
//      Out = "a be good heart Always person"
		
		String str3 = "Always be a good heart person";
		String sp[] = str3.split(" ");
		Map<String,Integer> pam = new HashMap<String, Integer>();
		for(String s : sp) {
			pam.put(s, s.length());
		}
		System.out.println(pam);
		pam = pam.entrySet().stream()
							.sorted((Map.Entry.<String,Integer>comparingByValue())
							.thenComparing(Map.Entry.comparingByKey()))
							.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1,e2)->e1,LinkedHashMap::new));
		for(Map.Entry<String,Integer> b: pam.entrySet()) {
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
		System.out.println();
		System.out.println("-------------------------------------->");
		
		//Mutable Object
		final Map<StreamsExampleMap,Integer> map3 = new HashMap<>();
		map3.put(s1, 40);
		map3.put(s2, 30);
		map3.put(s3, 60);
	
		final Map<StreamsExampleMap,Integer> map4 = map3;
		map4.put(s1, 40);
		map4.put(s2, 31);
		
		for(Map.Entry<StreamsExampleMap, Integer> obj1 : map4.entrySet()) {
			System.out.println(obj1.getKey().name+"="+obj1.getValue());
		}
		
		System.out.println("--------------------------------------");
		
		//filter based on stream and key
		Map<StreamsExampleMap,String> map5 = new HashMap<>();
		map5.put(s1, "Course1");
		map5.put(s2, "Course2");
		map5.put(s3, "Course1");
		map5.put(s4, "Course3");
		
		List<StreamsExampleMap> lisOfResults = map5.entrySet()
				.stream()
				.filter(k->"Course1".equals(k.getValue()))
				.map(Map.Entry::getKey).collect(Collectors.toList());
				for(StreamsExampleMap lr: lisOfResults) {
					System.out.println(lr.getId()+" "+lr.getName());
				}
				
		System.out.println("(or)");
		
		
		map5.entrySet()
		.stream()
		.filter(k->"Course1".equals(k.getValue()))
		.map(n->n.getKey().name).forEach(System.out::println);
		
		
		System.out.println("(or)");
		
		Map<StreamsExampleMap,String> result= map5.entrySet().stream()
				.filter(k->"Course1".equals(k.getValue()))
				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
		
		result.entrySet().forEach(n->{
			System.out.println(n.getKey().name+" "+n.getValue());
		});	
		
	
	}
}
