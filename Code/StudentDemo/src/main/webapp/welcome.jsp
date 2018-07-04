<%@ page import="com.jac.web.model.Student" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<% if(session.getAttribute("user1") == null) {
	response.sendRedirect("index.jsp");
}else{
	out.print("Else");
}
%>
	<h1>Welcome.jsp page</h1>
	
	<% String error = (String)request.getAttribute("error");
		if(error != null){
	%>
	<h1>Student is not present in the database.</h1>
	<% } Student student = (Student)request.getAttribute("student"); %>
	
	Student details are <%=student %>
	
	<br/><br/>
	<a href="LoginStudent">Logout</a>
</body>
</html>