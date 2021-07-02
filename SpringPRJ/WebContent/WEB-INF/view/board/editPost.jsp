<%@page import="poly.dto.BoardDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="static poly.util.CmmUtil.nvl" %>
<%
	BoardDTO bDto = (BoardDTO) request.getAttribute("bDto");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글편집</title>
</head>
<body>
	<form action="/board/doEditPost.do" method="post">
		<div>제목</div>
		<div>
			<input type="text" name="post_title" style="width: 500px;"
			value=<%=nvl(bDto.getPost_title()) %> required>
		</div>
		<br>
		<div>내용</div>
		<div>
			<textarea  name="post_content" 
			 style="width: 500px;" required><%=nvl(bDto.getPost_content()) %>
			</textarea>
		</div>
		<input name="post_no" value=<%=bDto.getPost_no() %> hidden="hidden">
		<div><input type="submit"></div>
	</form>
</body>
</html>