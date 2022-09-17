package simpleprograms;

import java.util.HashSet;
import java.util.Set;

class Student{
	int sid;
	String sname;
	Student(int sid,String sname){
		this.sid=sid;
		this.sname=sname;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + sid;
		result = prime * result + ((sname == null) ? 0 : sname.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		if (sid != other.sid)
			return false;
		if (sname == null) {
			if (other.sname != null)
				return false;
		} else if (!sname.equals(other.sname))
			return false;
		return true;
	}
	
	
}

public class HashCodeExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Student s1=new Student(1,"vikas");
		Student s2=new Student(1,"vikas");
		Set<Student> s=new HashSet<Student>();
		s.add(s1);
		s.add(s2);
		System.out.println(s1.hashCode());
		System.out.println(s2.hashCode());
		for(Student obj:s){
			System.out.println(obj.hashCode());
		}
	}

}
