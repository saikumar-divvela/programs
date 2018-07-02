import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletConfig;
import java.util.ResourceBundle;
import java.io.PrintWriter;
import java.io.IOException;
import javax.servlet.http.Cookie;

public class FirstCookie extends HttpServlet {

	ResourceBundle rb = ResourceBundle.getBundle("/properties/MySettings");
	public void init(ServletConfig config) throws ServletException
	{
		super.init(config);
	}
	protected void doGet(HttpServletRequest req,HttpServletResponse res)
	throws IOException
	{
		PrintWriter out = res.getWriter();
		res.setContentType("text/html");

		out.println("<html>");
		out.println("<head>");
		out.println("<title>");
		out.println("Cookie example");
		out.println("</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<b>Cookie example</b>");
		Cookie[] cookies = (Cookie[]) req.getCookies();
		if(cookies!=null && cookies.length > 0) {
			out.println("<br>");
          	out.println(rb.getString("cookie.cookie"));
			for(int i=0;i<cookies.length;i++){
				out.println("<br> Cookie Name:"+cookies[i].getName());
				out.println("<br> Cookie Value:"+cookies[i].getValue());
			}
		}else {
			out.println("<br>"+rb.getString("cookie.no-cookie"));
		}
		String name = req.getParameter("NAME");
		String value = req.getParameter("VALUE");
		if ((name != null && !"".equals(name)) || (value!=null && !"".equals(value))) {
			Cookie cookie = new Cookie(name,value);
			res.addCookie(cookie);
			out.println("<br>");
			out.println(rb.getString("cookie.set-cookie"));
			out.println("<br>");
			out.println("Cookie Name:"+name);
			out.println("<br>");
			out.println("Cookie value:"+value);
		} else {
			out.println("<br>Enter some cookie values to send to your browser");
		}
		out.println("<form action=\"firstcookie\" method=\"post\">");
		out.println("<br>Name :");
		out.println("<input type=text name=NAME>");
		out.println("<br>Value :");
		out.println("<input type=text name=VALUE>");
		out.println("<br>  ");
		out.println("<input type=submit value=submit>");
		out.println("</form>");
		out.println("</body>");
		out.println("</html>");
	}
	protected void doPost(HttpServletRequest req,HttpServletResponse res)
	throws IOException {
		doGet(req,res);

	}
	public void destroy() {
		System.out.println("Cookie Example is destroyed");
	}
}
