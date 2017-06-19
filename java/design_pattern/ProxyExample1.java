package com.sss.patterns;

/*
Controls access to an object. Place holder for object. A proxy is class functioning as an interface to something else. 
It can interface to anything. ex network connection, large object in memory,a file or some other resource that is
expensive or impossible to duplicate.
	Real class and Proxy implement the same interface. The operation on proxy class is delivered to actual class.
when we need multiple copies of complex object, one complex object is created and multiple proxy objects are created. 
All of them point to original object.
Example:
Remote proxy -> local proxy represents remote object  (Web service Stub or rest resources)
Virtual proxy -> light weight version of remote object. Creates expensive object on demand. Object is not created 
until the need comes. (Hibernate proxy, AOP proxy)
Protection proxy-> controls access to original object. Proxy server for internet to restrict access to some sites
AOP proxy

JDK	supports proxy directly musing java.lang.reflect package, Proxy,Method and InvocationHandler	

*/
public class ProxyExample1 {
	public static void main(String args[]) throws Exception{
		ProxyImage proxy1 = new ProxyImage("image1.jpg");
		ProxyImage proxy2 = new ProxyImage("image2.jpg");
		proxy1.displayImage();
		proxy2.displayImage();
		proxy1.displayImage();
		proxy1.displayImage();
		proxy2.displayImage();
	}
}


interface Image{
	public void displayImage();
}

class RealImage implements Image {
	private String fileName;
	
	public RealImage(String fileName){
		this.fileName = fileName;
		loadImageFromDisk();
	}
	
	private void loadImageFromDisk(){
		System.out.println("Loading image from disk....");
	}
	
	public void displayImage(){
		System.out.println("Displaying image "+fileName);
		// do something
	}
}

class ProxyImage implements Image{
	private RealImage image ;
	String fileName;
	
	public ProxyImage(String fileName){
		this.fileName = fileName;
	}
	
	public void displayImage(){
		if(image == null){
			image = new RealImage(fileName);
		}
		image.displayImage();
	}
}

