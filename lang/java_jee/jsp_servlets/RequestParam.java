import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletConfig;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.ResourceBundle;


public class RequestParam extends HttpServlet {


	public void init(ServletConfig config) throws ServletException
	{
		super.init(config);
		System.out.println(" RequestParam is initialized");
	}
	public void doGet(HttpServletRequest req,HttpServletResponse res)
		throws ServletException,IOException {

		ResourceBundle rb = ResourceBundle.getBundle("/properties/MySettings");
		String name = req.getParameter("NAME");
		String value = req.getParameter("VALUE");

		PrintWriter out = res.getWriter();
		res.setContentType("text/html");
		out.println("<html>");
		out.println("<head>");
		out.println("<title>");
		out.println("Request Param");
		out.println("</title>");
		out.println("<body>");
		if(rb!=null)
			out.println(rb.getString("welcomemessage"));
		if( (name!=null && !"".equals(name)) || (value !=null && !"".equals(value)) ) {
			out.println("<br> Name :"+name);
			out.println("<br> Value :"+value);
		}else {
			out.println("<br/> Enter some parameters ");
		}
		out.println("<form action=\"requestparam\"");
		out.println("<br/>Name :");
		out.println("<input type=text name=NAME>");
		out.println("<br/>Value :");
		out.println("<input type=text name=VALUE>");
		out.println("<br/><input type=submit value=enter>");
		out.println("</form>");
		out.println("</body>");
 		out.println("</html>");
	}
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException,IOException {
		doGet(req,res);
	}
}
