package simpleprograms;

import java.util.Arrays;
import java.util.Scanner;

public class SpaceCaps {

	static void spaceCaps(String str) {
		str = str.replaceAll("[^a-zA-Z0-9]", ":");
		String[] res = str.split(":");
		String output = "";
		for (int i = 0; i < res.length; i++) {
			output = output + res[i].substring(0, 1).toUpperCase() + res[i].substring(1);
		}
		System.out.println(output);
	}

	public static void main(String[] args) {
		String str = "Vikas singh";
		spaceCaps(str);

	}
}

//input:-   Vikas singh
//output:-  VikasSingh
