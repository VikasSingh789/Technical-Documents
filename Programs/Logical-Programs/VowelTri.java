package com.venk;

public class VowelTri {

	/**
	 * @param args
	 */

	public static void spaceH(int x) {
		for (int i = 1; i <= x; i++) {
			System.out.print(" ");
		}
	}

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
int pos=0;
char ch[]={'a','e','i','o','u'};
			int temp = 4;
		for (int i = 1; i <= 4; i++) {
			spaceH(temp);
			
			for (int j = 1; j <= (i + 1); j++) {
			
				if(i==1){
					System.out.print(" "+ch[pos]);
					pos=pos+1;
					break;
				}else
					if(pos>4){
						pos=0;
					}
				System.out.print(ch[pos]+" ");
				pos=pos+1;
			}

			System.out.println();
			temp = temp - 1;
		}
	}

}





https://www.youtube.com/watch?v=e8TP2FERKls
