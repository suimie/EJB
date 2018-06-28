<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome page</title>
</head>
<body>
	<h1>Enter user name and password</h1>

	<br/>
	<form action="one" method="post">
		USERNAME1: <input type="text" name="username1" />
		PASSWORD1: <input type="password" name="password1" />
		<br/>
		USERNAME2: <input type="text" name="username2" />
		PASSWORD2: <input type="password" name="password2" />
		<br/>
		<button type="ubmit">Submit the data</button>
	</form>
</body>
</html>