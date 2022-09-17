package simple;
import java.util.Scanner;
public class prime {
	public static void main(String[] args){ 
		Scanner scan=new Scanner(System.in);
			int c=0;
			System.out.println("enter the number");
			int n=scan.nextInt();
			for(int i=1;i<=n;i=i+1){
				if(n%i==0)
				c=c+1;
			}
			if(c==2)
				System.out.println("prime");
			else
				System.out.println("not prime");
	}
}