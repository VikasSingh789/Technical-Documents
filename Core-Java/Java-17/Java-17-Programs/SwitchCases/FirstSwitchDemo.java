package com.programs.java17.switchEnhancements;

public class FirstSwitchDemo {
	
	public static void beforeJava17SwitchDemo(int num) {
		String result;
		switch (num) {
		case 1:
			result = "One";
			break;
		case 2:
			result = "Two";
			break;
		default:
			result = "Unknown";
			break;
		}
		System.out.println("Before Java17 Result-"+result);
	}
	
	public static void afterJava17SwitchDemo(int num) {
		String result = switch(num) {
		case 1 -> "One";
		case 2 -> "Two";
		default -> "UnKnown";
		};
		System.out.println("Java17 Result-"+result);
	}
	
	public static String afterJava17ReturnSwitchDemo(int num) {
		return switch(num) {
		case 1 -> "One";
		case 2 -> "Two";
		default -> "UnKnown";
		};
	}
	
	public static void main(String[] args) {
		beforeJava17SwitchDemo(2);
		afterJava17SwitchDemo(2);
	}

}
