<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
        
<%@include file="/WEB-INF/views/includes/header.jsp" %>
        <div class="container-fluid">
          <div class="row justify-content-center">
            <div class="col-12">

<div class="mb-2 align-items-center">
       <div class="card shadow mb-4">
         <div class="card-body">
           <div class="row mt-1 align-items-center">
           
             <div class="col-12 col-lg-4 text-left pl-4">


	   <!-- 기본 화면 -->
   <h2></h2>
   <h2 class="mb-2 page-title">위치 정보</h2>
   <hr class="my-4">

<body>
<p>
    <em>지금 현재 위치는<br>
     *${gpsadd} *</em>
</p>
 <button type="button" class="btn mb-2 btn-outline-info" onclick = "location.href = '/weather/weatherInfo'">날씨정보 보기</button>
</body>
            </div> <!-- .col-12 -->
          </div> <!-- .row -->
        </div> <!-- .container-fluid -->
<%@include file="/WEB-INF/views/includes/footer.jsp" %>