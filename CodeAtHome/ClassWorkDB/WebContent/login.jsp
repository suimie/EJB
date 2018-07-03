<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Login</title>
<style>
	body{
		width:600px;
		margin:auto;
	}
	td {
		padding:20px;
	}
</style>
</head>
<body>
	<h1>Welcome to JAC World!</h1>
	<h2>Enter username and password</h2>
	<form action="login" method="post">
		<table>
			<tr>
				<td>User Name : </td>
				<td><input type="text" id="username" name="username"></td>
			</tr>
			<tr>
				<td>Password : </td>
				<td><input type="password" id="password" name="password"></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" id="login" name="login" value="Login"></td>
			</tr>
		</table>
	</form>
</body>
</html>