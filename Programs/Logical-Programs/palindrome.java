package simple;
import java.util.Scanner;
public class palindrome {
	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		int temp,rem,sum=0;
		System.out.println("enter the number");
		int n=scan.nextInt();
		temp=n;
		while(n>0)
		{
			rem=n%10;
			sum=(sum*10)+rem;
			n=n/10;
		}
	if(temp==sum)
		System.out.println("palindrome");
	else
		System.out.println("not a palindrome");
	}

}
