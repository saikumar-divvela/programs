package com.sss.collection;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

public class ThreadSafeIteratorExample {
	public static void main(String args[]){
		
		List<String> list = new CopyOnWriteArrayList<String>();
		
		list.add ("1");
		list.add ("2");
		list.add ("3");
		list.add ("4");
		list.add ("5");
		
		// iterator works on orginal list even though collection is modified while iterating
		Iterator<String> it = list.iterator();
		while(it.hasNext()){
			String value = it.next();
			System.out.println("List value "+value);
			if(value.equals("3")){
				list.remove("4");
				list.add("6");
				list.add("7");
			}
		}
		System.out.println("List size:"+list.size());
		
		it = list.iterator();
		while(it.hasNext()){
			String value = it.next();
			System.out.println("List value "+value);
		}
	
		Map<String,String> map = new ConcurrentHashMap<String,String>();
		map.put("1", "1");
		map.put("2", "2");
		map.put("3", "3");
		map.put("4", "4");
		
		// the behaviour is not same. 
		
		it = map.keySet().iterator();
		while(it.hasNext()){
			String key = it.next();
			System.out.println("Key value "+map.get(key));
			if(key.equals("3")){
				map.remove("2");
				map.put("5", "5");
				map.put("6", "6");		
			}
		}
		
		System.out.println("Map size "+map.size());
		
		it = map.keySet().iterator();
		while(it.hasNext()){
			String key = it.next();
			System.out.println("Key value "+map.get(key));
		}
	}
}
