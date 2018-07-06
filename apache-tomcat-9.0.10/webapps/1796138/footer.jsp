<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%! final static String DATE_FORMAT_NOW = "yyyy-MM-dd"; %>
<% SimpleDateFormat df = new SimpleDateFormat(DATE_FORMAT_NOW); %>
<footer>
	<hr>
    <p style="text-align: center;">&copy; <%= df.format(new Date()) %> - Product Management System | <span style="color:darkblue;">Programmed by Suim Park</span></p>
</footer>
</body>
</html>