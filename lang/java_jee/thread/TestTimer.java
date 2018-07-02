 import java.util.*;  
 public class TestTimer {  
     java.util.Timer myTimer;  
       
     public void setTimer(int seconds) {  
         myTimer = new java.util.Timer();  
         myTimer.schedule(new myTask(),0,seconds*1000);  
     }  
       
     class myTask extends TimerTask {  
         public void run() {  
			myClass  m = new myClass();
			m.print();
		 }        
     }  
       
	 class myClass
	 {
		public void print(){
			System.out.println("Timer Example");
		}
	 }
     public static void main(String args[]) {  
         TestTimer r = new TestTimer();  
         r.setTimer(2);  
     }  
 }  