package simpleprograms;

import java.util.Scanner;

public class StringDuplicatesRemoval {
public static void main(String args[]){
	Scanner scan=new Scanner (System.in);
	System.out.println("enter the String");
	String str= scan.nextLine();
	//System.out.print("Duplicates Characters are:-");
	System.out.print("String after remove duplicates:-");
	char c[]=str.toCharArray();
	for(int i=0;i<c.length;i++){
		int count = 1;
		if(c[i]!='~'){
			for(int j=i+1;j<c.length;j++){
				if(c[i] == c[j]){
					c[j]='~';
					count++;
				}
			}
//			if(count>1)
//				System.out.print(c[i]);
		}
		if(c[i]!='~')
			System.out.print(c[i]);
	}
}
}
