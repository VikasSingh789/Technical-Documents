package com.programs;

public class CountDuplicatesStringsOccurancesWithOutCollections {

	static void duplicateString(String str) {
		String strArr[] = str.split(" ");
		for(int i=0;i<strArr.length;i++) {
			int count = 1;
			for(int j=i+1;j<strArr.length;j++) {
				if(strArr[i].equals(strArr[j])) {
					count = count+1;
				}
			}
			if(count>1) {
				System.out.println(strArr[i]);
			}
		}
	}
	public static void main(String[] args) {
		String str = "I am doing java java";
		duplicateString(str);

	}

}
