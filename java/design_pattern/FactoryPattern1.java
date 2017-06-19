package com.sss.patterns;

/*
  Example of factory pattern This uses static method to create objects
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
public class FactoryPattern1 {
	public static void main(String args[]) throws Exception {
		Shape s1 = ShapeFactory.createShape("circle");
		Shape s2 = ShapeFactory.createShape("square");
		s1.draw();
		s2.draw();
	}
}

interface Shape{
	void draw();
	void move();
}

class ShapeFactory {
	
	private ShapeFactory(){
		
	}
	
	public static Shape createShape(String shape){
		if( shape .equalsIgnoreCase("circle")){
			return new Circle();
		} else if (shape.equalsIgnoreCase("square")){
			return new Square();
		}
		return null;
	}
}

class Circle implements Shape {
	public void draw(){
		System.out.println("Drawing circle");
	}
	public void move(){
		System.out.println("Moving circle");
	}
}

class Square implements Shape {
	public void draw(){
		System.out.println("Drawing square");
	}
	public void move(){
		System.out.println("Moving square");
	}
}