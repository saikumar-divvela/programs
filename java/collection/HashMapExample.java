import java.util.HashMap;
import java.util.Map;

public class HashMapExample {
	public static void main(String args[]) {
		Map<Student,String> map = new HashMap<Student,String>();
		Student s1 = new Student(11,"sai");
		Student s2 = new Student(12,"neeru"); // change 12 to 11 and see

   		System.out.println(map.get(null));
		
		map.put(s1, "one");
		System.out.println(map.get(s1));
        System.out.println(map.get(s2));
        map.put(s2, "two");  // 2 different objects can't have same hash code and be equal
		System.out.println(map.get(s1));
        System.out.println(map.get(s2));
        s1.id = 14; // hascode got mutated
   		System.out.println(map.get(s1));
        System.out.println(map.get(s2));
	}
}


class Student {
	public int id;
	public String name;
	
	Student(int id,String name){
		this.id = id;
		this.name = name;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
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
		if (id != other.id)
			return false;
		return true;
	}
	
	
}
