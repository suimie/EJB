<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome page</title>
</head>
<body>
	<h1>Hi IPD 12!(This text is comming from index.jsp)</h1>
	<a href = "one"> This is one. </a><br/>
	<a href = "two"> This is two. </a><br/>
	<br/>
	<form action="three" method="post">
		USERNAME: <input type="text" name="user" />
		PASSWORD: <input type="password" name="password" />
		
		<button type="ubmit">Submit the data</button>
	</form>
</body>
</html>