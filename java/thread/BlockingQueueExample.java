package com.sss.thread;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

public class BlockingQueueExample {
	public static void main(String args[]) {
		BlockingQueue<Integer> queue = new ArrayBlockingQueue<Integer>(4);
		Producer11 producer = new Producer11(queue);
		Consumer11 consumer = new Consumer11(queue);
		new Thread(producer).start();
		new Thread(producer).start();
		new Thread(producer).start();
		new Thread(consumer).start();
		new Thread(consumer).start();
		new Thread(producer).start();
	}
}


class Producer11 implements Runnable {
	
	private BlockingQueue<Integer> queue;
	AtomicInteger count;
	
	public Producer11(BlockingQueue<Integer> queue){
		this.queue = queue;
		count = new AtomicInteger(0);
		
	}
	public void run(){
		try {
			while(count.get() < 100){
				queue.put(produce());
				count.incrementAndGet();
			}
			// this is for consumer to stop consuming
			queue.put(-1);
		} catch(InterruptedException exp){
			
		}
		
	}
	
	private Integer produce(){
		Integer i = new Random().nextInt(100); 
		System.out.println(Thread.currentThread().getName()+" producing "+ i);
		return i;
	}
}

class Consumer11 implements Runnable {
	
	private BlockingQueue<Integer> queue;
	private boolean stop;
	
	public Consumer11(BlockingQueue<Integer> queue){
		this.queue = queue;
	}
	
	public void run(){
		try {
			
			do {
				Integer i = queue.take();
				 if(i == -1) 
				{ stop = true;}
				 else { consume(i); }
			} while(!stop);
			
		} catch(InterruptedException exp){
			exp.printStackTrace();
		}
	}
	
	private void consume(Integer i){
		System.out.println(Thread.currentThread().getName()+" consuming "+i);
	}
}