package com.sss.patterns;


import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

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
public class ProxyExample2 {
	public static void main(String args[]){
		IFolder folder = new Folder("xyz");
		User user = new User("sai","sai");
		IFolder proxy = (IFolder)Proxy.newProxyInstance(folder.getClass().getClassLoader(),folder.getClass().getInterfaces(), 
				new SimpleInvocationHanlder(folder,user));
		proxy.doOperation();
	}
}


interface IFolder{
	public void doOperation();
}

class Folder implements  IFolder{
	private String fileName;
	
	public Folder(String fileName){
		this.fileName = fileName;
		openFolder();
	}
	
	private void openFolder(){
		System.out.println("Opening folder "+fileName);
	}
	public void doOperation(){
		System.out.println("Performing operation on  "+fileName);
	}
}

class SimpleInvocationHanlder implements InvocationHandler {
	private Object realSubject;
	private User user;
	public SimpleInvocationHanlder(Object realSubject,User user){
		this.realSubject = realSubject;
		this.user = user;
	}
	public Object invoke(Object proxy,Method m,Object []args){
		Object result = null;
		System.out.println("Before calling..."+m.getName());
		try {
			if(user.getUserName().equals("sai") && user.getPassword().equals("sai")){
				m.invoke(realSubject, args);
			} else {
				System.out.println(" Invalid user name and password... Not calling "+m.getName());
			}
			
		} catch(Exception exp){
			System.out.println("Exception occurred while executing "+m.getName());
			exp.printStackTrace();
		}
		System.out.println("After calling..."+m.getName());
		return result;
	}

}

class User {
	private String userName;
	private String password;
	public User(){
		
	}
	public User(String userName,String password){
		this.userName = userName;
		this.password = password;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}