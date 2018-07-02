/*
	Program on sendRedirect
*/
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import java.io.IOException;

public class TestSendRedirect extends HttpServlet{
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
	}
	protected void doGet(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException{
		res.setContentType("text/html");
		res.sendRedirect("headerinfo"); // without / means location is w.r.t context
		//res.sendRedirect("/headerinfo"); // with / means location is w.r.t URL root i.e http://localhost:8080
		// res.sendRedirect("www.google.com"); // doesn't work
	}
}