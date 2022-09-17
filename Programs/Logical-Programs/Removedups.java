package simpleprograms;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;

public class Removedups {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String[] str={"vikas","singh","akash","singh","singh"};
		List<String> l=new LinkedList<String>();
		int count=1;
		for(int i=0;i<str.length;i++){
			if(!(l.contains(str[i]))){
				l.add(str[i]);
				count=1;
				System.out.println(count+" "+str[i]);
			}else {
				count++;
			}
		}
		System.out.println(count+" count");
		if(count>1) {
			for(int i=0;i<str.length;i++) {
				System.out.println(l);
			}
		}
			
		for(String obj:l)
		System.out.print(obj+" ");
	}

}
