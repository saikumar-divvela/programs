import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/*
 	Actual subject/object maintains a list of dependencies(observers). Each observer registers with Subject. Object calls a method on 
 	each observer whenever there is state change.
 	we can also use java.lang.Observable and java.lang.Observer
	where needed
	examples:
		Used in MVC architecture
		Used almost in every GUI tookit
 */
public class ObserverPattern1 {
	public static void main(String args[]){
		EventSource source = new EventSource();
		source.addObserver(new ResponseHandler1());
		source.addObserver(new ResponseHandler2());
		System.out.print("Enter Text>");
		Thread thread= new Thread(source);
		thread.start();
	}
}

class EventSource extends Observable implements Runnable{
	
	
	public void run(){
		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
		String resp;
		try {
			while(true){
				resp = bfr.readLine();
				setChanged();
				notifyObservers(resp);
			}
		}catch(Exception exp){
			exp.printStackTrace();
		}
		
	}
}

class ResponseHandler1 extends Observer{
	private String resp;
	public void update(Object obj){
		if(obj instanceof String ){
			resp = (String) obj;
		}
		System.out.println("ResponseHandler1: "+ resp);
	}
}

class ResponseHandler2 extends Observer{
	private String resp;
	public void update(Object obj){
		if(obj instanceof String ){
			resp = (String) obj;
		}
		System.out.println("ResponseHandler2: "+ resp);
	}
}

abstract class Observable{
	List<Observer> observers = new ArrayList<Observer>();
	private boolean isStateUpdated;
	
	protected void notifyObservers(Object obj){
		if(hasChanged()){
			for(Observer obs: observers){
				obs.update(obj);
			}
		}
		clearChanged();
	}
	
	protected void notifyObservers(){
		this.notifyObservers(null);
	}
	
	protected void addObserver(Observer o){
		observers.add(o);
	}
	
	public void setChanged(){
		isStateUpdated = true;
	}
	
	private void clearChanged(){
		isStateUpdated = false;
	}
	
	public boolean hasChanged(){
		return isStateUpdated;
	}
	
}

abstract class Observer {
	abstract void update(Object obj);
}
