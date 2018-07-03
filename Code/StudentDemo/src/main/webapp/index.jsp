<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>index.jsp</title>

</head>
<body>
	<%--  <jsp:forward page="header.jsp"></jsp:forward>
	<jsp:include page="header.jsp"></jsp:include>

	<h2>Hello World!</h2>--%>
	
	
	<form action="LoginStudent" method="post">
	<label>Username : </label>
	<input type="text" name="username" /><br/>
	<label>Password : </label>
	<input type="password" name="password" /><br/>
	<button type="submit">Login</button>
	</form>
</body>
</html>
