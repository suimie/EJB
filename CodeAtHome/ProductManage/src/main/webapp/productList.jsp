<%@ page import="com.jac.web.model.Product" %>
<%@ page import="java.util.ArrayList" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Product List</title>
</head>
<body>
	<% ArrayList<Product> productList = (ArrayList<Product>)(request.getAttribute("productList")); %>
	<% if(productList == null) {
	//response.sendRedirect("index.jsp");
 	%>
		<h1>There are no product in the repository</h1>
	<%} else{
		%>
		<table>			
		<% for(int i=0; i < productList.size(); i++){ 
			Product p = productList.get(i);
		%>
			<tr>
				<td><%= p.getId() %> </td>
				<td><%= p.getName() %> </td>
				<td><%= p.getPrice().toString() %> </td>
			</tr>
		<% }%>
		</table>
	<%}%>
	
</body>
</html>