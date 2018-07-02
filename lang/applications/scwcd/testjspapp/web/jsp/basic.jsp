<html>
	<body>
		<strong>this jsp uses  scriptlets, declarations, implicit objects etc... </strong>
		<br/>
		<%! int count =0; %>
		<h4> page count :<%=++count%></h4>
		<br/>initParam.name ${initParam.name}
		<br/>initParam["name"] ${initParam["name"]}
	</body>
</html>