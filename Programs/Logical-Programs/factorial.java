package simple;
import java.util.Scanner;
public class factorial {

	static void factorial(int n) {
		int fact = 1;
		for (int i = 1; i <= n; i = i + 1) {
			fact = fact * i;
		}
		System.out.println("factorial of a given number is:- " + fact);
	}

	static int factByrecursion(int num) {
		if (num < 0)
			return 0;
		else if (num <= 1)
			return 1;
		else
			return (num * factByrecursion(num - 1));
	}

	public static void main(String[] args) {
		factorial(4);
		System.out.println("factorial of a given number is:- " + factByrecursion(4));
	}
}

//input:-  4
//output:- 24
