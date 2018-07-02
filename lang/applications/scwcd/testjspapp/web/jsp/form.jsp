<html>
<body>
	<strong>this is simple jsp which takes some user details and forwards to servlet which again forwards to another jsp where
		the details are printed using bean
	</strong>
	<br/>
	<form name="form1" action="infojsp" method="post" >
			Name: <input type="text" name="name"/>
			<br/>
			email:<input type="text" name="email"/>
			<input type="submit" value="send"/>
			<input type="checkbox"  name="processor" value="intel">intel</input>
			<br/>
	</form>
</body>
</html>