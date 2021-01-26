<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
        
<%@include file="./includes/header.jsp" %>
        <div class="container-fluid">
          <div class="row justify-content-center">
            <div class="col-12">
            
   
<!-- <div class="wrapper vh-100">
     <div class="row align-items-center h-100"> -->
     
       <form action="/login" method='post' class="col-lg-3 col-md-4 col-10 text-center">
         <a class="navbar-brand mx-auto mt-2 flex-fill text-center" href="/">
			<span>      
	              <img src="/resources/light/assets/images/car_logo.png" alt="..." 
	              class="img-rounded" width="35px" height="30px"></span>
	        <span>      
	              <img src="/resources/light/assets/images/car_logo.png" alt="..." 
	              class="img-rounded" width="40px" height="35px"></span>
	        <span>      
	              <img src="/resources/light/assets/images/car_logo.png" alt="..." 
	              class="img-rounded" width="45px" height="40px"></span>     
         </a>
 
         
         
         
		<h1> Logout </h1>
				
		<form action="/customLogout" method='post'>
			<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
	        <button class="btn btn-lg btn-primary btn-block">로그아웃</button>
		</form>
<!--        
     </div>
</div> -->


            </div> <!-- .col-12 -->
          </div> <!-- .row -->
        </div> <!-- .container-fluid -->
<%@include file="./includes/footer.jsp" %>