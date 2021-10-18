<%@page import="web09.beans.ProductDto"%>
<%@page import="web09.beans.ProductDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	int no = Integer.parseInt(request.getParameter("no"));
	
	ProductDao productDao = new ProductDao();
	ProductDto productDto = productDao.select(no);
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
				
				<h1>시험 상세 조회</h1>
				
				<table border="1">
				<thead>
					<tr>
						<th>상품번호</th>
						<th>상품이름</th>
						<th>상품유형</th>
						<th>상품가격</th>
						<th>제조일자</th>
						<th>유통기한</th>
					</tr>
				</thead>
				
				<tbody>
					<tr>
						<td><%=productDto.getNo() %></td>
					<td><%=productDto.getName() %></td>
					<td><%=productDto.getType() %></td>
					<td><%=productDto.getPrice() %></td>
					<td><%=productDto.getMadeDate() %></td>
					<td><%=productDto.getExpireDate() %></td>
					</tr>
				
				</tbody>
		
			</table>
		
		<br><br>
			<a href ="test07.jsp">목록보기</a>

</body>
</html>