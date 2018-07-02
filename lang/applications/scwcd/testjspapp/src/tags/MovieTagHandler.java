package tags;

import javax.servlet.jsp.tagext.SimpleTagSupport;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspContext;
import javax.servlet.jsp.JspWriter;
import java.io.IOException;
import java.util.List;

public class MovieTagHandler extends SimpleTagSupport
{
	List movies = null;
	
	public void setMovies(List movies){
		this.movies = movies;
	}
	public void doTag() throws JspException,IOException
	{
			JspContext  jspContext = getJspContext();
			JspWriter out  = jspContext.getOut();
			out.println("showing the list of movies");
			for(Object movieName: movies){
				jspContext.setAttribute("movie",movieName);
				getJspBody().invoke(null);
			}
	}
}