package com.programs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class RotateArrayOnList {
	static List<Integer> rotateLeft(List<Integer> list, int n) {
		Collections.rotate(list, -n); // negative for left rotation return list;
		return list;
	}

	public static void main(String[] args) {
		List<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7));
		System.out.println(rotateLeft(list, 3));
	}
}