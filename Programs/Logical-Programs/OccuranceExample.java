package com.practice;

public class OccuranceExample {

	public static void main(String[] args) {
		String str = "aabacdd";
		StringBuffer sb = new StringBuffer();
		char ch[] = str.toCharArray();
		int i;
		int count = 1;
		for(i=0;i<ch.length-1;i++) {
					if(ch[i]==ch[i+1]) {
						
						count = count+1;
					}else {
						sb.append(ch[i]);
						sb.append(count);
						count = 1;
					}
			
		}
		sb.append(ch[i]);
		sb.append(count);
		System.out.println(sb);
		
	}

}
