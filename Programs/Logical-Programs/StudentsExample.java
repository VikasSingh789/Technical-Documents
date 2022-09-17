package simpleprograms;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class StudentsExample {
	public static void main(String args[]) {
		List<Integer> l1= new ArrayList<Integer>();
		l1.add(101);
		l1.add(102);
		l1.add(103);
		l1.add(104);
		l1.add(101);
		List<Integer> l2 = new ArrayList<Integer>();
		l2.add(99);
		l2.add(98);
		l2.add(13);
		l2.add(14);
		l2.add(101);
		Set s1 = new HashSet();
		for(Integer i:l1) {
		s1.add(i);
		}
		for(Integer i:l2) {
		s1.add(i);
		}
		Object[] a=s1.toArray();
		int[] a1=new int[a.length];
		for(int i=0;i<a.length;i++) {
			a1[i]=(int) a[i];
		if(a1[i]>100)
		System.out.println(a1[i]);
		}
		
	}

}
