package tags;

import javax.servlet.jsp.tagext.SimpleTagSupport;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspContext;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.DynamicAttributes;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class SelectTagHandler extends SimpleTagSupport implements DynamicAttributes
{
	public String name;
	public String size;
	public List options;
	static String ATTR_TEMPLATE="%s='%s'";
	static String OPTION_TEMPLATE="<option value='%1$s'>%1$s</option>";
	public Map<String,Object> tagattrs = new HashMap<String,Object>();

	public void setName(String name)
	{
		this.name = name;
	}
	
	public void setSize(String size)
	{
		this.size = size;
	}
	
	public void setOptions(List options)
	{
		this.options = options;
	}
	public void setDynamicAttribute( String uri, String localName, Object value)  throws JspException
	{
			tagattrs.put(localName,value);
	}
	public void doTag() throws JspException,IOException
	{
			JspContext  jspContext = getJspContext();
			JspWriter out = jspContext.getOut();
			out.print("<select ");
			out.print(String.format(ATTR_TEMPLATE,"name",this.name));
			out.print(String.format(ATTR_TEMPLATE,"size",this.size));
			for(String attrName: tagattrs.keySet()){
				out.print(String.format(ATTR_TEMPLATE,attrName,tagattrs.get(attrName)));
			}
			out.print(">");
			for(Object option:options){
				out.print(String.format(OPTION_TEMPLATE,option.toString()));
			}
			out.print("</select>");
	}
}