import java.util.*;
public class TestPriorityQueue 
{
		public static void main(String[] args) 
		{
				PriorityQueue<String> pq = new PriorityQueue<String>();
				pq.add("carrot");
				pq.add("apple");
				pq.add("banana");
				for(String str: pq){
						System.out.println(str);
				}
				//System.out.println(pq.poll() +":" + pq.peek());
		}
 }
