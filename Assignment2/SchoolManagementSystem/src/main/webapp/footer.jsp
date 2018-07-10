<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%! final static String DATE_FORMAT_NOW = "yyyy-MM-dd"; %>
<% SimpleDateFormat df = new SimpleDateFormat(DATE_FORMAT_NOW); %>
<footer>
	<hr>
    <p style="text-align: center;">&copy; <%= df.format(new Date()) %> - Product Management System | <span style="color:darkblue;">Programmed by Suim Park</span></p>
</footer>
<script src="webjars/jquery/3.1.1/jquery.min.js"></script>
<script src="webjars/bootstrap/4.1.1/js/bootstrap.min.js"></script>

</body>
