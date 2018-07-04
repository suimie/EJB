<%@ page import="com.jac.web.model.Student" %>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Welcome</title>
</head>
<body>
	<h1>Welcome!</h1>
	<% Student s1 = (Student)request.getAttribute("student"); %>
	<%= s1 %>
</body>
</html>