package com.sss.patterns;

import java.util.HashMap;

/*
  Example of factory pattern. This allows products to be added dynamically.
  	Encapsulating creation of objects. this enables replacement of objects with new versions without any change in client 
  	layer
	We can use static factory methods to get different objects by making constructor private. Typically factory class is 
	singleton	
	Object creation is delegated to subclasses that implement the factory method to create objects. All classes implement 
	the interface that has factory method. 
	when this is required
		The creation of an object is complex and makes reuse impossible without significant duplication of code.
		The creation of an object requires access to information or resources that should not be contained within the 
		composing class
		The lifetime management of the generated objects must be centralized to ensure a consistent behavior within the
		application.
	Example:
	Toolkits, Frameworks, GUI API	
 */
public class FactoryPattern2{
	static
	{
		try {
			Class.forName("com.sss.patterns.Rectangle");
			Class.forName("com.sss.patterns.Triangle");
		} catch(Exception exp){
			System.out.println(exp.getMessage());
			exp.printStackTrace();
		}
		
	}

	public static void main(String args[]) throws Exception {
		Shape s1 = GUIFactory.instance().createShape("rectangle");
		Shape s2 = GUIFactory.instance().createShape("triangle");
		s1.draw();
		s2.draw();
	}
}



class GUIFactory {
	
	private static HashMap<String,Shape> registeredShapes = new HashMap<String,Shape>();
	private static final GUIFactory instance = new GUIFactory();
	
	private GUIFactory(){
		
	}
	
	public static GUIFactory instance(){
		return instance;
	}
	
	public void registerShape(String name,Shape shape){
		registeredShapes.put(name, shape);
	}
	
	public  Shape createShape(String shape){
		return registeredShapes.get(shape);
	}
}

class Rectangle implements Shape {
	
	static {
		System.out.println("Registering rectangle");
		GUIFactory.instance().registerShape("rectangle", new Rectangle());
	}
	
	public void draw(){
		System.out.println("Drawing Rectangle");
	}
	public void move(){
		System.out.println("Moving Rectangle");
	}

	/*
	public Rectangle createShape(){
		return new Rectangle();
	}*/
}

class Triangle implements Shape {
	
	static {
		System.out.println("Registering triangle");
		GUIFactory.instance().registerShape("triangle", new Triangle());
	}
	
	public void draw(){
		System.out.println("Drawing Triangle");
	}
	public void move(){
		System.out.println("Moving Triangle");
	}
	/*
	public Triangle createShape(){
		return new Triangle();
	} */
}