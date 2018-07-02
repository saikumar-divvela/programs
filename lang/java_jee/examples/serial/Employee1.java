package com.sss.serial;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.ObjectStreamException;

public class Employee1 implements Externalizable{
	
	private static final long serialVersionUID = 1L;
	int id;
	String name;
	int mnumber;
	public Employee1(int id,String name,int mnumber){
		this.id = id;
		this.name = name;
		this.mnumber = mnumber;
	}
	
	public Employee1(){
		
	}
	
	@Override
	public int hashCode(){
		return  id;
	}
	
	@Override
	public boolean equals(Object obj){
		if((obj == null) || (obj.getClass() != this.getClass()))
            return false;
		Employee1 e = (Employee1)obj;
        return id == e.id && name.equals(e.name);
	}
	
	public String  toString(){
		StringBuffer sb = new StringBuffer();
		sb.append("Id ="+id+",name ="+name+" ,mobile numbre:"+mnumber);
		return sb.toString();
	}
	
	public void readExternal(ObjectInput in) throws IOException{
		System.out.println("calling readExternal");
		id = in.readInt();
	}
	
	public void writeExternal(ObjectOutput out) throws IOException{
		System.out.println("calling writeExternal");
		out.writeInt(id);
	}
	
	// this method is ignored
	private void writeObject(ObjectOutputStream out) throws IOException{
		System.out.println("calling writeObject");
		//out.writeInt(mnumber2);
		//out.writeInt(landlinenumber);
		out.defaultWriteObject();
	}
	
	// this method is ignored
	private void readObject(ObjectInputStream in) throws ClassNotFoundException,IOException{
		System.out.println("calling readObject");
		//mnumber2 = in.readInt();
		//landlinenumber = in.readInt();
		in.defaultReadObject();
	}
	
	
	// use this method if you want to return alternative object
	private Object writeReplace() throws ObjectStreamException{
		System.out.println("calling writeReplace");
		return new Employee1(20,"neeru",145);
	}
	
	
	/*
	// this can be used in singleton to return the same instance when somebody  tries to serialize and deserialize
	private Object readResolve() throws ObjectStreamException{
		System.out.println("calling readResolve");
		return new Employee1(30,"xyz",567);
	}
	*/
	
}

