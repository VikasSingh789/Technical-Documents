public class FindSmallestMissingNumber {

	static int findMissingFromArray(int a[]) {
		boolean found = false;
		for (int i = 1;; i++) {
			found = false;
			for (int j = 0; j < a.length; j++) {
				int x = a[j];
				if (x == i) {
					found = true;
					break;
				}
			}
			if (!found) {
				return i;
			}
		}
	}

	public static void main(String[] args) {
		int a[] = { 1, 2, 4 };
		System.out.println("Smallest Missing Positive Integer is: " + findMissingFromArray(a));
	}
}

//input:-   { 1, 2, 4 }
//output:-  3
