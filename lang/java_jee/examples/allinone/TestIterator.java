import java.util.*;

public class TestIterator
{
		public static Iterator reverse(List list) {
			 Collections.reverse(list);
			 return list.iterator();
		}
		public static void main(String[] args) {
			 List<String>  list = new ArrayList<String>();
			list.add(" 1"); list.add("2"); list.add("3");
			Collections.reverse(list);
			for (String obj: list)
				 System.out.print(obj + ",");
		}
}
