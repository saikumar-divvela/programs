
import java.util.*;
public class TestTreeSet
{
	public static void main(String args[]) {
			Set set = new TreeSet();
			set.add("2");
			set.add("1");
			set.add("1");
			Iterator it = set.iterator();
			while (it.hasNext())
					System.out.print(it.next() + " ");
	}
}