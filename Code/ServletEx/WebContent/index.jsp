<%@page import="java.util.Calendar"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome page</title>
</head>
<body>
	<h1>Hi IPD 12!(This text is coming from index.jsp)</h1>
	<a href = "one"> This is one. </a><br/>
	<a href = "two"> This is two. </a><br/>
	<br/>
	<form action="one" method="post">
		USERNAME: <input type="text" name="user" />
		PASSWORD: <input type="password" name="password" />
		
		<button type="submit">Submit the data</button>
	</form>
	
	<form action="one" method="get">
		NAME: <input type="text" name="name" />
		ID: <input type="text" name="id" />
		
		<button type="submit">Save Student Info</button>
	</form>
	
	<form action="test.jsp" method="post">
		USERNAME: <input type="text" name="user" />
		PASSWORD: <input type="password" name="password" />
		
		<button type="submit">Submit the data to JSP</button>
	</form>
	<% out.println("Hello World!"); %>
	<%! int val=50; %>
	<p>
	<%="Value of the variable is: "+val %>
	</p>
	<p>
	Current Time : <%= Calendar.getInstance().getTime() %>
	</p>
</body>
</html>