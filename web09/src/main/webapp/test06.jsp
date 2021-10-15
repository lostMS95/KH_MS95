<%--
		검색은 어떻게 구현할 것인가?
		= JSP는 자바 코드를 사용할 수 있다
		= JSP에서 요청정보나 응답정보를 접근할 수 있는가? (내장객체 형태로 제공)
 		= 요청정보는 request로 접근할 수 있다(이름 변경 불가)
 --%>

<%@page import="web09.beans.ExamDto"%>
<%@page import="java.util.List"%>
<%@page import="web09.beans.ExamDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%-- 프로그래밍 코드  --%>
<%
		//처리
		String column = request.getParameter("column");
		String keyword = request.getParameter("keyword");
	
		//처리
		boolean search = column != null && keyword != null;
		
		ExamDao examDao = new ExamDao();
		List<ExamDto>list;
		if(search) {
			list = examDao.select(column, keyword);
		}
		else {
			list = examDao.select();
		}
%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>시험 정보 목록</title>
</head>
<body>
		
		<h1>시험 정보 목록</h1>
		
		<!-- 검색창 -->
		<form action = "test06.jsp">
			<fieldset>
				<legend>검색화면</legend>
			
			
			<select name="column">
				<option value = "student">학생명</option>
				<option value = "subject">과목명</option>
				
			</select>
			
			<input type="search" name="keyword" required>
			<input type="submit" value = "검색">	
			</fieldset>
			</form>
		
		
		<table border="1" width = "600">
			<thead>
				<tr>
					<th>번호</th>
					<th>학생명</th>
					<th>과목명</th>
					<th>서술형</th>
					<th>점수</th>
					<th>메뉴</th>
				</tr>
			</thead>
			
			<tbody align = "center">
				<% for(ExamDto examDto : list) {%>
				<tr>
					<td><%=examDto.getExamId() %></td>
					<td><%=examDto.getStudent()%></td>
					<td><%=examDto.getSubject() %></td>
					<td><%=examDto.getType() %></td>
					<td><%=examDto.getScore() %></td>
					<td>
						<a href = "/web09/test09.jsp?examId=<%=examDto.getExamId() %>">상세보기</a>
					</td>
					
				</tr>
				<% } %>
			</tbody>
		</table>
		
</body>
</html>