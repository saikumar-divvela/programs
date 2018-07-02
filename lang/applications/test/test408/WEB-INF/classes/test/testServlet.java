package test;

import javax.servlet.http.*;
import javax.servlet.*;

public class testServlet extends HttpServlet
{
	public void init(ServletConfig config) throws ServletException{
		super.init(config);
	}

	public void doGet(HttpServletRequest req,HttpServletResponse res){
		try
		{
			ServletContext sc = this.getServletContext();
			RequestDispatcher rd = sc.getRequestDispatcher("/WEB-INF/jsp/test.jsp");
			rd.forward(req,res);
		}
		catch (Exception exp)
		{
			System.out.println("Message:"+exp.getMessage());
			exp.printStackTrace();
		}
	}
}