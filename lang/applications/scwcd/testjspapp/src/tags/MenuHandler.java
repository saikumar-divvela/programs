package tags;

import javax.servlet.jsp.tagext.SimpleTagSupport;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspContext;
import javax.servlet.jsp.JspWriter;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;

public class MenuHandler extends SimpleTagSupport
{
	List<String> menuItems = new ArrayList<String>();
	public void addMenuItem(String name)
	{
		menuItems.add(name);
	}

	public void doTag() throws JspException,IOException
	{
			JspContext  jspContext = getJspContext();
			JspWriter out = jspContext.getOut();
			 getJspBody().invoke(null);
			 out.println("<br/>the menu items are :"+menuItems);
	}

}

