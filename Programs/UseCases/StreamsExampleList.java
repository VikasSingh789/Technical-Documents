package com.practice;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;


public class StreamsExampleList {
	
	int id;
	String name;

	public StreamsExampleList(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public static void main(String[] args) {
		StreamsExampleList s1 = new StreamsExampleList(1,"vikas");
		StreamsExampleList s2 = new StreamsExampleList(2,"akash");
		StreamsExampleList s3 = new StreamsExampleList(3,"Abhishek");
		List<StreamsExampleList> lists = Arrays.asList(s1,s2,s3);
		
		System.out.println("By Using Iterator");
		Iterator<StreamsExampleList> itr = lists.iterator();
		while(itr.hasNext()) {
			StreamsExampleList value = itr.next();
			System.out.println(value.id+":"+value.name);
		}
		System.out.println("-------------------------------------");
		System.out.println("By Using Streams and Filter on Name");
		List<StreamsExampleList> names = lists.stream().filter(s->s.name.startsWith("A") || s.name.startsWith("a")).collect(Collectors.toList());
		for (StreamsExampleList streamsExampleList : names) {
			System.out.println(streamsExampleList.name+"="+streamsExampleList.id);
		}
		System.out.println("-------------------------------------");
		System.out.println("By Using Streams and Filter on ID");
		List<StreamsExampleList> ids = lists.stream().filter(s->s.id == 1).collect(Collectors.toList());
		for (StreamsExampleList streamsExampleList : ids) {
			System.out.println(streamsExampleList.id+"="+streamsExampleList.name);
		}
		System.out.println("-------------------------------------");
		List<String> al = Arrays.asList("vikas", "akash", "abhishek", "chintu");
		System.out.println(al);
		List<String> names1 = al.stream().filter(s->s.startsWith("c")).map(s->s.concat("->")).collect(Collectors.toList());
		System.out.println(names1);
	}

}
