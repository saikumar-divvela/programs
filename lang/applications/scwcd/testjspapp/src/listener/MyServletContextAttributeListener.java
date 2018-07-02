package listener;

import javax.servlet.ServletContextAttributeListener;
import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContext;
import foo.Person;

public  class MyServletContextAttributeListener implements  ServletContextAttributeListener
{

	public void attributeAdded(ServletContextAttributeEvent event){
		System.out.println("context attribute Added: name:"+event.getName()+" value:"+event.getValue());
	}

	public void attributeReplaced(ServletContextAttributeEvent event){
		System.out.println("context attribute Replaced: name:"+event.getName()+" value:"+event.getValue());
	}

	public void attributeRemoved(ServletContextAttributeEvent event){
		System.out.println("context attribute Removed: name:"+event.getName()+" value:"+event.getValue());
	}

}