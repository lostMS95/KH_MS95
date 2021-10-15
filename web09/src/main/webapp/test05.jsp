<%@page import="web09.beans.ExamDto"%>
<%@page import="java.util.List"%>
<%@page import="web09.beans.ExamDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
		//프로그래밍 조회 코드
		ExamDao examDao = new ExamDao();
		List<ExamDto> list = examDao.select();
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>시험 정보 목록</title>
</head>
<body>
		
		<h1>시험 정보 목록</h1>
	
		<table border="1" width = "500">
			<thead>
				<tr>
					<th>학생명</th>
					<th>과목명</th>
					<th>서술형</th>
					<th>점수</th>
				</tr>
			</thead>
			
			<tbody align = "center">
				<% for(ExamDto examDto : list) {%>
				<tr>
					
					<td><%=examDto.getStudent()%></td>
					<td><%=examDto.getSubject() %></td>
					<td><%=examDto.getType() %></td>
					<td><%=examDto.getScore() %></td>
					
				</tr>
				<% } %>
			</tbody>
		</table>
		
</body>
</html>