package com.programs;

import java.util.HashMap;
import java.util.Map;

public class GroupingExample {
	public static void findgrouping(int key, int value) {
		String temp = "";
		HashMap<String, String> map = new HashMap<>();
		for (int i = key; i <= value; i++) {
			temp = temp + i + ",";
		}
		map.put(key + "-" + value, temp.substring(0, temp.length() - 1));
		for (Map.Entry<String, String> result : map.entrySet()) {
			System.out.println("Key:" + result.getKey());
			System.out.println("Values:" + result.getValue());
			System.out.println("===========");
		}
	}

	public static void main(String[] args) {
		for (int i = 0; i < 5; i++) {
			int key = i % 10 * 10 + 1;
			int value = key / 10;
			value = ++value * 10;
			GroupingExample.findgrouping(key, value);
		}
	}
}