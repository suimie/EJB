<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1><%= request.getParameter("user") %></h1>
	
	<% String pass = request.getParameter("password");
		if(pass.equals("pass")){ %>
			<h2>password is pass </h2>
		<%}else{ %>
			<h2>password is not pass</h2>
		<%} %>
</body>
</html>