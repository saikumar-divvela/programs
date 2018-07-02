package tags;

import javax.servlet.jsp.tagext.SimpleTagSupport;
import javax.servlet.jsp.JspException;
import java.io.IOException;
import tags.MenuHandler;


public class MenuItemHandler extends SimpleTagSupport
{
	String name;

	public void setName(String name){
		this.name = name;
	}
	public void doTag() throws JspException,IOException
	{
			MenuHandler parent = (MenuHandler)getParent();
			parent.addMenuItem(name);
	}
}