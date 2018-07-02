package listener;

import javax.servlet.http.HttpSessionListener;
import javax.servlet.http.HttpSessionEvent;

public class MySessionListener implements HttpSessionListener
{
	public void sessionCreated(HttpSessionEvent event){
		System.out.println("Session created:"+event.getSession());
	}

	public void sessionDestroyed(HttpSessionEvent event){
		System.out.println("Session destroyed:"+event.getSession());
	}
}