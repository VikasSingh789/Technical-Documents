package simpleprograms;

public class ReverseString {

	static void reverseString(String str) {
		for(int i=str.length()-1;i>=0;i--) {
			System.out.print(str.charAt(i));
		}
	}

	public static void main(String[] args) {
		String str="VikasSingh";
		reverseString(str);
	}
}

//input:-   VikasSingh
//output:-  hgniSsakiV

}
