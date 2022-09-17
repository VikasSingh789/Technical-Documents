package simpleprograms;

import java.util.ArrayList;
import java.util.List;

public class CapitalsExample {
	
	public static void main(String[] args) {
		
		String a[]= {"vikas","Singh","vikas","vikas"};
		String b= "";
		List<String> s=new ArrayList<String>();
		int count =0;
		for(int i=0;i<a.length;i++) {
			if(!s.contains(a[i])) {
				s.add(a[i]);
			}
			else {
				b = b+a[i];
			}
		}
		for(String i:s) {
			System.out.print(i+" ");
		}
	}

}
