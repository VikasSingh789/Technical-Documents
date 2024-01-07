package simpleprograms;

import java.util.Scanner;

public class DuplicateFirstCharacter {

	static String checkDuplicateFirstCharacter(String str) {
		String res = "";
		try {
			char ch[] = str.toCharArray();
			for (int i = 0; i < ch.length; i++) {
				int count = 1;
				if (ch[i] != ' ') {
					for (int j = i + 1; j < ch.length; j++) {
						if (ch[i] == ch[j]) {
							ch[j] = ' ';
							count++;
						}
					}
					if (count > 1) {
						res = res + ch[i];
					}
				}
			}
			if (res == "") {
				System.out.println("No Duplicates found");
			} else
				res = res.substring(0, 1).toUpperCase();
		} catch (Exception e) {
			System.out.println(e);
		}
		return res;
	}

	public static void main(String[] args) {
		System.out.println(checkDuplicateFirstCharacter("vikassi"));
	}
}

//input:- vikass
//output:- S (Capital S)

//input:- vikassi
//output:- I (Capital I. I because we found i as 1st duplicate character in given string)
