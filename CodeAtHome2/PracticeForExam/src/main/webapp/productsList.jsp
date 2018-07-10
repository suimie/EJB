<%@page import="com.ipd12.model.Product"%>
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
			<form action="Products" method="post">
				<input type="hidden" id="command" name="command" value="search">
				<div class="row">
					<!--  <div class="input-group mb-3 col col-sm-3">
					  <div class="input-group-prepend">
					    <label class="input-group-text" for="inputGroupSelect01">Options</label>
					  </div>
					  <select class="custom-select" id="option" name="option">
					    <option value="1">Title</option>
					    <option value="2">Author</option>
					  </select>
					</div>-->
					<div class="form-group col col-sm-10">
				      <input type="text" class="form-control" id="keyword" name="keyword" placeholder="Keyword for Search">
				    </div>
				</div>
			</form>	
		<table class="table table-hover">	
				<thead>
					<tr>
						<th scope="col">ID</th>
						<th scope="col">Product Name</th>
						<th scope="col" style="text-align:right">Price</th>
						<% if(username != null && username.equals("admin")){ %>
						<th scope="col" style="text-align:right">Delete</th>
						<th scope="col" style="text-align:right">Edit</th>
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
								<button type="submit" class="btn btn-sm btn-Danger" onclick="return confirm('Are you sure you want to delete this product?')">Delete</button>
							</form>
						</td>
						<td scope="col" style="text-align:right">
							<form action="Products" method="post">
							    <input type="hidden" id="command" name="command" value="edit" />								
								<input type="hidden" id="pId" name="pId" value="<%= p.getId() %>">
								<button type="submit" class="btn btn-sm btn-Danger">Edit</button>
							</form>
						</td>
					<%} %>
				</tr>
			<% }%>
				</tbody>
			</table>
		<%} %>
		<br><br>
		<% 
			if(username != null && username.equalsIgnoreCase("admin")){%>
				<a href="editProduct.jsp" class="btn btn-primary">Add Product</a>
		<% } %>
	</div>
<jsp:include page="footer.jsp"></jsp:include>