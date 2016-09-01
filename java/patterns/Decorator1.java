package com.sss.patterns;



/*
   Decorator pattern is  known as wrapper to enhance/add behaviour to individual objects either statically or dynamically
   This is an alternative to subclassing.
1)Subclass the original "Component" class into a "Decorator" class
2)In the Decorator class, add a Component pointer as a field;
3)Pass a Component to the Decorator constructor to initialise the Component pointer;
4)In the Decorator class, redirect all "Component" methods to the "Component" pointer; and
5)In the ConcreteDecorator class, override any Component method(s) whose behaviour needs to be modified


    Example: 1) Java IO classes  
	BufferedReader adds behaviour to FileReader/InputStreamReader. 
	InputStreamReader is bridge between byte stream and character stream
	FileReader/FileInputStream to read file as raw bytes
	InputStreamReader/ByteArrayInputStream/BufferedInputStream	
	2) Scrolling windows
*/

public class Decorator1 {
	public static void main(String args[]){
		Window window = new VerticalScrollbarWindow(new HorizontalScrollbarWindow(new SimpleWindow()));
		window.draw();
		System.out.println(window.getDescription());
		window = new BorderWindow(new SimpleWindow());
		System.out.println(window.getDescription());
		window = new BorderWindow(new VerticalScrollbarWindow(new SimpleWindow()));
		System.out.println(window.getDescription());
	}
}

interface Window {
	public void draw();
	public String getDescription();
}

class SimpleWindow implements Window{
	
	public void draw(){
		// do something
	}
	
	public String getDescription(){
		return "Simple window";
	}
}

abstract class WindowDecorator implements Window{
	protected Window decoratedWindow;
	
	public WindowDecorator(Window window){
		this.decoratedWindow = window;
	}
	
	public void draw(){
		decoratedWindow.draw();
	}
	
	public String getDescription(){
		return decoratedWindow.getDescription();
	}
}

class HorizontalScrollbarWindow extends WindowDecorator{
	
	public HorizontalScrollbarWindow(Window window){
		super(window);
	}
	
	@Override
	public void draw(){
		super.draw();
		drawHorizontalScrollbar();
	}
	
	@Override
	public String  getDescription(){
		return super.getDescription()+", including horizontal scrollbar";
	}

	private void drawHorizontalScrollbar(){
		// do something;
	}
}


class VerticalScrollbarWindow extends WindowDecorator{
	public VerticalScrollbarWindow(Window decoratedWindow){
		super(decoratedWindow);
	}
	
	@Override
	public void draw(){
		super.draw();
		drawVerticalScrollbar();
	}
	
	@Override
	public String getDescription(){
		return super.getDescription()+", including vertical scroll bar";
	}
	
	private void drawVerticalScrollbar(){
		// do something
	}
}

class BorderWindow extends WindowDecorator{
	public BorderWindow(Window decoratedWindow){
		super(decoratedWindow);
	}
	
	@Override
	public void draw(){
		super.draw();
		drawBorder();
	}
	
	@Override 
	public String getDescription(){
		return super.getDescription()+", including borders";
	}
	
	public  void drawBorder(){
		// do something;
	}

}