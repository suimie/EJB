<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Welcome to Product Management System</title>

<jsp:include page="header.jsp"></jsp:include>

<div class="container" >
	<form action="LoginSystem" method="post">
	  <fieldset>
	    <legend>Welcome! Login please!</legend>
	    <% String errorStr = (String)session.getAttribute("error"); %>
		<% if(session.getAttribute("username") == null && errorStr != null){%>
			<p><%= errorStr %></p>
		<% session.removeAttribute("error");}%>

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

<jsp:include page="footer.jsp"></jsp:include>