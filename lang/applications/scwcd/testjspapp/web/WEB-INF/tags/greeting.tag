<%@ attribute name="username" required="true"  rtexprvalue="true"  type="java.lang.String"%>
<%@ attribute name="colour" required="true"  rtexprvalue="true"%>
<%@ tag body-content="tagdependent" %>

<br/>
<strong>HELLO ${username} </strong>
<br/>
<font color="${colour}"> <jsp:doBody/> </font>