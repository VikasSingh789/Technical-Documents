package simple;
import java.util.Scanner;
public class palindrome {
	
	static boolean checkBoolean(int n) {
        int temp = n;
        int rev=0;
        while(n>0){
             int rem = n%10;
             rev = rev*10+rem;
             n = n/10;
        }
        if(temp==rev) {
            return true;
        }else {
            return false;
        }
    }
 
    public static void main(String[] args) {
        System.out.println(checkBoolean(234));
    }
 
}

//input:-  242
//output:- true

//input:-  234
//output:- false;
