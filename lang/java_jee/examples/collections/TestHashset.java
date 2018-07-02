import java.util.*;


public class TestHashset extends HashSet<Person> {
public static void main(String[] args) {
TestHashset g = new TestHashset();
Person p1 =  new Person("Hans");
Person p2 =  new Person("Janes");
g.add(new Person("Lotte"));
g.add(new Person("Hans"));
/*
g.add(p1);
g.add(p1);
g.add(new Person("Hans"));
*/
System.out.println("Total: " + g.size());
for(Person p: g){
	System.out.println(p);
}
}
public boolean add(Person o) {
System.out.println("Adding: " + o);
return super.add(o);
}
}
	class Person implements Comparable<Person>{
		private final String name;
		public Person(String name) { this.name = name; }
		public String toString() { return name; }
		public int compareTo(Person x){
			System.out.println("compareTo called");
			return name.compareTo(x.toString());
		}
		public boolean equals(Object o){
			System.out.println("equals is called");
			if(o instanceof Person){
					return (this.name.equals(((Person)o).toString()));
			}
			return false;
		}
		
		public int hashCode(){
			return 12;
		}
	}


/*
public class TestHashset 
{
		public static void main(String args[]){
				HashSet<String>  hs = new HashSet<String>();
				hs.add("1");
				hs.add("2");
				hs.add("1");
				for(String s: hs){
					System.out.println(s);
				}
				System.out.println("Total: " + hs.size());
		}
}
*/