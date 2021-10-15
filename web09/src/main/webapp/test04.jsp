<%@page import="web09.beans.ProductDto"%>
<%@page import="java.util.List"%>
<%@page import="web09.beans.ProductDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 목록 조회</title>
</head>
<body>
				
<%--
  			product  테이블의 데이터들을 조회하여 화면에 HTML 방식으로 출력
  			=프로그래밍 조회 코드 + HTML 출력 코드
--%>				
				
<%
			//프로그래밍 조회 코드
			ProductDao productDao = new ProductDao();
			List<ProductDto>list = productDao.select();
%>
			
		<h1>상품 목록</h1>
<%for(ProductDto productDto : list){%>
	
	<table border = "1"> <%--border - 테이블의 테두리--%>
		<th>상품번호</th> <%-- <th> - 테이블 헤더 ?? 그런데 왜 노란색 경고가 뜰까요?--%>
		<th>상품이름</th>
		<th>상품분류</th>
		<th>상품가격</th>
		<th>제조일자</th>
		<th>유통기한</th>
		<tr><!-- 줄 시작 -->
			<td><%=productDto.getNo()%></td> <%-- <td>열을 만듬 --%>
  			<td><%=productDto.getName()%></td>
 			<td><%=productDto.getType()%></td>
 			<td><%=productDto.getPrice() %></td>
 			<td><%=productDto.getMadeDate()%></td>
 			<td><%=productDto.getExpireDate()%></td>	
		</tr>
</table>

<% } %>

</body>
</html>