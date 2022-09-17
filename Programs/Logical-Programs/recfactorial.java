package simple;
import java.util.Scanner;
public class recfactorial {

	public long factorial(long n)
	{
	if(n<0)
		return 0;
	if(n==1)
		return 1;
	else
		return (n*factorial(n-1));
	}
public static void main(String args[]){
	Scanner scan=new Scanner(System.in);
	System.out.println("enter the number");
	int n=scan.nextInt();
	recfactorial f=new recfactorial();
	System.out.println("factorial of "+n+" is "+f.factorial(n));	
}
}
