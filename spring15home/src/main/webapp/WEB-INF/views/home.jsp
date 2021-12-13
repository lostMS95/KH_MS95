<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>
            
<div class="container-600 container-center">
    <div class="row center">
        <h1>내가 만든 홈페이지</h1>
    </div>
    <div class="row">
        <img src="${pageContext.request.contextPath}/resources/image/kh_main.jpg" width="100%">
    </div>
</div>

<c:if test="${cookie.popup == null}">

<div class="popup">팝업</div>
</c:if>
<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>