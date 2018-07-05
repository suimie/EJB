<%@page import="com.jac.web.model.Student"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome.jsp</title>
<body>
	Welcome.jsp page.
	<% Student student = (Student)request.getAttribute("student"); %>
	
	Student details are:<b> <%=student %></b>
</body>
</html>
