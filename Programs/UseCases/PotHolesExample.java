public class PotHolesExample {
	
	public static int findPotHoles(String s) {
		  int holes = 0;
		  for (int i = 0; i < s.length(); i++) {
		    if (s.charAt(i) == 'X') {
		      holes++;
		      i += 2;
		    }
		  }
		  return holes;
		}
	
	public static void main(String[] args) {
		System.out.println(findPotHoles("XXXX...X"));
	}
 
}

//input:-   XXXX...X
//output:-  3
//
//input:-   XXXX
//output:-  2
//
//input:-   XX.XXX..
//output:-  2
