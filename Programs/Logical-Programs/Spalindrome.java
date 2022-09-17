package simple;
import java.util.Scanner;
public class Spalindrome {

	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		System.out.println("enter a String");
		String n=scan.next();
		/*String s1="";
		for(int i=n.length()-1;i>=0;i--){
			s1=s1+n.charAt(i);
		}
		if(n.equals(s1)){
				System.out.println("palindrome");
			}
			else{
				System.out.println("not a palindrome");
		}*/
		StringBuilder sb=new StringBuilder(n);
		sb.reverse();
		if(n.equals(sb.toString())){
				System.out.println("palindrome");
			}
			else{
				System.out.println("not a palindrome");
		}	
		}
	}