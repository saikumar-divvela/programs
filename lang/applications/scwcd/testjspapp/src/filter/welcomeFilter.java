package filter;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class welcomeFilter implements  Filter
{	
	FilterConfig fg;
	public void init(FilterConfig filterConfig){
		//System.out.println("welcomeFilter initializing.......");
		fg = filterConfig;
		//System.out.println("filter name:"+fg.getFilterName() );
		//System.out.println("filter initialization parameters");
		//System.out.println("value:"+fg.getInitParameter("greeting"));
	}

	public void doFilter(ServletRequest req,ServletResponse res,FilterChain chain) throws IOException,ServletException 
	{
		System.out.println("welcomeFilter  in action.......");
		chain.doFilter(req,res);
		//System.out.println("welcomeFilter after chaining ......");
	}
	
	public void destroy(){
		//System.out.println("welcomeFilter going to die.......");
	}
	
}