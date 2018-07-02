import javax.servlet.http.*;
import javax.servlet.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;
import foo.Person;

public class TestListener extends HttpServlet
{
	public void init(){
		System.out.println("inside init of TestListener");
	}
	public void doGet(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException
	{
		PrintWriter out =  res.getWriter();
		out.println(" welcome to testListener");
		ServletConfig config  =  getServletConfig();
		ServletContext context  =  getServletContext();
		Enumeration params =  config.getInitParameterNames();
		out.println("servlet-init parameters");
		while(params.hasMoreElements()){
			String paramName = (String)params.nextElement();
			out.println(paramName+":"+config.getInitParameter(paramName));
		}
		params =  context.getInitParameterNames();
		out.println("");
		out.println("app context init parameters");
		while(params.hasMoreElements()){
			String paramName = (String)params.nextElement();
			out.println(paramName+":"+context.getInitParameter(paramName));
		}
		Person person = null; 
		if(context.getAttribute("person")!=null){
			out.println("person data:");
			person = (Person)context.getAttribute("person");
			out.println("name:"+person.getName());
			person = new Person();
			person.setName("KUMAR");
			person.setEmail("saikumar.divvela@yahoo.com");
			context.setAttribute("person",person);
			context.removeAttribute("person");
		}
		out.println("total no of requests so far");
		out.println(req.getAttribute("reqcount"));
		out.flush();
	}
	public void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException
	{
			doGet(req,res);
	}
}