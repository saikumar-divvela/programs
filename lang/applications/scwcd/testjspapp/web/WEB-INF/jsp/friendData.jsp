<%@ page import="foo.Person" %>
<html>
<body>
My details<br/>${person}<br/>
My  name  is  <%= ((Person)request.getAttribute("person")).getName()%><br/>
Friend's name  is  <%= ((Person)request.getAttribute("person")).getFriend().getName()%><br/>
Again<br/>My name is ${person.name}<br/>
Friend's name is ${person.friend.name}<br/>
My friend's details<br/>${person.friend}<br/>
Now list details <br/>
My details : ${persons[0]}<br/>
My  friend's details : ${persons[0].friend}<br/>
Music details<br/>
${musicList[numbers[0]]}<br/>
${musicList[numbers[0]+1]}<br/>
${musicList[numbers[2]]}<br/>
${musicList[numbers[numbers[1]]]}<br/>
</body>
</html>