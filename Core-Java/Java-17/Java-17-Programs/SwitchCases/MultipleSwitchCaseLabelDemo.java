package com.programs.java17.switchEnhancements;

public class MultipleSwitchCaseLabelDemo {

	public static void beforeJava17MultipleSwitchCaseLabelDemo(int num) {
		String result;
		switch (num) {
		case 1:
			result = "One";
			break;
		case 2:
		case 3:
			result = "Two" + " Three";
			break;
		default:
			result = "Unknown";
			break;
		}
		System.out.println("Before Java17 Result-" + result);
	}

	public static void afterJava17MultipleSwitchCaseLabelDemo(int num) {
		String result = switch (num) {
		case 1 -> "One";
		case 2, 3 -> "Two" + " Three";
		default -> "Unknown";
		};
		System.out.println("Before Java17 Result-" + result);
	}

	public static void main(String[] args) {
		beforeJava17MultipleSwitchCaseLabelDemo(2);
		afterJava17MultipleSwitchCaseLabelDemo(5);

	}

}
