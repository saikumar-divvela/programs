<%@ attribute name="name" required="true" %>
<%@ attribute name="size" required="true" %>
<%@ attribute name="options" required="true"  type="java.util.List" %>
<%@ tag body-content="scriptless"  dynamic-attributes="tagattrs" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<select  name='${name}' size='${size}' 
	<c:forEach var='attrEntry' items='${tagattrs}'>
		${attrEntry.key}='${attrEntry.value}'
	</c:forEach>
>
	<c:forEach var='attr' items='${options}'>
		<option value='${attr}'>${attr}</option>
	</c:forEach>
</select>