<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<html>
<head>
<meta charset="EUC-KR">
<title>Add Product</title>
<link href="resources/css/bootstrap.css" rel="stylesheet">

<jsp:include page="header.jsp"></jsp:include>

	<div class="container">
	<% String username = (String)session.getAttribute("username");
	if(username == null || !username.equals("admin")){%>
		<h1>You don't have the authority to add products.  Sorry</h1>
		<br/><br/>
		<a href="/ProductManagementSystem/getProductsList" class="btn btn-primary">Go back to list</a>	 
	<%}else{ %>
		<form action="Products" method="post">
		  <fieldset>
		    <legend>Enter information of new product </legend>
		    <input type="hidden" id="command" name="command" value="add" />
		    <div class="form-group">
		      <label for="pname">Product Name</label>
		      <input type="text" class="form-control" id="pname" name="pname" placeholder="Product Name">
		    </div>
		    <div class="form-group">
		      <label for="pprice">Product Price</label>
		      <input type="number" min="0" max="10000000.00" step="0.01" class="form-control" id="pprice" name="pprice" placeholder="Product Price">
		    </div>
		    <button type="submit" class="btn btn-primary">Add Product</button>
		  </fieldset>
		</form>
	<%} %>
	</div>
<jsp:include page="footer.jsp"></jsp:include>