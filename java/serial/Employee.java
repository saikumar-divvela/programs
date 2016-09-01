package com.sss.serial;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class  BigBoss {
	public int i;
	private int j;
	protected int k;
	
	public BigBoss(){
		
	}
	public void set(int i,int j,int k){
		this.i = i;
		this.j = j;
		this.k = k;
	}
	@Override
	public String toString() {
		return "BigBoss [i=" + i + ", j=" + j + ", k=" + k + "]";
	}
	
	private void writeObject(ObjectOutputStream out) throws IOException{
		System.out.println("bigboss calling writeObject");
		out.defaultWriteObject();
	}
	
	private void readObject(ObjectInputStream in) throws ClassNotFoundException,IOException{
		System.out.println("bigboss calling readObject");
		in.defaultReadObject();
	}
}

public class Employee extends BigBoss implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private String name;
	private int mnumber;
	static int landlinenumber = 100;
	transient int mnumber2 = 200;
	
	
	public Employee(int id,String name,int mnumber){
		this.id = id;
		this.name = name;
		this.mnumber = mnumber;
		this.setBoss(10,20,30);
	}
	
	public void setBoss(int i,int j,int k){
		super.set(i, j, k);
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
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", mnumber=" + mnumber
				 + ", mnumber2=" + mnumber2 + ", landlinenumber=" + landlinenumber 
				+ " "+super.toString()+"]";
	}
	
	private void writeObject(ObjectOutputStream out) throws IOException{
		System.out.println("calling writeObject");
		//out.writeInt(mnumber2);
		//out.writeInt(landlinenumber);
		out.defaultWriteObject();
	}
	
	private void readObject(ObjectInputStream in) throws ClassNotFoundException,IOException{
		System.out.println("calling readObject");
		//mnumber2 = in.readInt();
		//landlinenumber = in.readInt();
		in.defaultReadObject();
	}
	
	/*
	// use this method if you want to return alternative object
	private Object writeReplace() throws ObjectStreamException{
		System.out.println("calling writeReplace");
		return new Employee(20,"neeru",145);
	}
	*/
	
	/*
	// this can be used in singleton to return the same instance when somebody  tries to serialize and deserialize
	private Object readResolve() throws ObjectStreamException{
		System.out.println("calling readResolve");
		return new Employee(30,"xyz",567);
	}*/
}
