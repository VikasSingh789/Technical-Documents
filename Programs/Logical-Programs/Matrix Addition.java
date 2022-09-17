package arrays;
import java.util.Scanner;
public class multilication {

	public static void main(String[] args) {
			Scanner scan=new Scanner(System.in);
			System.out.println("enter the order of matrix");
			int m=scan.nextInt();
		    int n=scan.nextInt();
			int a[][]=new int[m][n];
			int b[][]=new int[m][n];
			System.out.println("enter the values for A");
			for(int i=0;i<m;i=i+1){
			for (int j=0;j<n;j=j+1){
				a[i][j]=scan.nextInt();
			}
			}
			System.out.println("enter the values for B");
			for(int i=0;i<m;i=i+1){
			for (int j=0;j<n;j=j+1){
				b[i][j]=scan.nextInt();
			}
			}
			System.out.println("the addition of the matrix are");
			for(int i=0;i<m;i=i+1){
			for (int j=0;j<n;j=j+1){
				System.out.print(a[i][j]+b[i][j]+" ");
			}
			System.out.println();
			}}}
