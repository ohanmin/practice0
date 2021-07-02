<%@page import="poly.util.CmmUtil"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<%
	//String name = CmmUtil.nvl((String)request.getAttribute("name"));
	String name = CmmUtil.nvl((String)request.getAttribute("name"));
%>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	안녕하세요, <%= name %> 님!
</body>
</html>