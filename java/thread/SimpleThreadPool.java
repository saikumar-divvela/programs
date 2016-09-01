package com.sss.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class WorkerThread implements Runnable{
	private String command;
	
	public WorkerThread(String s){
		this.command = s;
	}
	
	public void run(){
		System.out.println(Thread.currentThread().getName()+" Start command "+command);
		processCommand();
		System.out.println(Thread.currentThread().getName()+" End command "+command);
	}
	
	private void processCommand(){
		try{
			Thread.sleep(5000);
		} catch(Exception exp){
			exp.printStackTrace();
		}
	}
}

public class SimpleThreadPool {
	public static void main(String args[]){
		ExecutorService executor = Executors.newFixedThreadPool(5);
		for(int i=0;i<10;i++){
			WorkerThread worker = new WorkerThread(""+i);
			executor.execute(worker);
		}
		executor.shutdown();
		while(!executor.isTerminated()){
		}
		System.out.println("All tasks finished");
	}
	
}