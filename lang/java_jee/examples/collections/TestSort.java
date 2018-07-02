import java.util.*;
class TestSort {
		public static void main(String[] args) {
				List<String> x = new ArrayList<String>();
				x.add(" x"); x.add("xx"); x.add("Xx");
				Comparator c = Collections.reverseOrder();
				Collections.sort(x,c);				
				for(String s: x) System.out.println(s);
		}
}