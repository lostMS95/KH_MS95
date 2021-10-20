<%@page import="home.beans.MemberDto"%>
<%@page import="home.beans.MemberDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<jsp:include page="/template/header.jsp"></jsp:include>
 	
 <h2>비밀번호 변경</h2>	
 	
<form action="password.kh" method="post">
		
		<table>
			<tbody>
				<tr>
					<th>현재 비밀번호</th>
					<td>
						<input type="password" name="memberPw" required>
					</td>
				</tr>	
				<tr>
					<th>변경할 비밀번호</th>
					<td>
						<input type="password" name="changePw" required>
					</td>
				</tr>	
			</tbody>
			<tfoot>
				<tr>
					<td colspan="2" align="center">
						<input type="submit" value="변경">
					</td>
				</tr>
			</tfoot>
		</table>
</form>

<%if(request.getParameter("error") != null) {%>
	<h4><font color = "red">입력하신 정보가 일치하지 않습니다</font></h4>
<%} %>

<jsp:include page="/template/footer.jsp"></jsp:include>   