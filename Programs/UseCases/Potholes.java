package com.programs;

public class Potholes {
	
	static int potholes(int R[]) {
		int n = R.length;
		if (n == 0) {
			return 0;
		}
		
		int max_indicator = 0;
		int current_max = 0;
		int start = 0;

		for (int j = 0; j < n; j++) {
			if (R[j] > 0) {
				if (current_max < R[j]) {
					current_max = R[j];
				}
				int indicator = current_max * (j - start + 1);
				if (indicator > max_indicator) {
					max_indicator = indicator;
				}
			} else {
				current_max = 0;
				start = j + 1;
			}
		}
		return max_indicator;
	}

	public static void main(String[] args) {
		int a[] = { 0, 2, 1, 1, 0, 4, 1 };
		int b[] = { 1, 4, 1, 0, 5, 2, 3, 0, 8 };
		System.out.println(Potholes.potholes(a));
		System.out.println(Potholes.potholes(b));
	}
}