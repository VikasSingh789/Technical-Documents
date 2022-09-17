package simple;
import java.util.Scanner;
public class binarytointeger {

	public static void main(String[] args) {
	Scanner scan=new Scanner(System.in);
		int c=1;
		int i=1,result=0;
		System.out.println("enter a binary number");
		int n=scan.nextInt();
		while(n>0){
			c=n%10;
			result=result+(c*i);
			i=i*2;
			n=n/10;
		}
		System.out.println("decimal number\n"+result);
	}

}
