package com.sss.algo;

public class HelloWorld {
	public  native void display();
	static {
		System.loadLibrary("hello");
	}
}	
