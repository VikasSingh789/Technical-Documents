package simple;
import java.util.Scanner;
public class nprimenumbers {
	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		int count=0,c;
		System.out.println("enter the limit");
		int n=scan.nextInt();
		for(int i=1;i<=n;i++){
			c=0;
			for(int j=1;j<=i;j++){
				if(i%j==0)
					c=c+1;
			}
		if(c==2)
			System.out.println(++count+"prime numbers are"+i);
	}
	}
}
