package simpleprograms;

public class NGAExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[]= {4,2,5,25};
		int b = a[0],b1=0;
		for(int i=0;i<a.length;i++) {
			if(a[i]>b) {
				b=a[i];
			}
		}
		
		System.out.println(b);
		for(int i=0;i<a.length;i++) {
			if(a[i]<b && a[i]==1) {
				System.out.println(a[i]+"-->"+b1);
			}
			else if(a[i]<b){
				System.out.println(a[i]+"-->"+b);
			}
			else {
				System.out.print(a[i]+"-->");
				System.out.println(b-b-1);
			}
		}
	}

}
