package listener;

import javax.servlet.ServletRequestAttributeListener;
import javax.servlet.ServletRequestAttributeEvent;
import foo.Person;

public  class MyServletRequestAttributeListener  implements  ServletRequestAttributeListener
{
	public void attributeAdded(ServletRequestAttributeEvent event)
	{
		System.out.println("request attribute added  name:"+event.getName()+" value:"+event.getValue());
	}
	public void attributeReplaced(ServletRequestAttributeEvent event)
	{
		System.out.println("request attribute replaced in request: name:"+event.getName()+" value:"+event.getValue());
	}
	public void attributeRemoved(ServletRequestAttributeEvent event)
	{
		System.out.println("request attribute removed  in request: name:"+event.getName()+" value:"+event.getValue());
	}
}

