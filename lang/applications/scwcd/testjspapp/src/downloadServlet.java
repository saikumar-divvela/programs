import javax.servlet.http.*;
import javax.servlet.*;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.IOException;

public class downloadServlet extends HttpServlet
{
		public void doGet(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException
		{
			ServletOutputStream out = res.getOutputStream();
			ServletContext context = getServletContext();
			InputStream  is =  context.getResourceAsStream("test.jar");
			byte[] b = new byte[1024];
			while((is.read(b))!=-1) {
				out.write(b);									
			}
		}
		public void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException
		{
			doGet(req,res);
		}
}