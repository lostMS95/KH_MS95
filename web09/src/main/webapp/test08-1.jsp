<%@page import="web09.beans.MemberDto"%>
<%@page import="java.util.List"%>
<%@page import="web09.beans.MemberDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!-- 프로그래밍 입력 코드 -->
<%-- 입력 : column, keyword --%>

<%
String column = request.getParameter("column");
String keyword = request.getParameter("keyword");
%>

<%-- 처리 : MemberDao --%>    
<% 
boolean search = column != null && keyword != null;

MemberDao memberDao = new MemberDao();
List<MemberDto> list;
if (search) {
	list = memberDao.select(column, keyword);
} else {
	list = memberDao.select();
}

//화면에 출력하기 위한 값을 준비
String title;
if(search) {
	title = "회원 검색";
}
else {
	title = "회원 목록";
}
%>

<!-- 출력 코드 -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원목록</title>
</head>
<body>

	
	<!-- 제목 -->
	<h1><%=title %></h1>

	<!-- 테이블 코드 -->
	<table border="1" width="900">
		<thead>
			<tr>
				<th>회원 아이디</th>
				<th>회원 닉네임</th>
				<th>생년월일</th>
				<th>이메일</th>
				<th>전화번호</th>
				<th>가입일자</th>
				<th>보유포인트</th>
				<th>회원등급</th>
			</tr>
		</thead>
	
		<%--
				(Q)  아이디를 클릭하면 web05에 만든 MemberDetailServlet으로 이동하여 정보 출력
		 --%>
	
		<tbody align = "center">
			<%for (MemberDto memberDto : list) {%>
			<tr>
				<td>
							<!-- 상세 페이지로 연결할 수 있도록 hyperlink 설정 -->
							<a href = "/web05/member/detail.kh?memberId=<%=memberDto.getMemberId()%>">
												<%=memberDto.getMemberId()%>
							</a>
				</td>
				<td><%=memberDto.getMemberNick()%></td>
				<td><%=memberDto.getMemberBirth().substring(0, 10)%></td>
				<td><%=memberDto.getMemberEmailString()%></td>
				<td><%=memberDto.getMemberPhoneString()%></td>
				<td><%=memberDto.getMemberJoin()%></td>
				<td><%=memberDto.getMemberPoint()%></td>
				<td><%=memberDto.getMemberGrade()%></td>
			</tr>
			<%}%>
		</tbody>
	</table>
	
		<!-- 검색 -->
	<form action="test08.jsp">
		<fieldset>
			<legend>검색화면</legend>
			<select name="column">
				<option value="member_id">아이디</option>
				<option value="member_nick">닉네임</option>
			</select> 
			<input type="search" name="keyword"> 
			<input type="submit"value="검색">

		</fieldset>
	</form>

</body>
</html>