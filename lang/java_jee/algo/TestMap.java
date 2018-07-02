package com.sss.algo;
import java.util.HashMap;
import java.util.HashSet;


class Employee {
	int id;
	String name;
	int mnumber;
	public Employee(int id,String name,int mnumber){
		this.id = id;
		this.name = name;
		this.mnumber = mnumber;
	}
	
	@Override
	public int hashCode(){
		return  id;
		//return 9;
	}
	
	@Override
	public boolean equals(Object obj){
		if((obj == null) || (obj.getClass() != this.getClass()))
            return false;
		Employee e = (Employee)obj;
        return id == e.id && name.equals(e.name);
	  // return name.equals(e.name);
	}
	
	public String  toString(){
		StringBuffer sb = new StringBuffer();
		sb.append("Id ="+id+",name ="+name+" ,mobile numbre:"+mnumber);
		return sb.toString();
	}
}

public class TestMap {

	public static void main(String args[]){
		HashMap h = new HashMap();
		Employee e1 = new Employee(1,"SSS1",12);
		Employee e2 = new Employee(1,"SSS2",23);
		Employee e3 = new Employee(1,"SSS1",45);
		h.put(e1,e1);
		h.put(e2,e2);
		h.put(e3,e3);
		h.put("a", 123);
		h.put("a", 456);
		
		//h.put("a", 12);
		//h.put("a", 13);
		System.out.println("Number of objects:"+h.size());
		System.out.println(h.get(e1));
		System.out.println(h.get(e2));
		System.out.println(h.get(e3));
		System.out.println(h.get("a"));
		
		HashSet set = new HashSet();
		set.add(e1);
		set.add(e2);
		set.add(e3);
		set.add(null);
		set.add(null);
		System.out.println("Number of objects:"+set.size());
		//System.out.println(set.get(e2));
	}
}
