import java.util.Random;

public class ThreadLocalExample implements Runnable{

	private static ThreadLocal<Integer> value = new ThreadLocal<Integer>() {
		@Override
		protected Integer initialValue(){
			return new Integer(100);
		}
	};
	public static void main(String args[]) throws InterruptedException{
		ThreadLocalExample object = new ThreadLocalExample();
		for(int i=0;i<5;i++){
			Thread t1 = new Thread(object,""+i);
			Thread.sleep(new Random().nextInt(1000));
			t1.start();
		}
	}
	
	public void run(){
		System.out.println("Thread... :"+Thread.currentThread().getName()+" Default value "+ value.get());
		try {
			Thread.sleep(new Random().nextInt(1000));
		} catch(InterruptedException e){
			e.printStackTrace();
		}
		value.set(new Random().nextInt(1000));
		System.out.println("Thread... :"+Thread.currentThread().getName()+" final value "+ value.get());
	}
}
