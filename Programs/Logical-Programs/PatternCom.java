package com.venk;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternCom {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("Enter the paragraphs");
		String mat=new Scanner(System.in).next();
		System.out.println("Enter the Value");
		String st=new Scanner(System.in).next();
		
		
		int c=0;
		String st1="";
		
		//new Student();
		
		Pattern p=Pattern.compile(st);
		
		Matcher m=p.matcher(mat);
		//int c=0;
		while(m.find()){
			
			c=c+1;
			
		}
		
		System.out.println(st+" is given "+c+" times");
		
		/*
		System.out.println("Enter the paragraph");
		String mat=new Scanner(System.in).next();
		System.out.println("enter the cat or pat");	
		for(int i=0;i<mat.length();i++){
			
			if(mat.charAt(i)=='c'){
				if(mat.charAt(i+1)=='a')
					if(mat.charAt(i+2)=='t')
						{cat=cat+1;
				i=i+2;}
			}
			if(mat.charAt(i)=='p'){
				if(mat.charAt(i+1)=='a')
					if(mat.charAt(i+2)=='t')
						{pat=pat+1;
				i=i+2;}
			}
			
		}
		System.out.println("pat are"+pat);
		//System.out.println(cat);
*/
	}

}
