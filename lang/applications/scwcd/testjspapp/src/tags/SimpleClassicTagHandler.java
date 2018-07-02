package tags;

import javax.servlet.jsp.tagext.TagSupport;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.JspException;
import java.io.IOException;
import java.util.Date;


public class SimpleClassicTagHandler extends TagSupport
{
	
	public int doStartTag() throws JspException
	{
			JspWriter out = pageContext.getOut();
			pageContext.setAttribute("date",new Date());
			try
			{
				out.println("we are in doStartTag<br/>");				
			}
			catch (IOException ex)
			{
				throw new JspException("IOException -"+ex.toString());
			}
			return EVAL_BODY_INCLUDE; // default is SKIP_BODY other value is EVAL_BODY_BUFFERED
	}

	public int doAfterBody()  throws JspException
	{
			JspWriter out = pageContext.getOut();
			try
			{
				out.println("<br/>we are in doAfterBody<br/>");				
			}
			catch (IOException ex)
			{
				throw new JspException("IOException -"+ex.toString());
			}
			return SKIP_BODY; // default is SKIP_BODY other value is EVAL_BODY_INCLUDE
	}
	public int  doEndTag() throws JspException
	{
			JspWriter out = pageContext.getOut();
			try
			{
				out.println("<br/>we are in doEndTag<br/>");				
			}
			catch (IOException ex)
			{
				throw new JspException("IOException -"+ex.toString());
			}
			return EVAL_PAGE; // this is default other valus is SKIP_PAGE
	}
}