import javax.servlet.http.*;
import javax.servlet.*;
import java.io.IOException;

public class ServletInfo extends HttpServlet
{
		public void doGet(HttpServletRequest req,HttpServletResponse res)throws IOException,ServletException
		{
			System.out.println("GET REQUEST");
			RequestDispatcher reqDis = req.getRequestDispatcher("/WEB-INF/jsp/servletInfo.jsp");
			reqDis.forward(req,res);
		}
		public void doPost(HttpServletRequest req,HttpServletResponse res) throws IOException,ServletException
		{
			System.out.println("POST  REQUEST");
			RequestDispatcher reqDis = req.getRequestDispatcher("/WEB-INF/jsp/servletInfo.jsp");
			reqDis.forward(req,res);
		}
}