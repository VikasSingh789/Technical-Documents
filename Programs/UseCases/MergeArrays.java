import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MergeArrays {

	public static void main(String[] args) {
		System.out.println("1:- Merge Arrays By Collections.addAll()");
		Integer a[] = { 1, 2, 3 };
		Integer b[] = { 4, 5, 6 };
		List<Object> list = new ArrayList<>();
		Collections.addAll(list, a);
		Collections.addAll(list, b);
		System.out.println(list);
		
		
		System.out.println("\n 2:- Merge Arrays By Stream.concat()");
		List<Integer> l2 = Stream.concat(Arrays.stream(a), Arrays.stream(b)).sorted().collect(Collectors.toList());
		System.out.println("As List:- " + l2);
		
		
		
		System.out.println("\n 3:- Merge Arrays By Stream.concat() with Primitive Array");
		int c[] = { 1, 2, 3 };
		int d[] = { 4, 5, 6 };
		Integer[] x = Stream.concat(Arrays.stream(c).boxed(), Arrays.stream(d).boxed()).sorted().toArray(Integer[]::new);
		System.out.println("As Arrays:- " + Arrays.toString(x));
		List<Integer> y = Stream.concat(Arrays.stream(c).boxed(), Arrays.stream(d).boxed()).sorted().collect(Collectors.toList());
		System.out.println("As List:- "+y);

	}
}

//input:-   { 1, 2, 3 }
//          { 4, 5, 6 }		 
//output:-  [1, 2, 3, 4, 5, 6]
