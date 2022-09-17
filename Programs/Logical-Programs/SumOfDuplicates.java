package simpleprograms;


public class SumOfDuplicates {
	public static void main(String[] args) {
		String str="aaabbbbcccccccccccccc";
		//System.out.println(str);
		char c[]=str.toCharArray();
		for(int i=0;i<c.length;i++) {
			int count=1;
			if(c[i]!=' ') {
				for(int j=i+1;j<c.length;j++) {
					if(c[i] == c[j]) {
						c[j]=' ';
						count++;
					}
				}
				if(count>1) {
					System.out.print(count);
					System.out.print(c[i]);
				}
			}
		}
	}

}
