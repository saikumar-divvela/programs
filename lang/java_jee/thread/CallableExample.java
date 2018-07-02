package com.sss.thread;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableExample {
	public static void main(String args[]) {
		ExecutorService service = Executors.newFixedThreadPool(3);
		List<Future<String>> futures = new LinkedList<Future<String>>();
		Callable<String> callable = new MyCallable();
		for(int i=0;i<10;i++){
			 Future<String> future = service.submit(callable);
			futures.add(future);
		}
		service.shutdown();
		while(!service.isTerminated()){
		}
		for(Future<String> f: futures){
			try {
				System.out.println(f.get());
			} catch ( InterruptedException | ExecutionException exp){
				exp.printStackTrace();
			}
		}
	}
}


class MyCallable implements Callable<String>{
	
	public String call() throws Exception{
		Thread.sleep(1000);
		return Thread.currentThread().getName();
	}
}