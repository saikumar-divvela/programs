package com.sss.thread;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduledThreadPool {
	public static void main(String args[]) throws Exception{
		ScheduledExecutorService service = Executors.newScheduledThreadPool(5);
		
		for(int i=0;i <3;i++){
			Thread.sleep(1000);
			WorkerThread worker = new WorkerThread("do heavy processing");
			service.schedule(worker, 4, TimeUnit.SECONDS);
		}
		
		service.shutdown();
		
		while(!service.isTerminated()){
		}
		
		System.out.println("All tasks done");
	}
}
