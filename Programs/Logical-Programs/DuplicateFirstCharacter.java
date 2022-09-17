package simpleprograms;

import java.util.Scanner;

public class DuplicateFirstCharacter {
	static String checkDuplicateFirstCharacter(String str) {
		String res = "";
		try{
			char ch[] = str.toCharArray();
			for(int i=0;i<ch.length;i++) {
				int count = 1;
				if(ch[i]!= ' ') {
					for(int j=i+1;j<ch.length;j++) {
						if(ch[i]==ch[j]) {
							ch[j] = ' ';
							count++;
						}
					}	
					if(count>1) {
						res=res+ch[i];
					}
				}
			}
			if(res=="") {
				System.out.println("No Duplicates found");
			}else
			res=res.substring(0,1).toUpperCase();
		}
		catch(Exception e) {
			System.out.println(e);
		}
		return res;
		}
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the String");
		String str=scan.nextLine();
		System.out.println(checkDuplicateFirstCharacter(str));
	}
}
