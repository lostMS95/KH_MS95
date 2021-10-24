<%@page import="home.beans.TotalHistoryDto"%>
<%@page import="java.text.Format"%>
<%@page import="java.text.DecimalFormat"%>
<%@page import="home.beans.TotalHistoryDao"%>
<%@page import="java.util.List"%>
<%@page import="home.beans.MemberDto"%>
<%@page import="home.beans.MemberDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- 입력 : 상세조회 할 회원 ID - String memberId --%>
<%
String memberId = request.getParameter("memberId");
%>

<%-- 처리 : 회원정보(MemberDto) --%>
<%
	MemberDao memberDao = new MemberDao();
	MemberDto memberDto = memberDao.select(memberId);
	
// 	아래와 같이 조회하면 취소 여부를 알 수 없다.
// 	HistoryDao historyDao = new HistoryDao();
// 	List<HistoryDto> historyList = historyDao.findByMemberId(memberId);
// 	새롭게 만든 뷰(total_history)를 이용하여 포인트 이력을 조회
	TotalHistoryDao historyDao = new TotalHistoryDao();
	List<TotalHistoryDto> historyList = historyDao.findByMemberId(memberId);
%>



<%-- 출력 --%>

<jsp:include page="/template/header.jsp"></jsp:include>

<h1>회원 상세 조회</h1>

<table border="1" width="1000">
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
		<tbody align = "center">
			<tr>
				<td><%=memberDto.getMemberId()%></td>
				<td><%=memberDto.getMemberNick()%></td>
				<td><%=memberDto.getMemberBirth().substring(0, 10)%></td>
				<td><%=memberDto.getMemberEmailString()%></td>
				<td><%=memberDto.getMemberPhoneString()%></td>
				<td><%=memberDto.getMemberJoin()%></td>
				<td><%=memberDto.getMemberPoint()%></td>
				<td><%=memberDto.getMemberGrade()%></td>
			</tr>
		</tbody>
	</table>
	
	<hr>
	
	<h3><a href ="quit.kh?memberId=<%=memberDto.getMemberId()%>">회원 강제 탈퇴</a></h3>
	<h3><a href= "edit.jsp?memberId=<%=memberDto.getMemberId()%>">회원 정보 변경</a></h3>
	<h3><a href ="list.jsp">목록보기</a></h3>
	
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
		<%Format f = new DecimalFormat("#,##0"); %>
		<%for(TotalHistoryDto historyDto : historyList) { %>
		<tr>
			<td align="center"><%=historyDto.getHistoryTime()%></td>
			<td align="right"><%=f.format(historyDto.getHistoryAmount())%></td>
			<td align="left"><%=historyDto.getHistoryMemo()%></td>
			<td><%=historyDto.getCancel()%></td>
			<td>
				<%if(historyDto.available()){ %>
				<a href="../point/cancel.kh?historyNo=<%=historyDto.getHistoryNo()%>">취소</a>
				<%} %>
			</td>
		</tr>
		<%} %>
	</tbody>
</table>

<jsp:include page="/template/footer.jsp"></jsp:include>
	