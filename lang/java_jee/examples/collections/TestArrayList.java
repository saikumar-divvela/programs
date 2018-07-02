/*
	ArrayList example	
*/

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

public class TestArrayList
{
	public static void main(String args[]){
		List<String> test = new ArrayList<String>();
		String s = "test";
		test.add(s);
		test.add(s+s);
		test.add("string");
		test.add("hi");
		System.out.println("unsorted list:");
		for(String x:test){
			System.out.println(x);
		}
		Collections.sort(test);
		System.out.println("sorted list:"+test);
		Collections.reverse(test);
		System.out.println("sorted list:"+test);
		System.out.println(test.size());
		System.out.println(test.contains(32));
		System.out.println(test.contains(s+s));
		System.out.println(test.remove(s+1));
		System.out.println(test.size());
	}
}