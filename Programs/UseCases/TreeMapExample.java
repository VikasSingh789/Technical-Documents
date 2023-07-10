package com.practice;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

public class TreeMapExample implements Comparable<TreeMapExample> {
	
	int id;
	String name;

	public TreeMapExample(int id, String name) {
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
	
	@Override
	public int compareTo(TreeMapExample o) {
		return o.id-this.id;
	}

	public static void main(String[] args) {
		
		TreeMapExample s1 = new TreeMapExample(1, "vikas");
		TreeMapExample s2 = new TreeMapExample(2, "akash");
		
		TreeSet<TreeMapExample> ts = new TreeSet<TreeMapExample>();
		ts.add(s1);
		ts.add(s2);
		
		ts.stream().sorted(Comparator.comparing(TreeMapExample::getId).reversed()).map(n->n.getId()+" "+n.getName()).forEach(System.out::println);
		
		for (TreeMapExample treeMapExample : ts) {
			System.out.println(treeMapExample.id+" "+treeMapExample.name);
		}
		
		TreeMap<Integer,TreeMapExample> tm = new TreeMap<>();
		tm.put(1, s1);
		tm.put(2, s1);
		
		for (Map.Entry<Integer,TreeMapExample> m: tm.entrySet()) {
			System.out.println(m.getKey()+" "+m.getValue());
		}
		
		tm.entrySet().stream().forEach(n->{
			System.out.println(n.getKey()+" "+n.getValue());
		});
		
//		HashMap<Integer,TreeMapExample> hm = new HashMap();
//		hm.put(1, s1);
//		hm.put(2, s2);
//		
//		hm.entrySet().stream().filter(n->"vikas".equals(n.getValue())).forEach(System.out::println);	
	}

	

}
