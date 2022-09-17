package simpleprograms;

class Bike{
	 void model() {
		 System.out.println("Parent Class model Method");
	 }
}
class Car  extends Bike{
	void model() {
		 System.out.println("Child Class model Method");
	}	
	
}

public class MethodOverridingExample {
	public static void main(String[] args) {
		Bike obj1= new Bike(); // P
		Bike obj2= new Car();  // 
		Car obj3 = new Car();
		//Car obj4 = (Car) new Bike();
//		obj1.model();
//		obj2.model();
//		obj3.model();
	}

}
