package simpleprograms;
class Examples{
	Object print(Object i) {
		System.out.println("Object's method"+i);
		return null;
	}
	String print(String i) {
		System.out.println("String's method");
		return null;
	}
}
class MethodOver{
	public Integer m1(String i) {
		System.out.println("Integer Method");
		return null;
	}
}
class Methods extends MethodOver{
	public String m1() {
		System.out.println("String Method");
		return null;
	}
}
public class MethodOverExmple {

	public static void main(String[] args) {
		

	}

}
