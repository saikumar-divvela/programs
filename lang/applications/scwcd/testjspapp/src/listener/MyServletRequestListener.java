package listener;

import javax.servlet.ServletRequestListener;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import foo.Person;

public  class MyServletRequestListener  implements  ServletRequestListener
{
	int reqCounter =0;
	public void requestInitialized(ServletRequestEvent event){
		reqCounter++;
		System.out.println("Request Initiazlied:"+reqCounter);
		
		ServletRequest req = event.getServletRequest();
		req.setAttribute("reqcount",reqCounter);
		
		((HttpServletRequest)req).getSession().setAttribute("numberofRequests",reqCounter);
	}
	public void requestDestroyed(ServletRequestEvent event){
				HttpSession session = ((HttpServletRequest)(event.getServletRequest())).getSession();
				Person person = new Person();
				person.setName("Sai");
				if(session!=null) {
				session.setAttribute("myDetails",person);
				} else {
					System.out.println("session null can't put object");
				}
				System.out.println("Request destroyed");
	}

}