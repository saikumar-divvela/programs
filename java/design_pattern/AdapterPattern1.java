package com.sss.patterns;


/*
alternative to wrapper class or decorative pattern
	when needed
		This pattern allows two different interfaces work together. Interfaces may be incompatible but the inner
		 functionality should suit the need.
	how implemented
		using inheritance or using composition.
	example:
		American socket/plug are different from british socket/adapter. we can use adapter to work with american plug.
		Java api example:
		java.io.InputStreamReader(InputStream)
		java.io.OutputStreamWriter(OutputStream)
		card reader, connecting memory card in laptop
*/

public class AdapterPattern1 {
	
	public static void main(String args[]) throws Exception{
		Itarget target = new Adapter();
		target.methodA();
	}
}

interface Itarget {
	public void methodA();
}

class Adapter implements Itarget{
	Itarget2 adaptee = new Adaptee();
	
	public void methodA(){
		adaptee.methodB();
	}
}

interface Itarget2{
	public void methodB();
}

class Adaptee implements Itarget2 {
	public void methodB(){
		System.out.println("In method B");
	}
}