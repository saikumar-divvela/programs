
package tags;

import javax.servlet.jsp.tagext.SimpleTagSupport;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspContext;
import javax.servlet.jsp.JspWriter;
import java.io.IOException;
import tags.SimpleOuterTagHandler;

public class SimpleInnerTagHandler extends SimpleTagSupport
{
	
	public void doTag() throws JspException,IOException
	{
			JspContext  jspContext = getJspContext();
			JspWriter out = jspContext.getOut();
			
			SimpleOuterTagHandler  outertag=  (SimpleOuterTagHandler)getParent();
			if(outertag!=null)
			{
				out.println("<br/>outertag name "+outertag.getName()+"<br/>");
			}
			out.println("<br/>this is a inner tag<br/>");
			getJspBody().invoke(null);
	}
}