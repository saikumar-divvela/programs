package com.sss.collection;

import java.util.HashMap;
import java.util.Map;

public class HashMapKeyExample {
	public static void main(String args[]) {
		Map<Student,String> map = new HashMap<Student,String>();
		Student s1 = new Student(11,"sai");
		Student s2 = new Student(11,"neeru");
		
		map.put(s1, "one");
		s1.id = 14;
		//s2.id = 14;
		
		System.out.println(map.get(s1));
		System.out.println(map.get(s2));
		
		map.put(s2, "two");
		
		System.out.println(map.get(s1));
		System.out.println(map.get(s2));
		
		/*
		System.out.println(1<<30);
		int h= 198;
		System.out.println(h >>> 20);
		System.out.println(h >>> 12);
		System.out.println((h >>> 20) ^ (h >>> 12));
		h ^= (h >>> 20) ^ (h >>> 12);
		 System.out.println(h); 
		 System.out.println(h >>> 7);
			System.out.println(h >>> 4);
			System.out.println((h >>> 7) ^ (h >>> 4));
		h = h ^ (h >>> 7) ^ (h >>> 4);
		 System.out.println(h);
		 System.out.println(h & 100);
		 */
		 //1000
		 //1010
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