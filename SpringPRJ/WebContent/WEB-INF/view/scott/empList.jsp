<%@page import="poly.dto.EmpDTO"%>
<%@page import="java.util.List"%>
<%@page import="static poly.util.CmmUtil.nvl" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	List<EmpDTO> rList = (List<EmpDTO>)request.getAttribute("rList");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
간다간다뿅간다
<table border="1">
<tr>
	<td>empno</td>
	<td>ename</td>
	<td>job</td>
	<td>manager</td>
	<td>hiredate</td>
	<td>sal</td>
	<td>comm</td>
	<td>deptno</td>
</tr>
<%for(EmpDTO eDto :rList){ %>
<tr>
	<td><%=nvl(eDto.getEmpno()) %></td>
	<td><%=nvl(eDto.getEname()) %></td>
	<td><%=nvl(eDto.getJob()) %></td>
	<td><%=nvl(eDto.getMgr()) %></td>
	<td><%=nvl(eDto.getHiredate()) %></td>
	<td><%=nvl(eDto.getSal()) %></td>
	<td><%=nvl(eDto.getComm()) %></td>
	<td><%=nvl(eDto.getDeptno()) %></td>
</tr>
<%} %>
</table>
</body>
</html>