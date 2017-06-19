package com.sss.patterns;

/*
 used for maintaining one instance of expensive object -> examples Java.lang.Runtime getRuntime() 
 Java.awt.Toolkit
  with getDefaultToolkit()
	lazy loading using getInstance -> uses double checks
	early loading uses static final -> loaded during class loading
	Enum singletons are better than Java based singletons
 */
public class SingletonPattern1 {
	public static void main(String args[]){
		Singleton sing = Singleton.getInstance(); 
	}
}

class Singleton{
	// early instantiation during class loading
	//private static final Singleton instance = new Singleton();
	
	/*
	public static Singleton getInstance(){
		return instance;
	} */
	
	// lazy loading
	
	private static Singleton instance;
	
	public static Singleton getInstance(){
		
		if(instance == null){
			synchronized(Singleton.class){
				if(instance == null){
					instance = new Singleton();
				}
			}
		}
		return instance;
	}
	
	
	
	private Singleton(){
		System.out.println("Creating singleton instance");
	}
	

	public Object clone() throws CloneNotSupportedException{
		throw new CloneNotSupportedException();
	}
	
	public Object readResolve() throws Exception{
		throw new Exception();
	}
}