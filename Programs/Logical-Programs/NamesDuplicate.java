package com.nt.Programs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class NamesDuplicate {

	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		//System.out.println("enter the Size");
		//int s=scan.nextInt();
		//ArrayList<String> al=new ArrayList();
		//ArrayList<String> al1=new ArrayList();
/*		System.out.println("enter the String");
		for(int i=0;i<s;i++){
			al.add(scan.next());
		}
		System.out.println("enter the character to find the duplicate");
		char c=(char)scan.nextByte();
		loop:for(int i=0;i<al.size();i++){
			char a[]=al.get(i).toCharArray();
			for(int j=0;j<a.length;j++){
				if(a[j]==c){
					al1.add(new String(a));
					continue loop;
				}
			}
		}
		System.out.println(al1);
*/
		ArrayList<String> al=new ArrayList();
		ArrayList<String> al1=new ArrayList();
		al.add("akshay");
		al.add("vikas");
		al.add("saiteja");
		al.add("nikhil");
		System.out.println(al);
		
		loop: for(int i=0;i<al.size();i++){
			char a[]=al.get(i).toCharArray();
			for(int j=0;j<a.length;j++){
				if(a[j]=='a'){
					al1.add(new String(a));
					continue loop;
				}
			}
		}
		System.out.println(al1);
		}

}
