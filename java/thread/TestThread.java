package com.sss.thread;

public class TestThread implements Runnable {
	private String name;
	TestThread(String name){
		this.name = name;
	}
	
	TestThread(){
		this.name = "dummy";
	}
	public void run(){
		for (int i=0;i< 10;i++){
			System.out.println(name+" "+i);
		}
		
	}
	
	public static void main(String args[]) throws Exception{
		Thread t1 = new Thread(new TestThread("thread1"));
		Thread t2 = new Thread(new TestThread("thread2"));
		t1.start();
		t1.join();
		t2.start();
		t2.join();
	}

}
