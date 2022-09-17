package simpleprograms;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

class AddressExample{
	String address;
	int flat;
	
	public AddressExample(String address, int flat) {
		this.address = address;
		this.flat = flat;
	}
	
}
public class ConcurrentExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		AddressExample a1=new AddressExample("hyderabad",1);
//		AddressExample a2=new AddressExample("hyderabad",1);
//		
//		HashMap<AddressExample,Integer> hs=new HashMap<AddressExample,Integer>();
//		hs.put(a1,1);
//		hs.put(a2,1);
//		
//		for(Map.Entry<AddressExample,Integer> obj: hs.entrySet()) {
//			AddressExample val=(AddressExample)obj.getKey();
//			
//			System.out.println(val.address);
//		}
//		AddressExample a1=new AddressExample("hyderabasd",1);
//		AddressExample a2=new AddressExample("hyderabad",2);
//		AddressExample a3=new AddressExample("hyderabassd",3);
//		HashMap<Integer,AddressExample> hs=new HashMap<Integer,AddressExample>();
//		hs.put(1,a1);
//		hs.put(1,a2);
//		hs.put(1,a3);
//		for(Map.Entry<Integer, AddressExample> obj: hs.entrySet()) {
//			AddressExample obj1 = (AddressExample)obj.getValue();
//			System.out.println(obj.hashCode());
//		}
//		ConcurrentHashMap h = new ConcurrentHashMap();
//		h.put(1,"Hyderabad");
//		h.put(1,"Hyderabads");
//		System.out.println(h);
//		h.putIfAbsent(2, "Akash");
//		System.out.println(h);
		Map<String,String> h = new HashMap<String,String>();
		h.put("1","Hyderabad");
		h.put("2","Hyderabads");
		for(Map.Entry<String,String> obj:h.entrySet()) {
			//System.out.println(obj.getValue());
			h.put("1","Hyderabadss");
		}
		System.out.println(h);
	}
}
