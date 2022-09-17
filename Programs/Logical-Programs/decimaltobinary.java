package simple;

import java.util.Scanner;

public class decimaltobinary {
	public void DtoB(int number)
	{
		Scanner scan=new Scanner(System.in);
		int m=scan.nextInt();
	int binary[]=new int[m];
	int index=0;
	while(number>0){
		binary[index++]=number%2;
		number=number/2;
	}
	for(int i=index-1;i>=0;i--){
		System.out.print(binary[i]);
	}
	}
	public static void main(String[] args) {
	decimaltobinary dtb=new decimaltobinary();
	dtb.DtoB(25);

	}

}
