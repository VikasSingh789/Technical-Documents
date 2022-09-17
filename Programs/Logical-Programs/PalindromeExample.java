package simpleprograms;

public class PalindromeExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n=153,temp,rem,sum=0;
		temp=n;
//		while(n >0) {
//			rem=n%10;
//			sum=(sum*10)+rem;
//			n=n/10;
//		}
		while(n >0) {
			rem=n%10;
			n=n/10;
			sum=sum+(rem*rem*rem);
		}
		if(temp==sum) {
			System.out.println("palindrome");
		}
		else {
			System.out.println("Not palindrome");
		}
		
	}

}
