<%@page import="java.math.BigDecimal"%>
<%@page import="com.ipd12.model.Product"%>
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
	if(username == null || !username.equals("admin")){ %>
		<h1>You don't have the authority to add products.  Sorry</h1>
		<br/><br/>
		<a href="<%=request.getContextPath() %>/Products" class="btn btn-primary">Go back to list</a>	 
	<%}else{
		Product product = (Product)request.getAttribute("product");
		if(product == null){
			product = new Product();
			product.setId(0);
			product.setName("");
			product.setPrice(new BigDecimal(0));
		}
	%>
	
		<form action="Products" method="post">
		  <fieldset>
		    <legend>Enter information of new product </legend>
		    
    		<% String error = (String)request.getAttribute("error");
			if(error != null && error != ""){%>
				<p class="text-danger"><%= error %></p>
			<% }%>
			
		    <input type="hidden" id="command" name="command" <%if(product.getId()<=0){ %>value="add"<%}else{ %>value="update"<%} %> />
		    <input type="hidden" id="pId" name="pId" value="<%=product.getId()%>">
		    <div class="form-group">
		      <label for="pname">Product Name</label>
		      <input type="text" class="form-control" id="pname" name="pname" value="<%=product.getName()%>">
		    </div>
		    <div class="form-group">
		      <label for="pprice">Product Price</label>
		      <input type="number" min="0" max="10000000.00" step="0.01" class="form-control" id="pprice" name="pprice" value="<%=product.getPrice()%>">
		    </div>
		    <button type="submit" class="btn btn-primary"><%if(product.getId()<=0){ %>Add Product<%}else{ %>Update Product<%} %></button>
		  </fieldset>
		</form>
	<%} %>
	</div>
<jsp:include page="footer.jsp"></jsp:include>