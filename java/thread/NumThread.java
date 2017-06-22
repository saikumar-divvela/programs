public class NumThread implements Runnable{
	int num;
	volatile static int flag=1;
	private static final Object syncObject = new Object();
	
	public NumThread(int number){
		this.num = number;
	}
	
	public void run(){
		while(true){
			synchronized(syncObject){
				while(flag != num){
					try {
						syncObject.wait();
					} catch(Exception exp){
						System.out.print(exp.getMessage()+ " ");
					}
				} 
				System.out.print(num+" ");
				updateFlag();
				syncObject.notifyAll();
			}	
		}
	}
	
	
	/*
	 *     1 prints and goes wait mode  2 also goes wait mode release lock-> 1 is printed and goes to wait mode
	 * 
	 */
	public static void updateFlag(){
		if (flag==1){
			flag =2;
		} else if(flag ==2){
			flag =3;
		} else if(flag==3){
			flag =1;
		}
	}
	public static void main(String args[]){
		System.out.println("hello world 1234");
		Thread t1 =new Thread(new NumThread(1));
		Thread t2 =new Thread(new NumThread(2));
		Thread t3 =new Thread(new NumThread(3));
		t1.start();
		t2.start();
		t3.start();
	}
}
