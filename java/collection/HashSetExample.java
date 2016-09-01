package com.sss.collection;

import java.util.HashSet;
import java.util.Set;

public class HashSetExample {
		public static void main(String args[]) throws Exception {
			Set<Int> set = new HashSet<Int>();
			set.add(new Int(27));
			set.add(new Int(28));
			System.out.println(set);
		}
}


class Int {
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
	
	
	
}