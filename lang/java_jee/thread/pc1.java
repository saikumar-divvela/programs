package com.sss.thread;

import java.util.ArrayList;
import java.util.Stack;

public class pc1 {
	
	public void change(String str ){
		str ="Saikumar";
	}
	public static void main(String args[]) throws Exception {
		System.out.println("Hello World");
		Stack<Integer> stack = new Stack<Integer>();
	
		Producer1 producer = new Producer1(stack,10);
		Consumer1 consumer = new Consumer1(stack,10);
		
		Thread p1 = new Thread(producer,"producer-1");
		Thread c1 = new Thread(consumer,"consumer-1");
		Thread c2 = new Thread(consumer,"consumer-2");
		Thread c3 = new Thread(consumer,"consumer-3");
		Thread c4 = new Thread(consumer,"consumer-4");
		
		c1.start();
		c2.start();
		c3.start();
		c4.start();
		p1.start();
		
	}
}

class Producer1 implements Runnable{
	Stack<Integer> stack;
	int MAX_ITEMS;
	
	public Producer1(Stack<Integer> stack,int maxItems){
		this.stack = stack;
		this.MAX_ITEMS = maxItems;
	}
	 
	public void run(){
		produce();
	}
	
	
	private void produce(){
		int i =1;
		while(true) {
		synchronized (stack) {
			while(stack.size() >= MAX_ITEMS){
				try {
					stack.wait(10);
				} catch(Exception exp){
					System.out.println(exp.getMessage());
				}
			}
			System.out.println(Thread.currentThread().getName()+" "+i);
			stack.push(new Integer(i));
			i++;
			stack.notifyAll();
		}
		
		}
	}
	
}

class Consumer1 implements Runnable {
	Stack<Integer> stack;
	int MAX_ITEMS;
	int count=0;
	
	public Consumer1(Stack<Integer> list1,int maxItems){
		stack = list1;
		this.MAX_ITEMS = maxItems;
	}
	
	public void run(){
		consume();
	}
	
	
	private void consume(){
		while (true){
		synchronized (stack) {
			while(stack.isEmpty()){
				try {
					stack.wait();
				} catch(Exception exp){
					System.out.println(exp.getMessage());
				}
			}
			System.out.println(Thread.currentThread().getName()+" "+stack.pop());
			stack.notifyAll();
		}
		}
	}
	

}