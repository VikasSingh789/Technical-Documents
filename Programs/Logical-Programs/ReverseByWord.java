package simpleprograms;

public class ReverseByWord {
	public int revString(int[] a) {
		
		for(int i=0;i<a.length;i++) {
			return a[i];
		}
		return a[2];
	}
	public static void main(String[] args) {
		int a[]= {1,2,5,3,4};
		ReverseByWord obj = new ReverseByWord();
		System.out.println(obj.revString(a));
		
	}
}
