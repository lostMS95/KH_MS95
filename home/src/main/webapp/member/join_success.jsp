<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="/template/header.jsp"></jsp:include>
		
		<h1>회원가입 완료!</h1>
		
		<h4><a href = "login.jsp">로그인하기</a></h4>
		<h4><a href = "../index.jsp">메인페이지 보기</a></h4>
		
		<%-- <h4><a href="/home/member/login.jsp">로그인하기</a></h4>	
		<h4><a href="<%=request.getContextPath() %>/member/login.jsp">로그인하기</a></h4>	
		<h4><a href="../index.jsp">메인페이지 보기</a></h4>
		<h4><a href="../">메인페이지 보기</a></h4>
		<h4><a href="<%=request.getContextPath()%>/index.jsp">메인페이지 보기</a></h4>
		<h4><a href="<%=request.getContextPath()%>">메인페이지 보기</a></h4> --%>

<jsp:include page="/template/footer.jsp"></jsp:include>