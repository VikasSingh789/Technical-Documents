package simpleprograms;

import java.util.HashMap;
import java.util.Map;

class DataKey {

	String name;

	public DataKey(String name) {
        this.name = name;
    }

//	@Override
//	public int hashCode() {
//		final int prime = 31;
//		int result = 1;
//		result = prime * result + ((name == null) ? 0 : name.hashCode());
//		return result;
//	}

//	@Override
//	public boolean equals(Object obj) {
//		if (this == obj)
//			return true;
//		if (obj == null)
//			return false;
//		if (getClass() != obj.getClass())
//			return false;
//		DataKey other = (DataKey) obj;
//		if (name == null) {
//			if (other.name != null)
//				return false;
//		} else if (!name.equals(other.name))
//			return false;
//		return true;
//	}
}
public class HashingTest {

	public static void main(String[] args) {
		DataKey employee1 = new DataKey("rajeev");
        DataKey employee2 = new DataKey("rajee");
        DataKey employee3 = new DataKey("rajeev");
        HashMap<Integer,DataKey> hs=new HashMap<Integer,DataKey>();
        hs.put(1,employee1);
        hs.put(1,employee2);
        hs.put(1,employee3);
        for(Map.Entry<Integer, DataKey> obj: hs.entrySet()) {
        	int key=obj.getKey();
        	DataKey name=obj.getValue();
        	System.out.println(key+" "+name.hashCode());
        }
    }
}