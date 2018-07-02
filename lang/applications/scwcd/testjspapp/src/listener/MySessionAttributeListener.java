package listener;

import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

public class MySessionAttributeListener implements HttpSessionAttributeListener
{
	public void attributeAdded(HttpSessionBindingEvent event){
		System.out.println("session attribute Added: name:"+event.getName()+" value:"+event.getValue());
	}

	public void attributeReplaced(HttpSessionBindingEvent event){
		System.out.println("session attribute Replaced: name:"+event.getName()+" value:"+event.getValue());
	}

	public void attributeRemoved(HttpSessionBindingEvent event){
		System.out.println("session attribute Removed: name:"+event.getName()+" value:"+event.getValue());
	}
}