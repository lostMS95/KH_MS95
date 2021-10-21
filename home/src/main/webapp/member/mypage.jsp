<%@page import="home.beans.TotalHistoryDto"%>
<%@page import="home.beans.TotalHistoryDao"%>
<%@page import="home.beans.HistoryDto"%>
<%@page import="java.util.List"%>
<%@page import="home.beans.CoinDto"%>
<%@page import="home.beans.CoinDao"%>
<%@page import="home.beans.HistoryDao"%>
<%@page import="home.beans.MemberDto"%>
<%@page import="home.beans.MemberDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%--입력 : 현재 로그인한 회원ID - String memberId --%>
<%
	String memberId = (String)session.getAttribute("logkey");
%>

<%--처리 : 회원정보(MemberDto) --%>
<%
	MemberDao memberDao = new MemberDao();
	MemberDto memberDto = memberDao.select(memberId);
	
// 	아래와 같이 조회하면 취소 여부를 알 수 없다.
//	HistoryDao historyDao = new HistoryDao();
//	List<HistoryDto> historyList = historyDao.findByMemberId(memberId);

// 	새롭게 만든 뷰(total_history)를 이용하여 포인트 이력을 조회
	TotalHistoryDao historyDao = new TotalHistoryDao();
	List<TotalHistoryDto> historyList = historyDao.findByMemberId(memberId);

%>

<%--출력 --%>

<jsp:include page="/template/header.jsp"></jsp:include>

<h2>회원 상세 정보</h2>

<table border="1" width="300">
	<tbody>
		<tr>
			<th width="25%">아이디</th>
			<td><%=memberDto.getMemberId() %></td>
		</tr>
		<tr>
			<th>닉네임</th>
			<td><%=memberDto.getMemberNick() %></td>
		</tr>
		<tr>
			<th>생년월일</th>
			<td><%=memberDto.getMemberBirth() %></td>
		</tr>
		<tr>
			<th>이메일</th>
			<td><%=memberDto.getMemberEmailString()%></td>
		</tr>
		<tr>
			<th>전화번호</th>
			<td><%=memberDto.getMemberPhoneString()%></td>
		</tr>
		<tr>
			<th>가입일시</th>
			<td><%=memberDto.getMemberJoin() %></td>
		</tr>
		<tr>
			<th>포인트</th>
			<td><%=memberDto.getMemberPoint() %></td>
		</tr>
		<tr>
			<th>등급</th>
			<td><%=memberDto.getMemberGrade() %></td>
		</tr>
	</tbody>
</table>

<h3><a href ="password.jsp">비밀번호 변경</a></h3>
<h3><a href ="edit.jsp">개인정보 변경</a></h3>
<h3><a href ="check.jsp">회원 탈퇴</a></h3>


<hr>

<h2>포인트 상세 내역</h2>

<table border="1" width="500">
	<thead>
		<tr>
			<th>일시</th>
			<th>금액</th>
			<th>메모</th>
			<th>cancel</th>
			<th>취소</th>
		</tr>
	</thead>
	<tbody>
		<%for(TotalHistoryDto historyDto : historyList) { %>
		<tr>
			<td align="center"><%=historyDto.getHistoryTime() %></td>
			<td align="center"><%=historyDto.getHistoryAmount() %></td>
			<td align="center"><%=historyDto.getHistoryMemo() %></td>
			<td><%=historyDto.getCancel()%></td>
			<td align="center">
				<%if(historyDto.available()){ %>
				<a href="../point/cancel.kh?historyNo=<%=historyDto.getHistoryNo()%>">취소</a>
				<%} %>
			</td>
		</tr>
		<%} %>
	</tbody>
</table>

<jsp:include page="/template/footer.jsp"></jsp:include>