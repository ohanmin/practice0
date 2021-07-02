<%@page import="poly.dto.BoardDTO"%>
<%@page import="java.util.List"%>
<%@page import="static poly.util.CmmUtil.nvl" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	List<BoardDTO> rList = (List<BoardDTO>)request.getAttribute("rList");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table border="1">
		<tr>
			<td>post_no</td>
			<td>reg_id</td>
			<td>post_tile</td>
			<td>post_content</td>
			<td>REG_DT</td>
			<td>upd_id</td>
			<td>UPD_DT</td>
		</tr>
		<%for(BoardDTO b : rList){ %>
			<tr>
				<td><%=nvl(Integer.toString(b.getPost_no())) %></td>
				<td><%=nvl(b.getReg_id()) %></a></td>
				<td><a href="/board/boardDetail.do?no=<%=b.getPost_no()%>"><%=nvl(b.getPost_title()) %></td>
				<td><%=nvl(b.getPost_content()) %></td>
				<td><%=nvl(b.getReg_dt()) %></td>
				<td><%=nvl(b.getUpd_id()) %></td>
				<td><%=nvl(b.getUpd_dt()) %></td>
		<%} %>
		<div style="width:100%;text-align:rigt;margin-top:5px;">
			<button type=button onclick="location.href='/board/newPost.do'">글쓰기</button>		
		</div>
	</table>
</body>
</html>