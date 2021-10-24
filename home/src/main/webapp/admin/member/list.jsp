<%@page import="java.util.List"%>
<%@page import="home.beans.MemberDto"%>
<%@page import="home.beans.MemberDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- 입력 : 검색분류, 검색어 --%>
<%
String column = request.getParameter("column");
String keyword = request.getParameter("keyword");
%>

<%-- 처리 : 목록 조회 or 검색 --%>
<%
boolean search = column != null && !column.equals("") && keyword != null && !keyword.equals("");
MemberDao memberDao = new MemberDao();
List<MemberDto> list;
if (search) {//검색
	list = memberDao.select(column, keyword);
} else {
	list = memberDao.select();
}
		//삼항 연산 : if문 축소버전 - 조건 ? 참 : 거짓
		String title = search ? "회원검색" : "회원 목록";
%>

<%-- 출력 --%>
<jsp:include page="/template/header.jsp"></jsp:include>

<!-- 제목 -->
<h2><%=title%></h2>


<!-- 테이블 -->
<table border="1" width="400">
		<thead>
			<tr>
				<th>아이디</th>
				<th>닉네임</th>
				<th>메뉴</th>
			</tr>
		</thead>
	
		<tbody align = "center">
			<%for (MemberDto memberDto : list) {%>
			<tr>
				<td><%=memberDto.getMemberId()%></td>
				<td><%=memberDto.getMemberNick()%></td>
				
				<td>
					<a href ="detail.jsp?memberId=<%=memberDto.getMemberId()%>">상세</a>
					<a href ="edit.jsp?memberId=<%=memberDto.getMemberId()%>">수정</a>
					<a href ="quit.kh?memberId=<%=memberDto.getMemberId()%>">탈퇴</a>
				</td>
			<tr>
			<%}%>
		</tbody>
	</table>

<br>
		<!-- 검색 -->
	<form action="list.jsp" method="get">
	<select name="column">
		<%if(column != null && column.equals("member_id")){ %>
		<option value="member_id" selected>아이디</option>
		<%} else { %>
		<option value="member_id">아이디</option>
		<%} %>
		
<%-- 		<option value="member_id" <%=column!=null&&column.equals("member_id") ? "selected" : ""%>>아이디</option> --%>
		
		<%if(column != null && column.equals("member_nick")){ %>
		<option value="member_nick" selected>닉네임</option>
		<%} else { %>
		<option value="member_nick">닉네임</option>
		<%} %>
		
		<%if(column != null && column.equals("member_email")){ %>
		<option value="member_email" selected>이메일</option>
		<%} else { %>
		<option value="member_email">이메일</option>
		<%} %>
		
		<%if(column != null && column.equals("member_phone")){ %>
		<option value="member_phone" selected>전화번호</option>
		<%} else { %>
		<option value="member_phone">전화번호</option>
		<%} %>
		
		<%if(column != null && column.equals("member_grade")){ %>
		<option value="member_grade" selected>등급</option>
		<%} else { %>
		<option value="member_grade">등급</option>
		<%} %>
		
	</select>
<%-- 	<input type="search" name="keyword" placeholder="검색어 입력" required value="<%=keyword == null ? "" : keyword%>"> --%>
	<%if(keyword == null){ %>
	<input type="search" name="keyword" placeholder="검색어 입력" required>
	<%}else{ %>
	<input type="search" name="keyword" placeholder="검색어 입력" required value="<%=keyword%>">
	<%} %>
	<input type="submit" value="검색">
</form>


	<jsp:include page="/template/footer.jsp"></jsp:include>