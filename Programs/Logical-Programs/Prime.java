package simple;
import java.util.Scanner;
public class Prime {
	static void checkprime(int n) {
		int c = 0;
		for (int i = 1; i <= n; i = i + 1) {
			if (n % i == 0)
				c = c + 1;
		}
		if (c == 2)
			System.out.println("Given No. is Prime");
		else
			System.out.println("nGiven No. is Not a Prime");
	}
	
	public static void main(String[] args) {
		Prime.checkprime(10);
	}
}
