package tags;

import javax.servlet.jsp.tagext.TagSupport;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.JspException;
import java.io.IOException;
import java.util.List;

public class ClassicMovieTagHandler  extends TagSupport
{
	int counter=0;
	List movies;
	public void setMovies(List movies)
	{
			this.movies = movies;
	}
	public int doStartTag() throws JspException
	{
			counter = 0;
			
			if(movies!=null) {
				pageContext.setAttribute("movie",movies.get(counter++));
				//return EVAL_BODY_INCLUDE; 
			}
			System.out.println("returning SKIP_BODY");
			return SKIP_BODY;
			//return 111;
	}
	/*
	public int doAfterBody()  throws JspException
	{
			System.out.println("Do AfterBody count:"+counter);
			
			while(counter < movies.size()){
				pageContext.setAttribute("movie",movies.get(counter++));
				return EVAL_BODY_AGAIN;
			}
			return SKIP_BODY;
	} */
}