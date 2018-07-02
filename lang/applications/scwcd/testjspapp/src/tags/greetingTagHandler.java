package tags;

import javax.servlet.jsp.tagext.SimpleTagSupport;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.JspContext;
import javax.servlet.jsp.JspException;
import java.io.IOException;
import java.util.Date;

public class greetingTagHandler extends SimpleTagSupport
{
	private String userName;

	public void doTag() throws JspException,IOException {
		JspContext  jspContext = getJspContext();
		JspWriter out = jspContext.getOut();
		if(userName!=null)
		{
			out.write("hello "+userName+"<br/>");
		} else {
			out.write("hello Guest <br/>");
		}
		jspContext.setAttribute("date",new Date());
		getJspBody().invoke(null);
	}


	public void setUserName(String userName)
	{
		this.userName = userName;
	}

}