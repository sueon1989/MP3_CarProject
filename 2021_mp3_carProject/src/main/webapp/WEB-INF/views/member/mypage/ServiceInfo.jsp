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
	
		            
	<h2 class="mb-2 page-title">서비스 소개</h2>
	<hr class="my-4">
	<div class="mb-2 align-items-center">
	    <div class="card shadow mb-4">
	      <div class="card-body">
	        <div class="row mt-1 align-items-center">
	        	<div class="text-center">
					<span class="h3">MIT Car Care Service Information</span><br /><br />
	           	 	<p>차량 관리 시스템이란?</p>
		        	<img src="/resources/light/assets/images/ServiceInfo1.png" alt="" width="80%">
		        	<img src="/resources/light/assets/images/ServiceInfo2.png" alt="" width="80%"><br><br>
		        
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