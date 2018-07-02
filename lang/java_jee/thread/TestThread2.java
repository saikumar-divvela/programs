
public class TestThread2 extends Thread{
	TestThread2(){
		super.start();
	}
	public void run(){
		for(int i=0;i<10;i++){
			System.out.println(Thread.currentThread().toString()+":"+i);
			try {
				Thread.sleep(100);
			} catch(Exception e){
			}
		}
	}
	public static void main(String args[]) {
		TestThread2 thr1 = new TestThread2();
		TestThread2 thr2 = new TestThread2();
		thr1.start();
		//thr2.start();
	}
}