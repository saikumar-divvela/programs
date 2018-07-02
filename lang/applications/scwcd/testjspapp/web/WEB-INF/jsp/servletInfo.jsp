<%@ page import="java.util.*" %>
<html>
	<head> 
		<title> Servlet Info page</title>
	</head>
	<body>
		<h4 align="center"> Welcome to Servlet Info page </h1>
		Name:<%=request.getParameter("param1")%><br/>
		Password:<%=request.getParameter("password")%><br/>
		<br/><br/>HTTP Servlet Request functions <br/><br/>
		Auth type :<%= request.getAuthType()%><br/>
		Context path: <%=request.getContextPath()%><br/>
		Method:<%=request.getMethod()%><br/>
		PathInfo:<%=request.getPathInfo()%><br/>
		Path translated:<%=request.getPathTranslated()%><br/>
		QueryString:<%=request.getQueryString()%><br/>
		RemoteUser:<%=request.getRemoteUser()%><br/>
		Request URI:<%=request.getRequestURI()%><br/>
		Request URL:<%=request.getRequestURL()%><br/>
		ServletPath:<%=request.getServletPath()%><br/>
		Session Id:<%=request.getRequestedSessionId()%><br/>
		Is Session from cookie:<%=request.isRequestedSessionIdFromCookie() %><br/>
		is session from request url:<%=request.isRequestedSessionIdFromURL() %><br/>
		is session valid:<%=request.isRequestedSessionIdValid() %><br/>
		is user from role:<%=request.isUserInRole("dummy")%></br> <br/><br/>
		Header Info <br/><br/>
		(Header Name: Value)<br/>
		<% 
				Enumeration headers = request.getHeaderNames() ;
				while(headers.hasMoreElements()){
					String name=(String) headers.nextElement();
					out.println(name+":"+request.getHeader(name)+"<br/>");			
				}
		%>
		<br/><br/>
		Cookies Info <br/>
		Cookie Name: Value <br/> <br/>
		<%
				Cookie[] cookies = request.getCookies();
				for(int i=0;i<cookies.length;i++){
						out.println(cookies[i].getName()+":"+cookies[i].getValue()+"<br/>");
				}
		%>
		<br/><br/>Servlet Request Functions <br/><br/>
		Character Encoding: <%= request.getCharacterEncoding()%><br/>
		content length:<%=request.getContentLength()%><br/>
		content type:<%=request.getContentType()%><br/>
		Local address:<%=request.getLocalAddr()%><br/>
		Local name:<%=request.getLocalName()%><br/>
		Local port:<%=request.getLocalPort()%><br/>
		protocol:<%=request.getProtocol()%><br/>	
		Remote  address:<%=request.getRemoteAddr()%><br/>
		Remote  name:<%=request.getRemoteHost()%><br/>
		Remote port:<%=request.getRemotePort()%><br/>
		Scheme:<%=request.getScheme()%><br/>
		Server name:<%=request.getServerName()%><br/>
		Server Port:<%=request.getServerPort()%><br/>
		Is Secure:<%=request.isSecure()%><br/>
		<br/><br/>Request parameters <br/>
		(name:value)<br/><br/>
		<% 
				Enumeration parameters = request.getParameterNames() ;
				while(parameters.hasMoreElements()){
					String name=(String) parameters.nextElement();
					out.println(name+":"+request.getParameter(name)+"<br/>");			
				}
		%>
	</body>
</html>
