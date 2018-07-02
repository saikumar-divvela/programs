package com.sss.serial;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/*
 *  Notserializableexception -If the class doesn't implement serializable interface and if we try to serialize we get this
 *  Also if the class has a Object which is not serializable then also we get this exception
 *  
 *  ClassCastException - if we try to cast deserialized object to different class
 *  
 *  InvalidClassException - if the deserialized class serialversionid doesn't match with local class serialversionid
 *  Even if we remove/add attributes to local class we don't get exception
 *  
 *  All subtypes of serialized class are by default serializable
 *  
 *  Subtypes of non serialized classes can be serialized only if the base class has no arg public or protected constructor
 *  otherwise run time error comes when we try to serialize sub class.
 *  It is responsibility of sub type for saving and restoring public, protected, package fields of base class
 *  
 *  writeObject and readObject are used to save/restore the state. using this we can serialize transient, static fields and 
 *  also super class fields.
 *  
 *  Externalizable can be used to control the format and serialization. class has to do everything needed to save and restore state.
 *  
 */
public class TestSerialize {
		
		public static void serialize() throws Exception{
			//Employee e  = new Employee(12,"sai",123); 
			Employee1 e  = new Employee1(12,"sai",123);
			System.out.println(e);
			FileOutputStream fOut = new FileOutputStream(new File("employee.ser"));
			ObjectOutputStream oOut = new ObjectOutputStream(fOut);
			oOut.writeObject(e);
			oOut.close();
			fOut.close();
		}
		
		public static void deserialize() throws Exception{
			FileInputStream fIn = new FileInputStream(new File("employee.ser"));
			ObjectInputStream oIn = new ObjectInputStream(fIn);
			//Employee.landlinenumber = 200;
			//Employee e = (Employee)oIn.readObject();
			Employee1 e = (Employee1)oIn.readObject();
			oIn.close();
			fIn.close();
			System.out.println(e);
		}
	
		public static void main(String args[]) throws Exception{
			TestSerialize.serialize();
			TestSerialize.deserialize();
		}
}
