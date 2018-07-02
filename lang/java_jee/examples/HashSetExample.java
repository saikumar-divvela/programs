import java.util.HashSet;
import java.util.Set;

public class HashSetExample {
		public static void main(String args[]) throws Exception {
			Set<Int> set = new HashSet<Int>();
            Int i1 = new Int(27);
            Int i2 = new Int(28);  
			set.add(i1);
			set.add(i2);
			System.out.println(set);
  			System.out.println(set.contains(i1));
            Int i3 = (Int) i1.clone();
            System.out.println((i3==i1) + " "+ set.contains(i3));
   			System.out.println(set);
		}
}


class Int implements Cloneable {
	private int x;
	
	Int(int x){
		this.x =x ;
	}

	@Override
	public int hashCode() {
		/*
		final int prime = 31;
		int result = 1;
		result = prime * result + x;
		return result;
		*/
		return x/10;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Int other = (Int) obj;
		if (x != other.x)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Int [x=" + x + "]";
	}
	
	public void setValue(int x ){
        this.x = x;
    }
	
    public Int clone() throws CloneNotSupportedException{
        return (Int) super.clone();
    }
}
