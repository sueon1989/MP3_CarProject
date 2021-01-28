<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>


<%@include file="/WEB-INF/views/includes/header.jsp" %>  
        <div class="container-fluid">
          <div class="row justify-content-center">
            <div class="col-12">
              
              
              
              
	<!-- 기본 화면 -->
	<h2 class="mb-2 page-title">내 주변 실시간 기상 정보</h2>
	<hr class="my-4">
	
	<!-- 예보시각		(0200, 0500, 0800, 1100, 1400, 1700, 2000, 2300 (1일 8회)) -->
	<%-- <c:set var="baseTime" value="${weather.baseTime}"/> --%>
	<%-- 길이: ${fn:length(BaseTime) }	<br> --%> 
	
	<%@include file="/WEB-INF/views/common/weather/weatherCard.jsp" %> 

            </div> <!-- .col-12 -->
          </div> <!-- .row -->
        </div> <!-- .container-fluid -->
<%@include file="/WEB-INF/views/includes/footer.jsp" %>