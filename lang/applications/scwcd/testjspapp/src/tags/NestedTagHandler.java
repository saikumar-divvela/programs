package tags;

import javax.servlet.jsp.tagext.SimpleTagSupport;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspContext;
import javax.servlet.jsp.JspWriter;
import java.io.IOException;
import javax.servlet.jsp.tagext.JspTag;
import javax.servlet.jsp.tagext.SimpleTag;

public class NestedTagHandler extends SimpleTagSupport
{
	
	public void doTag() throws JspException,IOException
	{
			int level =0;
			JspContext  jspContext = getJspContext();
			JspWriter out = jspContext.getOut();
			JspTag   parent = getParent();		
			while(parent!=null){
				parent = ((SimpleTag)parent).getParent();
				level++;
			}
			out.println("<br/>nested level:"+level);
			if(getJspBody()!=null) getJspBody().invoke(null);
	}
}

