package simpleprograms;

public class SortinOrder {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[]={2,6,3,4,5,1};
		for(int i=0;i<a.length;i++) {
			for(int j=i+1;j<a.length;j++) {
				if(a[i]<a[j]) {
					int temp=a[i];
					a[i]=a[j];
					a[j]=temp;
				}
			}
			System.out.print(a[i]);
			final int c=10;
		}
			System.out.print(a[4]);
	}

}
