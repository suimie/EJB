<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<!DOCTYPE html>
<html>
<head>
	<link href="webjars/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet">
   	<!--<spring:url value="/resources/bootstrap/css/bootstrap.min.css" var="mainCss" />
	<spring:url value="/resources/jquery/jquery-3.3.1.js" var="jqueryJs" />
	<spring:url value="/resources/bootstrap/js/bootstrap.min.js" var="mainJs" />
	
	<link href="${mainCss}" rel="stylesheet" />
    <script src="${jqueryJs}"></script>
    <script src="${mainJs}"></script>-->
    

</head>
<body>
	<div class="container">
		<h2>Hello World!</h2>
		<div style="width:600px;margin:auto">
			<form action="login" method="post">
			<p class="text-danger text-bold">${error}</p>
			  <div class="form-group">
			    <label for="username">User Name</label>
			    <input type="text" class="form-control" id="username" name="username" placeholder="User Name">
			  </div>
			  <div class="form-group">
			    <label for="password">Password</label>
			    <input type="password" class="form-control" id="password" name="password" placeholder="Password">
			  </div>
			  <button type="submit" class="btn btn-primary">Submit</button>
			</form>
		</div>
	</div>
	
    <script src="webjars/jquery/3.1.1/jquery.min.js"></script>
	<script src="webjars/bootstrap/4.1.1/js/bootstrap.min.js"></script>
</body>
</html>