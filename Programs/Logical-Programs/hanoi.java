package simple;
import java.util.Scanner;
public class hanoi {
	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		System.out.println("enter the number");
		int n=scan.nextInt();
		for(int i=1;i<=n;i++)
		{
			System.out.println("\n");
			for(int j=1;j<=i;j++)
			{
				System.out.print(" ");
			}
			for(int k=1;k<=i;k++){
				System.out.print("*");
				}
			System.out.println();
		}
	}
	}	
