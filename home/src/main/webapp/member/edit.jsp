<%@page import="home.beans.MemberDto"%>
<%@page import="home.beans.MemberDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


  <%-- 입력 : memberId (session) --%>
<%
	String memberId = (String)session.getAttribute("logkey");
%>

<%-- 처리 --%> 
 <%
 	MemberDao memberDao = new MemberDao();
 	MemberDto memberDto = memberDao.select(memberId);
 %>

<%-- 출력 --%>
  <jsp:include page="/template/header.jsp"></jsp:include>
 
 <h2>회원 정보 수정</h2>
 
 <form action="edit.kh" method="post">
 	
 	<table border="0">
 		<tbody>
 			<tr>
 				<th>비밀번호</th>
 				<td>
 					<input type="password" name="memberPw" required>
 				</td>
 			</tr>
 			<tr>
 				<th>닉네임</th>
 				<td>
 					<input type="text" name="memberNick" required value="<%=memberDto.getMemberNick()%>">
 				</td>
 			</tr>
 			<tr>
 				<th>생년월일</th>
 				<td>
 					<input type="date" name="memberBirth" required value="<%=memberDto.getMemberBirth().substring(0,10)%>">
 				</td>
 			</tr>
 			<tr>
 				<th>이메일</th>
 				<td>
 					<input type="email" name=memberEmail required value="<%=memberDto.getMemberEmailString()%>">
 				</td>
 			</tr>
 			<tr>
 				<th>전화번호</th>
 				<td>
 					<input type="text" name=memberPhone required value="<%=memberDto.getMemberPhoneString()%>">
 				</td>
 			</tr>
 			<tr>
 				
		</tbody>
 		<tfoot>
 			<tr>
 				<td colspan="2" align="right">
 					<input type="submit" value="변경">
 				</td>
 			</tr>
 		</tfoot>
 	
 	</table>
</form>
 
 <%if(request.getParameter("error") != null) {%>
	<h4><font color = "red">입력하신 비밀번호가 일치하지 않습니다.</font></h4>
<%} %>
 
 <jsp:include page="/template/footer.jsp"></jsp:include>