<%@page import="web09.beans.ExamDto"%>
<%@page import="web09.beans.ExamDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	int examId = Integer.parseInt(request.getParameter("examId"));
	
	ExamDao examDao = new ExamDao();
	ExamDto examDto =examDao.select(examId);
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>시험 정보 상세</title>
</head>
<body>
		
		<h1>시험 정보 상세</h1>
		
		<ul>
			<li>시험지번호 : <%=examDto.getExamId() %></li>
			<li>학생명 : <%=examDto.getStudent() %></li>
			<li>과목명 : <%=examDto.getSubject() %></li>
			<li>유형 : <%=examDto.getType() %></li>
			<li>점수 : <%=examDto.getScore() %>점</li>
		</ul>
		
		<h5><a href = "test06.jsp">목록보기</a></h5>
		
</body>
</html>