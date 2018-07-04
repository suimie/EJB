<jsp:include page="header.jsp"></jsp:include>
<body>

<div class="container" >
	<form action="LoginSystem" method="post">
	  <fieldset>
	    <legend>Welcome! Login please!</legend>
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
</body>
</html>
