/*
	Program to show the use of forward ing a web request
*/
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import java.io.IOException;

public class TestForward extends HttpServlet{
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
	}
	protected void doGet(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException{
		res.setContentType("text/html");
		RequestDispatcher rd = req.getRequestDispatcher("/headerinfo");
		rd.forward(req,res);
	}
}