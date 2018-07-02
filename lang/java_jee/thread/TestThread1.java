public class TestThread1 implements Runnable {
	static int counter =1;
	public void run(){
		for(int i=0;i<=10;i++) {
			System.out.println(Thread.currentThread().getName()+":"+i);
			try {
				Thread.sleep(100);
			} catch(InterruptedException ioe){

			}
		}
	}
	public static void main(String args[]){
		TestThread1 thr1 = new TestThread1();
		TestThread1 thr2 = new TestThread1();
		new Thread(thr1).start();
		new Thread(thr2).start();
	}

}