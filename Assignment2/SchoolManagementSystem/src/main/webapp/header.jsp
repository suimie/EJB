<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<link href="webjars/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet">
<style>
	.container{
		width:90%;
		margin:auto;
		margin-top:50px;
	}
	footer{
		padding:30px;
		margin-top:120px;
	}
</style>
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-dark bg-primary">
  <a class="navbar-brand" href="index.jsp">School Management System</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>
  <div class="collapse navbar-collapse" id="navbarNav">
    <ul class="navbar-nav">
      <li class="nav-item active">
        <a class="nav-link" href="index.jsp">Home <span class="sr-only">(current)</span></a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="library">Library</a>
      </li>
      <%
		String username = (String)session.getAttribute("username");
      	if(username != null && username.equals("teacher")){
      %>
      <li class="nav-item">
        <a class="nav-link" href="student">Student</a>
      </li>
      <%}
      	if(username != null){
      %>
      <li class="nav-item">
        <a class="nav-link" href="logout">Logout</a>
      </li>
      <%}else{%>
      <li class="nav-item">
        <a class="nav-link" href="enter">Login</a>
      </li>
      <%}%>
    </ul>
  </div>
</nav>
