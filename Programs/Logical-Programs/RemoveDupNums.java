package simpleprograms;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;
class DescExample implements Comparator{

	@Override
	public int compare(Object o1, Object o2) {
		
		Integer i1=(Integer)o1;
		Integer i2=(Integer)o2;
		return i2.compareTo(i1);
	}
}
public class RemoveDupNums {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[]={20,20,1,5,2,1,1,3,4,5,5,6};
		Set<Integer> s=new TreeSet<Integer>(new DescExample());
		for(int i=0;i<a.length;i++) {
			s.add(a[i]);
		}
		for(int obj:s) {
			System.out.println(obj);
		}
	}

}
