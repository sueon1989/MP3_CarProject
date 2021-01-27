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
		            
	<h2 class="mb-2 page-title">추천 드라이브 코스</h2>
	<hr class="my-4">
	<div class="mb-2 align-items-center">
	    <div class="card shadow mb-4">
	      <div class="card-body">
	        <div class="row mt-1 align-items-center">
	        	<div class="text-center">
					<span class="h3">경기도 추천 드라이브 코스 </span><br /><br />
	           	 	<p>	</p>
		        	<img src="/resources/carManagementTip/drive0.png" alt="봄" width="80%"><br><br>
		        	<img src="/resources/carManagementTip/drive1.jpg" alt="봄" width="80%"><br><br>
		        	<img src="/resources/carManagementTip/drive2.jpg" alt="봄" width="80%"><br><br>
		        	<img src="/resources/carManagementTip/drive3.jpg" alt="봄" width="80%"><br><br>
		        	<img src="/resources/carManagementTip/drive4.jpg" alt="봄" width="80%"><br><br>
		        	<img src="/resources/carManagementTip/drive5.jpg" alt="봄" width="80%"><br><br>
		        	<button type="button" class="btn mb-2 btn-outline-info" onclick = "location.href = ''">전국 드라이브 코스 추천</button>
		        
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