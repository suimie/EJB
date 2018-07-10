<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Welcome to School Management System</title>

<jsp:include page="../../header.jsp"></jsp:include>

<div class="container" style="width:500px;">
	<form action="login" method="post">
	  <fieldset>
	    <legend class="text-center text-secondary">Welcome to School Management System!<br/> Login please!</legend><br><br>
	    <%
	    	String error = (String)request.getAttribute("error");
	    	if (error != null && error != ""){%>
	    	<p class="text-danger"><%=error %></p>	
	    <%}%>
	    <div class="form-group">
	      <label for="username">Username</label>
	      <input type="text" class="form-control" id="username" name="username" placeholder="Username">
	    </div>
	    <div class="form-group">
	      <label for="password">Password</label>
	      <input type="password" class="form-control" id="password" name="password" placeholder="Password">
	    </div>
	    <button type="submit" class="btn btn-primary">Login</button>
	  </fieldset>
	</form>
</div>

<jsp:include page="../../footer.jsp"></jsp:include>