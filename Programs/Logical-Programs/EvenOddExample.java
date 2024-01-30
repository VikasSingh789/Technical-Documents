import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class EvenOddExample {
	public static void main(String[] args) {
		List<Integer> listOfNumbers = Arrays.asList(1,2,3,4,5,6,7,8);
		
		Map<Boolean, List<Integer>> partitions = listOfNumbers.stream().collect(Collectors.partitioningBy(n->n%2==0));
		System.out.println("By Using Partitions");
		System.out.println(partitions.get(true));
		System.out.println(partitions.get(false));
		System.out.println("======================");
		System.out.println("By Using grouping");
		Map<Object, List<Integer>> groupingBy = listOfNumbers.stream().collect(Collectors.groupingBy(n -> n % 2 == 0 ? "EVEN" : "ODD"));
		System.out.println(groupingBy.get("EVEN"));
		System.out.println(groupingBy.get("ODD"));
	}
}
