<%@page import="java.util.List"%>
<%@page import="home.beans.CoinDao"%>
<%@page import="home.beans.CoinDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%-- 입력 : 없음 --%>

<%-- 처리 : 포인트상품 목록 --%>  
<%
  	CoinDao coinDao = new CoinDao();
  	List<CoinDto> list = coinDao.list();
%> 

<%-- 출력 --%>
<jsp:include page="/template/header.jsp"></jsp:include>
 
 <h2>포인트 충전</h2>

<h4>원하시는 상품을 선택하세요</h4>

<form action="charge.kh" method="post">
 	<table>
 		<tbody>
 		<%for(CoinDto coinDto : list) { %>
 				<tr>	
 					<th><input type="radio" name="coinNo" value="<%=coinDto.getCoinNo()%>"></th>
 					<td><%=coinDto.getCoinName()%>(<%=coinDto.getCoinAmount() %> point)</td>
 				</tr>
 				<%} %>
 			</tbody>
 			<tfoot>
			<tr align="center">
				<td colspan="3">
					<input type="submit" value="충전">
				</td>
			</tr>
			</tfoot>
 	</table>	
 	
 </form>
 	
<jsp:include page="/template/footer.jsp"></jsp:include>
 					