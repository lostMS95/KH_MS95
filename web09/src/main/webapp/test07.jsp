<%@page import="java.util.List"%>
<%@page import="web09.beans.ProductDao"%>
<%@page import="web09.beans.ProductDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%-- 프로그래밍 코드 --%>

<%-- 입력 --%>    
<%
	String column = request.getParameter("column");
	String keyword = request.getParameter("keyword");
%>

<%-- 처리 --%>
<% 
	boolean search = column != null && keyword != null;
	
	ProductDao productDao = new ProductDao();
	List<ProductDto>list;
	if(search) {
		list = productDao.select(column, keyword);
	}
	else {
		list = productDao.select();
	}
%>

<%--화면 출력 --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 조회</title>
</head>
<body>
			
			<!-- 제목 -->
			<%if(search){ %>
			<h1>상품 검색</h1>
			<%}else{%>
			<h1>상품 목록</h1>
			<%}%>
			
			<!-- 검색창 -->
			<form action="test07.jsp">
				<fieldset>
					<legend>검색화면</legend>
						
						<select name = "column">
								<option value = "name">상품명</option>
								<option value = "type">상품유형</option>
						</select>
						
						<input type = "search" name = "keyword">
						
						<input type = "submit" value = "검색">
				
				</fieldset>
			</form>
			
			<!-- 결과 테이블 -->	
			<table border="1" width="600">
			<thead>
				<tr>
					<th>상품번호</th>
					<th>상품이름</th>	
					<th>상품유형</th>
					<th>상품가격</th>
					<th>제조일자</th>
					<th>유통기한</th>
					<th>메뉴</th>
				</tr>
			</thead>
			
			<!-- 테이블 데이터 -->
			<tbody align = "center">
			
				<%for(ProductDto productDto : list) {%>
				<tr>
					<td><%=productDto.getNo() %></td>
					<td><%=productDto.getName() %></td>
					<td><%=productDto.getType() %></td>
					<td><%=productDto.getPrice() %></td>
					<td><%=productDto.getMadeDate() %></td>
					<td><%=productDto.getExpireDate() %></td>
					<td><a href = "/web09/test10.jsp?no=<%=productDto.getNo() %>">상세조회</a></td>
				</tr>
				<%} %>
			
			</tbody>
	
		</table>
			
</body>
</html>