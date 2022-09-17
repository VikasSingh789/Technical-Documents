package simpleprograms;

import java.util.Map;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;

public class ArrayListExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int as[]= {1,2,2};
		ConcurrentHashMap<Integer,String> al=new ConcurrentHashMap<Integer,String>();
		for(int i=0;i<as.length;i++) {
			al.put(as[i], "Vikas");
			al.put(as[i], "Vikas");
			al.put(as[i], "Vikass");
		}
//		al.put(1,"Vikas");
//		al.put(3,"Akash");
//		al.put(3,"Akash");
		for(Map.Entry<Integer, String> a:al.entrySet()) {
			int key = a.getKey();
			String str=a.getValue();
			
			System.out.println(a.getKey()+" "+a.getValue());
			//al.remove(1);
		}
		System.out.println(al);
	}

}
