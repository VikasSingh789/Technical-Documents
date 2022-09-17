package simpleprograms;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DuplicatesinList {
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> al = new ArrayList();
		al.add(1);
		al.add(2);
		al.add(1);
		al.add(3);
		System.out.println(al);
		Set s = new HashSet();
		for(int i:al) {
			s.add(i);
		}
		System.out.println(s);
		

	}

}
