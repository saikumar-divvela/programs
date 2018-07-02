
public class FirstThread extends Thread
{
		public void run(){
				for(int i=1;i<1000;i++)
				System.out.println("i am running "+i);
		}
		public static void main(String args[]) throws InterruptedException {
			FirstThread bt = new FirstThread();
			System.out.println("First thread");		
			bt.start();
			Thread.currentThread().sleep(10);
			if(bt.isAlive()){
				System.out.println("thread is alive...........................");
			} else {
				System.out.println("thread is done.........................");
			}
			// waits for 2 seconds to complete the thread bt and resume
			try {
					bt.join(1000);
			 } catch (InterruptedException e) {
					System.out.println("thread is interrupted..............................");	
			 }
			System.out.println("waiting time is over so resuming the main thread.........................................");
			 FirstThread st = new FirstThread();
			st.start();
			try {
					st.join();
			 } catch (InterruptedException e) {
					System.out.println("thread is interrupted..............................");	
			 }

			 System.out.println("2nd thread is finished.........................................");
		}
}