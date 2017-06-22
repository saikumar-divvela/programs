

import java.util.Stack;



class Producer implements Runnable {
	
	Stack<Integer> items;
	int MAX_ITEMS;
	
	public Producer(Stack<Integer> d,int max_items){
		this.items = d;
		MAX_ITEMS = max_items;
	}
	
	public void run (){
		int i=0;
		while(i<MAX_ITEMS){
		  synchronized(items) {	
				produce(i);
				i++;
				items.notifyAll();
		  }		
		  try {
			  Thread.sleep(100);
		  } catch(Exception ex){
			  
		  }
		}
	}
	
	private void produce(int i){
			items.push(new Integer(i));
			System.out.println(Thread.currentThread().getName()+" :"+i);
	}

}

class Consumer implements Runnable {
	Stack<Integer> items;
	int MAX_ITEMS;
	int count=0;
	
	public Consumer(Stack<Integer> d,int max_items){
		this.items = d;
		MAX_ITEMS = max_items;
	}
	
	public void run(){
		while(count < MAX_ITEMS){
			synchronized(items){
				
				while(items.isEmpty() && count < MAX_ITEMS){
					try{
						items.wait(10);
					} catch (Exception exp){
						
					}
				}
				consume();
			}
		}	
	}
	
	private void consume(){
		if(!items.isEmpty()) {
			System.out.println(Thread.currentThread().getName()+" :"+items.pop());
			count++;
		}
	}
}

public class pc {

	public static void main(String args[]) throws Exception{
		System.out.println("Hello there");
		Stack<Integer> items = new Stack<Integer>();
		int MAX_NO_ITEMS = 10;
		Producer producer = new Producer(items,MAX_NO_ITEMS);
		Consumer consumer = new Consumer(items,MAX_NO_ITEMS);
		Thread p1 = new Thread(producer,"producer-1");
		Thread c1 = new Thread(consumer,"consumer-1");
		Thread c2 = new Thread(consumer,"consumer-2");
		Thread c3 = new Thread(consumer,"consumer-3");
		Thread c4 = new Thread(consumer,"consumer-4");
		Thread c5 = new Thread(consumer,"consumer-5");
		
		
		c1.start();
		c2.start();
		c3.start();
		c4.start();
		c5.start();
		//Thread.sleep(10);
		p1.start();
	}
}
