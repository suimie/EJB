<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style>
	body{
		width:80%;
		margin:center;
	}
	form input{
		margin:10px;
	}
</style>
</head>
<body>
	<div style="margin:center;width:200px">
		<form action="register" method="post">
			Name: <input type="text" name="name" required/><br/>
			Student ID: <input type="text" name="studentID" /><br/>
			User name: <input type="text" name="username" required/><br/>
			Password: <input type="password" name="password" required/><br/>
			Email Address: <input type="text" name="email" /><br/>
			City: <input type="text" name="city" /><br/>
			
			<button type="submit">Register</button>
		</form>
	</div>
</body>
</html>