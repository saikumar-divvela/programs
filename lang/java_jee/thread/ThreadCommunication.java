class MyThread extends Thread
{
		CommonObject  co;
		public MyThread(CommonObject co){
			this.co = co;
		}
		public MyThread(){
			this.co = new CommonObject();
		}
		public void run()  
		{
			System.out.println("my name is :"+Thread.currentThread().getName());
			co.toughMethod();
		}
}

class CommonObject
{
		CommonObject(){
			System.out.println("i hope u know what u r doing Mr "+Thread.currentThread().getName());
		}
		synchronized  void toughMethod()  {
				String name = Thread.currentThread().getName();
				for(int i=1;i<=16;i++){
						System.out.println(name +" "+i);
						if(i%5==0){
							try
							{
								notify();
								//wait();	
							}
							/*
							catch (InterruptedException exp)
							{
									System.out.println("interrupted exception occurred");
							}
							*/
							finally{
							}
						}
				}
				notify();
		}
}

public class ThreadCommunication 
{
		public static void main(String args[]){
				System.out.println("Thread communication example main thread name:"+Thread.currentThread().getName());
				CommonObject co = new CommonObject();
				(new MyThread(co)).start();
				(new MyThread(co)).start();
				(new MyThread(co)).start();
				/*
				(new MyThread()).start();
				(new MyThread()).start();
				*/
		}
}