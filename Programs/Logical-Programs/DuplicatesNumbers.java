package simpleprograms;

import java.util.Scanner;

public class DuplicatesNumbers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Scanner scan=new Scanner(System.in);
		int[] a={1,2,3,3,5};
		for(int i=0;i<a.length;i++){
			int count = 1;
			if(a[i]!=0){
			for(int j=i+1;j<a.length;j++){
				if(a[i] == a[j]){
					a[j]=0;
					count++;
				}
			}
			if(count>1)
				System.out.println(a[i]+" Repeated for"+count);
			}
		}
	}

}
