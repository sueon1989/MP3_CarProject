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
	
		            
	<h2 class="mb-2 page-title">계절별 차량관리 Tip</h2>
	<hr class="my-4">
	<div class="mb-2 align-items-center">
	    <div class="card shadow mb-4">
	      <div class="card-body">
	        <div class="row mt-1 align-items-center">
	        	<div class="text-center">
					<span class="h3">봄 맞이 차량점검 체크리스트</span><br /><br />
	           	 	<p>겨울동안 추위와 눈, 비로 고생했던 내 차를 위한 봄맞이 차량 점검!
					아래 체크리스트에서 관리가 필요한 항목들을 체크해보고 꼭 점검해보세요!</p>
		        	<img src="/resources/carManagementTip/springChecklist.png" alt="봄" width="80%">
		        	<img src="/resources/carManagementTip/springTip1.png" alt="봄" width="80%">
		        	<img src="/resources/carManagementTip/springTip2.png" alt="봄" width="80%">
		        	<img src="/resources/carManagementTip/springTip3.png" alt="봄" width="80%">
		        	<img src="/resources/carManagementTip/springTip4.png" alt="봄" width="80%"><br><br>
		        	<button type="button" class="btn mb-2 btn-outline-info" onclick = "location.href = '/weather/weatherInfo'">실시간 날씨별 차량점검 tip 확인하기</button>
		        
		        </div>
	        </div> <!-- row mt-1 align-items-center -->
	      </div> <!-- .card-body -->
	    </div> <!-- .card -->
	</div>
	
	<!-- 로그인하지 않은 경우 -->
	<sec:authorize access="isAnonymous()">

	</sec:authorize>
	
	
	<!-- 로그인한 경우 -->
	<sec:authorize access="isAuthenticated()">
	 
	</sec:authorize>




            </div> <!-- .col-12 -->
          </div> <!-- .row -->
        </div> <!-- .container-fluid -->
<%@include file="/WEB-INF/views/includes/footer.jsp" %>