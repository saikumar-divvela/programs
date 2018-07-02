/*
	Program to display request header information
*/
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import java.util.Enumeration;
import java.io.PrintWriter;
import java.io.IOException;

public class HeaderInfo extends HttpServlet{
	int count=0;
	public void init(ServletConfig config)throws ServletException {
		super.init(config);
		System.out.println("Inside init block");
		String  param = config.getInitParameter("greetings");
		System.out.println("Config init parameter:"+param);
		ServletContext ctxt = config.getServletContext();
		Enumeration params = ctxt.getInitParameterNames();
		System.out.println("Context parameter:");
		while(params.hasMoreElements()){
			param = (String)params.nextElement();
			System.out.println(param+":"+ctxt.getInitParameter(param));
		}
	}
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException,
	IOException {
			PrintWriter out = res.getWriter();
			res.setContentType("text/html");
			//res.setStatus(res.SC_MOVED_TEMPORARILY);
			res.setHeader("Refresh","5"); // refreshes the page
			count++;
			out.println("<html>");
			out.println("<head>");
			out.println("<title>Hello World</title></head>");
			out.println("</head>");
			out.println("<body>");
			out.println("<h3>Request Information</h3>");
			out.println("<br/>Method :"+req.getMethod());
			out.println("<br/>Authentication type :"+req.getAuthType());
			out.println("<br/>Context path :"+req.getContextPath());
			out.println("<br/>Path info :"+req.getPathInfo());
			out.println("<br/>Request URL :"+req.getRequestURI());
			out.println("<br/>Servlet path :"+req.getServletPath());
			out.println("<br/>Remote host :"+req.getRemoteHost());
			out.println("<br/>Protocol :"+req.getProtocol());
		 	out.println("<h3>Header Information</h3>");
			Enumeration e = req.getHeaderNames();
			while ( e.hasMoreElements()) {
				String name = (String)e.nextElement();
				String value = req.getHeader(name);
				out.println("<br/>"+name+"="+value);

			}
			out.println("<br/><br/>This page is refreshed "+count+"  times ");
			out.println("</body>");
			out.println("</html>");

	}
	public void destroy(){
		System.out.println("Servlet is destroyed");
	}
}