<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%--
	디렉티브(directive)
	= 설정을 하고 싶을 때 사용
	= 형식은 <%@ 설정 %>
	
	스크립트릿(scriptlet) : 
	= 프로그래밍 코드를 작성하고 싶을때 사용.
	= 형식은 <%  코드  %>
	
	표현식 : 프로그래밍 값을 출력하고 싶을 때 사용.
 	= 형식은 <%= 값 %>
 --%>

<%for(int i=1; i<=10 ; i++){ %>
   <h1>Hello JSP <%=i%></h1>
<%}%>
 
 