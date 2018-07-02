
public class MyThread implements Runnable
{
		public void run(){
			System.out.println("i am a thread running. my name is:"+Thread.currentThread().getName());
		}
		public static void main(String args[]){
				//MyThread mt = new MyThread();
				for(int i=0;i<10;i++)
				new Thread(new MyThread(),i+"").start();
		}
}