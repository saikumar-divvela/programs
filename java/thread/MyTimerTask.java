import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class MyTimerTask extends TimerTask{

	@Override
	public void run() {
		System.out.println("Timertask started at "+new Date());
		complete();
		System.out.println("Timertask ended at "+new Date());
	}

	private void complete(){
		try {
			Thread.sleep(4000);
		} catch(InterruptedException e){
			e.printStackTrace();
		}
	}
	
	public static void main(String args[]){
		TimerTask task = new MyTimerTask();
		Timer timer = new Timer(false);
		timer.scheduleAtFixedRate(task,0,2*1000);
		System.out.println("Timer task started");
		try{
			Thread.sleep(20000);
		} catch(InterruptedException e){
			e.printStackTrace();
		}
		timer.cancel();
		System.out.println("Timer task cancelled");
		
	}
	
}
