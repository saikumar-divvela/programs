package filter;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class statisticsFilter implements  Filter
{	
	FilterConfig fg;
	int counter =0;
	public void init(FilterConfig filterConfig){
		//System.out.println("statisticsFilter initializing.......");
		fg = filterConfig;
		//System.out.println("filter name:"+fg.getFilterName() );
		//System.out.println("filter initialization parameters");
		//System.out.println("value:"+fg.getInitParameter("name"));
	}

	public void doFilter(ServletRequest req,ServletResponse res,FilterChain chain) throws IOException,ServletException 
	{
		counter++;
		System.out.println("statisticsFilter in action.......");
		chain.doFilter(req,res);
		//System.out.println("Total requests processed......."+counter);
	}
	
	
	public void destroy(){
		//System.out.println("statisticsFilter going to die.......");
	} 
}