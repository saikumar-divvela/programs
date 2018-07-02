import java.util.*;
class TestQueue {
		public static void main(String[] args) {
			Queue<String> x = new PriorityQueue<String>();
			x.add("one");
			x.add("two");
			x.add("TWO");
			System.out.println(x.poll());
		}
}