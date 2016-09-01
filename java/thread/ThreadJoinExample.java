package com.sss.thread;

public class ThreadJoinExample {
	public static void main(String[] args){
		ThreadGroup g = new ThreadGroup("group1");
		Thread t1 = new Thread(g,new MyRunnable(),"t1");
		Thread t2 = new Thread(g,new MyRunnable(),"t2");
		Thread t3 = new Thread(g,new MyRunnable(),"t3");
		t1.start();
		//start second thread after waiting for 2 seconds or if it's dead
		System.out.println(t1.activeCount());
		/*
		try {
			t1.wait();
		} catch(InterruptedException e){
			System.out.println(e.getMessage());
		}*/
		try {
			t1.join(2000);
		} catch(InterruptedException exp){
			System.out.println(t1.getName()+" interrupted");
		}
		t2.start();
		//start third thread only when first thread is dead
		try {
			t1.join();
		} catch(InterruptedException exp){
			System.out.println(t1.getName()+" interrupted");
		}
		t3.start();
		System.out.println(t1.activeCount());
		//let all threads finish execution before finishing main thread
		try {
			t1.join();
			t2.join();
			t3.join();
		} catch(InterruptedException exp){
			exp.printStackTrace();
		}
		System.out.println(t1.activeCount());
	}

}

class MyRunnable implements Runnable {
	
	public void run(){
		System.out.println("Starting .... "+ Thread.currentThread().getName());
		try {
			Thread.sleep(4000);
		} catch(InterruptedException exp){
			System.out.println(Thread.currentThread().getName()+" interrupted");
		}
		System.out.println("Ending .... "+ Thread.currentThread().getName());
		
	}
}