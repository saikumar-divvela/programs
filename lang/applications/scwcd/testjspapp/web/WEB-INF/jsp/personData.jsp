<%@ page import="foo.Person" %>
<html>
<body>
<strong> this jsp displays user data which are entered in another input jsp. This jsp uses beans</strong>
<br/>
<jsp:useBean id="person" class="foo.Person" scope="request">
	<jsp:setProperty name="person" property="name" value="<%=request.getParameter("name")%>"/>
	<jsp:setProperty name="person" property="email" value="${param['email']}"/>
</jsp:useBean>
<br/> using bean <br/>
Person name  is  <jsp:getProperty  name="person"  property="name" /><br/>
email id   is  <jsp:getProperty  name="person"  property="email" /><br/>
<br/>again using param <br/>
name : ${param.name} and email id : ${param.email} <br/>
<br/>and again using requestScope<br/>
name : ${requestScope.name} and email id : ${requestScope.email} <br/>
checkbox details.
processor type:${param.processor}
</body>
</html>