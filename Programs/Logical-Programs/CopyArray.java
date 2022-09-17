package simpleprograms;

import java.util.TreeSet;

public class CopyArray {

	public static void main(String[] args) {
		int n=4;
		for(int i=4;i>=1;i--) {
			for(int j=4;j<=1;j++) {
				if((j==2 && i==2) || (j==3 && i==2)) {
					System.out.print(" ");
				}
				if((j==2 && i==3) || (j==3 && i==3)) {
					System.out.print(" ");
				}else {
					System.out.print("* ");
				}
			}
			System.out.println();
			}
	}

}
