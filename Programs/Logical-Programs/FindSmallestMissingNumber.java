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

	static int findMissingFromArrayUsingStream(int a[]) {

		return IntStream.range(1, Integer.MAX_VALUE).filter(n -> Arrays.stream(a).noneMatch(num -> num == n)).findFirst().getAsInt();
	}

	public static void main(String[] args) {
		int a[] = { 1, 2, 4 };
		System.out.println("Smallest Missing Positive Integer is: " + findMissingFromArray(a));
		System.out.println("Smallest Missing Positive Integer is: " + findMissingFromArrayUsingStream(a));
	}
}

//input:-   { 1, 2, 4 }
//output:-  3
