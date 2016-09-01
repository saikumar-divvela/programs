package com.sss.thread;

public class ThreadDeadlock {
	public static void main(String[] args) throws InterruptedException{
		Object obj1 = new Object();
		Object obj2 = new Object();
		Object obj3 = new Object();
		
		Thread t1 = new Thread(new SyncObject(obj1,obj2),"t1");
		Thread t2 = new Thread(new SyncObject(obj2,obj3),"t2");
		Thread t3 = new Thread(new SyncObject(obj3,obj1),"t3");
		
		t1.start();
		Thread.sleep(2000);
		t2.start();
		Thread.sleep(2000);
		t3.start();
	}
}


class SyncObject implements Runnable {
	Object obj1,obj2;
	
	public SyncObject(Object obj1,Object obj2){
		this.obj1 = obj1;
		this.obj2 = obj2;
	}
	
	public void run(){
		System.out.println(Thread.currentThread().getName()+" acquiring lock on "+obj1.toString());
		synchronized(obj1){
			System.out.println(Thread.currentThread().getName()+" acquired lock on "+obj1.toString());
			work();
			System.out.println(Thread.currentThread().getName()+" acquiring lock on "+obj2.toString());
			synchronized(obj2){
				System.out.println(Thread.currentThread().getName()+" acquired lock on "+obj2.toString());
			}
			System.out.println(Thread.currentThread().getName()+" releasing lock on "+obj2.toString());
		}
		System.out.println(Thread.currentThread().getName()+" releasing lock on "+obj1.toString());
	}
	
	private void work(){
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e){
			e.printStackTrace();
		}
	}
}

