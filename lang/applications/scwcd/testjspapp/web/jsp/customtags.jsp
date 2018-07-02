<%@ page import  ="java.util.List,java.util.Arrays" %>
<%@  taglib prefix="tagfile" tagdir="/WEB-INF/tags/" %>
<%@  taglib prefix="mytags" uri="mytags-tld" %>
<strong> this page uses  jsp:include , jsp:param, tag files, simple tags, classic tags </strong>
<br/> following  welcome message is printed using jsp:include and jsp:param<br/>
<%  
	List optionsList =  Arrays.asList(new String[]{"Sign","English","Hindi","Telugu"});
	request.setAttribute("optionsList",optionsList);
%>

<jsp:include page="greeting.jsp">
	<jsp:param  name="name" value="guest" />
</jsp:include>
<br/><strong> example of EL function </strong><br/>
random number ${mytags:rollit()}
<br/><br/> <strong> Beginning of Tag File examples</strong>
<br/> greeting message is printed using tag file<br/>
<tagfile:greeting username="deepak" colour="blue">
with in body
</tagfile:greeting>
<br/> dynamic attributes example  <br/>
<tagfile:showselectlist name="language" size="2"  multiple="true" options="${optionsList}">
</tagfile:showselectlist>
<br/> <strong> End of Tag File examples</strong>
<br/><br/> <strong> Beginning of Simple Tag examples</strong>
<br/>simple tag  handler output<br/>
<mytags:outertag name="outertag1"> 
	<mytags:innertag> </mytags:innertag>
</mytags:outertag> 

<br/>following  greeting message is printed using simple tag  handler<br/>
<mytags:greeting userName="sai">
today date :${date} 
</mytags:greeting>

<br/>iterates inputlist and prints movie information<br/>
<% List movies = Arrays.asList(new String[]{"matrix", "the one","a man without brain"});
		request.setAttribute("movieList",movies);
%>
<table>
<mytags:showmovielist movies="${movieList}">
<tr><td>	movie name : ${movie}</td></tr>
</mytags:showmovielist>
</table>
<br/> Nested tag example <br/>
<mytags:nestedtag>
	<mytags:nestedtag>
				<mytags:nestedtag></mytags:nestedtag>
	</mytags:nestedtag>
</mytags:nestedtag>
<br/> Nested menu items  example <br/>
<mytags:menu>
	<mytags:menuitem name="food"/>
	<mytags:menuitem name="movies"/>
	<mytags:menuitem name="music"/>
</mytags:menu>
<br/> dynamic attributes example  <br/>
<mytags:selectlist name="language" size="2" multiple="true" options="${optionsList}"/>

<br/> <strong> End of Simple Tag examples</strong>

<br/><br/><Strong> Classic tag examples</Strong>
<br/> The following is printed using simple classic tag handler<br/>
<mytags:classictag1>today date: ${date}</mytags:classictag1>
<br/> iterates inputlist and prints movie information<br/>
<table>
<mytags:classicmovielist  movies="${movieList}">
	 <tr><td>movie name:${movie}</td></tr>
</mytags:classicmovielist>
</table>