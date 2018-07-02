<%@ page import ="java.util.*"%>
<%@ page errorPage="jsp/error/exception.jsp"%>
<%@ taglib prefix ="c"   uri="http://java.sun.com/jsp/jstl/core"%>
<strong>this jsp is for testing expression language </strong>
<br/>
<% int[] nums={42,420,4200} ;
		request.setAttribute("foo",nums);
%>
${5+3 lt 6}
${requestScope["foo"][0] ne 10 div 0}
${10 div 0}

<% java.util.List list = new java.util.ArrayList();
	list.add("a");
	list.add("2");
	list.add("c");
	request.setAttribute("list",list);
	request.setAttribute("listIdx","1");
%>
testing expression language
${list[2]}
<br/>
${list[list[listIdx]]}<br/>
requestURI ${pageContext.request.requestURI}
<br/><strong> jstl tags examples </strong><br/>
<%--
<%
		List<String> names = new ArrayList<String>();
		names.add("sai");
		names.add("deepak");
		names.add("test");
		names.add("raghu");
		names.add("radhika");
		request.setAttribute("namesList",names);
%>
--%>
<c:set var="namesList" scope="request">
	sai,deepak,test,raghu,radhika
</c:set>

<c:forEach var="name" items="${requestScope['namesList']}" varStatus="LoopCount"  begin ="0"  end="4" step="1">
	<c:choose>
		<c:when test="${name eq 'sai'}">
			<c:out value="hi ${name}"/>
		</c:when>
		<c:when test="${name eq 'deepak'}">
			<c:out value="hi ${name}"/>
		</c:when>
		<c:when test="${name eq 'radhika'}">
			<c:out value="hai ${name}"/>
		</c:when>
		<c:when test="${name eq 'raghu'}">
			<c:out value="hey ${name}"/>
		</c:when>
		<c:otherwise>
			<c:out value="hello guest"/>
		</c:otherwise>
	</c:choose>
	your number  is  <c:out value="${LoopCount.count} "/> 
	<c:if test="${LoopCount.count mod 2 eq 1}" var="status" scope="page">
		<c:out value="odd"/>
	</c:if> |||status: <c:out value="${pageScope.status}"/><br/>
</c:forEach>
<c:remove var="namesList"  scope="request"/>
<br/><c:out value="<c:import> example"/>
<c:import url="greeting.jsp">
	<c:param name="name" value="sai"/>
</c:import>
<br/><br/><c:out value="<c:url> example"/><br/>
<c:url value="greeting.jsp" var ="url">
	<c:param name="name" value="another dummy" />
</c:url>
<br>generated url ${url} <br/>
<a href="${url}" > greeting link</a>
<br/><c:out value="testing of <c:catch>" /> <br/>
<c:catch var="excep">
	<c:set target="dummy" />
</c:catch>
<c:if test ="${excep!=null}">
<br/> Exception occurred	:${excep.message}	
</c:if>