package com.practice;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class StreamsAddress {
	
	int id;
	String name;
	String address;
	int age;
	
	public static int INCREMENT_SALARY = 2;

	public StreamsAddress(int id, String name, String address, int age) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.age = age;
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
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}

	

	@Override
	public String toString() {
		return "StreamsAddress [id=" + id + ", name=" + name + ", address=" + address + ", age=" + age + "]";
	}

	public static void main(String[] args) {
		
		List<Integer> list1 = new ArrayList<>();
		list1.add(3);
		list1.add(1);
		list1.add(4);
		list1.add(2);
		
		System.out.println("Collections.sort");
		Collections.sort(list1,Collections.reverseOrder());
		System.out.println(list1.get(0));
		System.out.println("---------------------------");
		
		StreamsAddress s1 = new StreamsAddress(1, "Vikas", "Bapunagar", 27);
		StreamsAddress s2 = new StreamsAddress(2, "Akash", "Aryanagar", 25);
		StreamsAddress s3 = new StreamsAddress(3, "Abhishek", "Chintal", 19);
		StreamsAddress s4 = new StreamsAddress(4, "ABC", "Chintal", 19);
		List<StreamsAddress> list = Arrays.asList(s1,s2,s3,s4);
		
		System.out.println("Increase Age by +1 for all employees");
		list.stream().map(s->{
			s.setAge(s.getAge()+1);
		return s;
		}).forEach(System.out::println);
		System.out.println("------------------------------------");
		System.out.println("Increase Age by +1 based on name");
		list.stream().filter(s->s.getName().equals("Akash")).map(s->s.getAge()+1).forEach(System.out::println);
		System.out.println("------------------------------------");
		System.out.println("Without Storing the result: Case-1");
		System.out.println("------------------------------------");
		list.stream().sorted(Comparator.comparing(StreamsAddress::getAge)).forEach(System.out::println);
		System.out.println("------------------------------------");
		System.out.println("Without Storing the result: Case-2");
		System.out.println("------------------------------------");
		list.stream().map(a->a.getAddress()).sorted().forEach(System.out::println);
		System.out.println("------------------------------------------------");
		System.out.println("With Storing the result");
		System.out.println("------------------------");
		List<StreamsAddress> sortedOnAddress = list.stream().sorted(Comparator.comparing(StreamsAddress::getAge)).collect(Collectors.toList());
		for (StreamsAddress streamsAddress : sortedOnAddress) {
			System.out.println(streamsAddress.name+"-"+streamsAddress.address);
		}
		System.out.println("------------------------");
		list.stream().filter(s->s.id==3).map(s->s.name.concat("->")).forEach(System.out::println);
	}

}
