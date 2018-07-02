package tags;

import javax.servlet.jsp.tagext.SimpleTagSupport;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspContext;
import javax.servlet.jsp.JspWriter;
import java.io.IOException;

public class SimpleOuterTagHandler extends SimpleTagSupport
{
	private String name;

	public void setName(String name){
		this.name = name;
	}
	public String  getName(){
		return this.name;
	}
	public void doTag() throws JspException,IOException
	{
			JspContext  jspContext = getJspContext();
			JspWriter out  = jspContext.getOut();
			out.println("<br/>this is a outer tag<br/>");
			getJspBody().invoke(null);
	}
}