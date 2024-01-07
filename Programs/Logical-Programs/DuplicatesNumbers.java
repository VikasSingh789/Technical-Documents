package simpleprograms;

import java.util.Scanner;

public class DuplicatesNumbers {

	static void checkDuplicatedNumbers(int n[]) {
		for (int i = 0; i < n.length; i++) {
			int count = 1;
			if (n[i] != 0) {
				for (int j = i + 1; j < n.length; j++) {
					if (n[i] == n[j]) {
						n[j] = 0;
						count++;
					}
				}
				if (count > 1)
					System.out.println(n[i] + " Repeated for " + count + " times");
			}
		}
	}
	
	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 3, 5 };
		AIPN.checkDuplicatedNumbers(arr);

	}
}

//input:-   { 1, 2, 3, 3, 5, 5 };
//output:-  3 Repeated for 2 times
