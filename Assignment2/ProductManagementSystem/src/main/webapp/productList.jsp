<%@page import="com.jac.web.model.Product"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<html>
<head>
<meta charset="EUC-KR">
<title>Products List</title>
<jsp:include page="header.jsp"></jsp:include>

	<div class="container">
		<% String username = (String)session.getAttribute("username");
		   ArrayList<Product> productList = (ArrayList<Product>)request.getAttribute("products"); 
		   if(productList == null) {
	 	%>
			<h1>There are no product in the repository</h1>
		<%} else{%>
			<h1>Products List</h1><br/><br/>
			<table class="table table-hover">	
				<thead>
					<tr>
						<th scope="col">ID</th>
						<th scope="col">Product Name</th>
						<th scope="col" style="text-align:right">Price</th>
						<% if(username != null && username.equals("admin")){ %>
						<th scope="col" style="text-align:right">Delete</th>
						<%} %>
					</tr>
				</thead>		
				<tbody>
			<% for(int i=0; i < productList.size(); i++){ 
				Product p = productList.get(i);
			%>
				<tr>
					<td><%= p.getId() %> </td>
					<td><%= p.getName() %> </td>
					<td style="text-align:right"><%= p.getPrice().toString() %> </td>
					<% if(username != null && username.equals("admin")){ %>
						<td scope="col" style="text-align:right">
							<form action="Products" method="post">
							    <input type="hidden" id="command" name="command" value="delete" />								
								<input type="hidden" id="pId" name="pId" value="<%= p.getId() %>">
								<button type="submit" class="btn btn-sm btn-Danger">Delete</button>
							</form>
						</td>
					<%} %>
				</tr>
			<% }%>
				</tbody>
			</table>
			<% 
				if(username != null && username.equalsIgnoreCase("admin")){%>
					<a href="addProduct.jsp" class="btn btn-primary">Add Product</a>
			<% } %>
		<%} %>
	</div>
<jsp:include page="footer.jsp"></jsp:include>