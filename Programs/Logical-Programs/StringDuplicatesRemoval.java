package simpleprograms;

import java.util.Scanner;

public class StringDuplicatesRemoval {
	static void removeDuplicatesFromString(String str) {
		char c[]=str.toCharArray();
		for(int i=0;i<c.length;i++){
			int count = 1;
			if(c[i]!='~'){
				for(int j=i+1;j<c.length;j++){
					if(c[i] == c[j]){
						c[j]='~';
						count=count+1;
					}
				}
			}
			if(c[i]!='~')
				System.out.print(c[i]);
		}
	}

	public static void main(String args[]){
		String str = "vikass";
		System.out.println("Given String:- "+str);
		System.out.print("String after remove duplicates:- ");
		removeDuplicatesFromString(str);
	}
	}

//input:-  vikass
//output:- vikas
