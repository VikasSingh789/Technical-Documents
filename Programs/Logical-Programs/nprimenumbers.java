package simple;
import java.util.Scanner;
public class nprimenumbers {
	public static void main(String[] args) {
		int count = 0;
		int c;
		int n = 15;
		System.out.println("Prime Numbers till "+n+" is");
		for (int i = 1; i <= n; i++) {
			c = 0;
			for (int j = 1; j <= i; j++) {
				if (i % j == 0)
					c = c + 1;
			}
			if (c == 2) {
				++count;
				System.out.println(i+" ");
			}
		}
		System.out.println("Total:- "+count);
	}
}

//input:- 10
//output:-
// 2
// 3
// 5
// 7
