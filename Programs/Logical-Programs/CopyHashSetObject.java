package simpleprograms;

import java.util.HashSet;

public class CopyHashSetObject {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashSet<Integer> hSet = new HashSet<Integer>();
	    hSet.add(1);
	    hSet.add(new Integer("2"));
	    hSet.add(new Integer("3"));

	   // Object[] objArray = hSet.toArray();

	    for (Object obj : hSet)
	      System.out.println(obj);
	}

}
