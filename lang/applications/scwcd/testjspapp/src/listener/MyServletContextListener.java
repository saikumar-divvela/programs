package listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.ServletContext;
import foo.Person;

public  class MyServletContextListener implements  ServletContextListener
{

	public void contextInitialized(ServletContextEvent event){
		System.out.println("context initialized");
		ServletContext context = event.getServletContext();
		String name = context.getInitParameter("name");
		Person person = new Person();
		person.setName(name);
		context.setAttribute("person",person);
	}

	public void contextDestroyed(ServletContextEvent  event){
		System.out.println("context destroyed");	
	}

}