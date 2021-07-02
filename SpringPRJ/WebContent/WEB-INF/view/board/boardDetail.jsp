<%@page import="poly.dto.BoardDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "static poly.util.CmmUtil.nvl" %>
<% 
	BoardDTO bDto = (BoardDTO) request.getAttribute("bDto");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><%=nvl(bDto.getPost_title()) %></title>
</head>
<body>
		<div>제목</div>
		<div style="border:1px solid black">
			<%= bDto.getPost_title() %>
		</div>
		<br>
		<div>내용</div>
		<div style="border:1px solid black">
			<%= bDto.getPost_content() %>
		</div>
		<div style="float:left;">
			<button onclick="location.href='/board/boardList.do'">뒤로</button>
		</div>
		<div style="float:left;">
			<button onclick="location.href='/board/editPost.do?no=<%=bDto.getPost_no() %>'">
			편집
			</button>
		</div>
		<div style="float:left;">
			<button onclick="location.href='/board/deletePost.do?no=<%=bDto.getPost_no() %>'">
			삭제
			</button>
		</div>
</body>
</html>