import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

public class ValidationServlet extends HttpServlet{

	public void init(){
	
	}
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
	{
		System.out.println("Request reached Servlet");
		String userName = request.getParameter("UserName");
		response.setContentType("text/html");
		response.setHeader("Cache-Control","no-cache");
		if("saikumar".indexOf(userName) == 0){
			if(userName.equals("saikumar")){
				response.getWriter().write("valid");
			} else {
				response.getWriter().write("continue");
			}
		} else {
			response.getWriter().write("invalid");
		}	
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
	{
		String category = request.getParameter("category");
		System.out.println("category :"+category);
		PrintWriter out = response.getWriter();
		response.setContentType("text/xml"); // content type is xml
		response.setHeader("Cache-Control","no-cache");
		out.print(getXMLResponseMessage(category));
	}
	
	private String getXMLResponseMessage(String category)
	{
		StringBuffer books = new StringBuffer();
		books.append("<?xml version=\"1.0\" ?>"+
					"<book_response>"+
					"<suggestion>J2EE</suggestion>"+
					"<books>"+
					"<book>Jboss  Server </book>"+
					"<book>Ultimate Guide J2EE Web Services</book>"+
					"</books>"+
					"</book_response>");
		return books.toString();
	}
}