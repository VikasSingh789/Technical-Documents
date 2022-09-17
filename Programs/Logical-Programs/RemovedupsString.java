package simpleprograms;


import java.util.ArrayList;
import java.util.List;

public class RemovedupsString {

	public static void main(String[] args) {
		String str="vikas singh akash singh";
		List<String> s=new ArrayList<String>();
		String words[] = str.split(" ");
		String backup="";
		for(int i=0;i<words.length;i++) {
			if(!s.contains(words[i])) {
				s.add(words[i]);
			}
		}
		for(String obj:s) {
			backup=backup+obj+" ";
		}
	}

}
