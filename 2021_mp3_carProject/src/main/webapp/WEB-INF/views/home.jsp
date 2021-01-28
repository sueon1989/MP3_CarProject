<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
        
<%@include file="./includes/header.jsp" %>
        <div class="container-fluid">
          <div class="row justify-content-center">
            <div class="col-12">




	<!-- 기본 화면 -->
   <h2></h2>
   <h2 class="mb-2 page-title">MIT Car Care Service</h2>
   <hr class="my-4">
   
	<!-- 로그인한 경우 -->
	<sec:authorize access="isAuthenticated()">
	<div class="col-lg-3 col-md-4 col-10 text-center">
	
		<%-- <p><sec:authentication property="principal.username"/> 님, 환영합니다!</p> --%>
       	<%-- <h5>로그인 정보</h5>
		<p>principal:	<sec:authentication property="principal"/></p>
		<p>MemberVO:	<sec:authentication property="principal.member"/></p>
		<p>사용자이름:	<sec:authentication property="principal.member.member_name"/></p> --%>
		<%-- <p>사용자PW:	<sec:authentication property="principal.member.member_pass"/></p>
		<p>사용자 권한 리스트:	<sec:authentication property="principal.member.authList"/></p>	
		<br>	 --%>
       	
	</div>
	</sec:authorize>
   
   	<!-- 날씨카드 -->
	<%@include file="/WEB-INF/views/common/weather/weatherCard.jsp" %> 


	<div class="mb-2 align-items-center">
	    <div class="card shadow mb-4">
	      <div class="card-body">
	        <div class="row mt-1 align-items-center">
	          <div class="col-12 col-lg-4 text-left pl-4">
	            <p class="mb-1 small text-muted">Balance</p>
	            <span class="h3">$12,600</span>
	            <span class="small text-muted">+20%</span>
	            <span class="fe fe-arrow-up text-success fe-12"></span>
	            <p class="text-muted mt-2"> Etiam ultricies nisi vel augue. Curabitur ullamcorper ultricies nisi. Nam eget dui </p>
	          </div>
	          <div class="col-6 col-lg-2 text-center py-4">
	            <p class="mb-1 small text-muted">Today</p>
	            <span class="h3">$2600</span><br>
	            <span class="small text-muted">+20%</span>
	            <span class="fe fe-arrow-up text-success fe-12"></span>
	          </div>
	          <div class="col-6 col-lg-2 text-center py-4 mb-2">
	            <p class="mb-1 small text-muted">Goal Value</p>
	            <span class="h3">$260</span><br>
	            <span class="small text-muted">+6%</span>
	            <span class="fe fe-arrow-up text-success fe-12"></span>
	          </div>
	          <div class="col-6 col-lg-2 text-center py-4">
	            <p class="mb-1 small text-muted">Completions</p>
	            <span class="h3">26</span><br>
	            <span class="small text-muted">+20%</span>
	            <span class="fe fe-arrow-up text-success fe-12"></span>
	          </div>
	          <div class="col-6 col-lg-2 text-center py-4">
	            <p class="mb-1 small text-muted">Conversion</p>
	            <span class="h3">6%</span><br>
	            <span class="small text-muted">-2%</span>
	            <span class="fe fe-arrow-down text-danger fe-12"></span>
	          </div>
	        </div>
	       <div class="chartbox mr-4">
	          <div id="areaChart"></div>
	        </div>
	      </div> <!-- .card-body -->
	    </div> <!-- .card -->
	</div>
	
	<!-- 로그인하지 않은 경우 -->
	<sec:authorize access="isAnonymous()">
   	<div class="mb-2 align-items-center">
       <div class="card shadow mb-4">
         <div class="card-body">
           <div class="mt-1 align-items-center">
              <div class="text-center">
              
              	<p class="mb-1 small text-muted">MIT Car Care Service </p>
				<span class="h3">회원가입 안내</span><br><br>
				<p>
					회원가입 후 자동차관리용 플러그를 신청하세요! 
					평균 주행거리, 연비 자동계산, 
					실시간 기상정보에 따른 차량점검 tip 등의 
					편리한 기능을 사용하실 수 있습니다! 
			    </p><br>
				<button class="btn mb-2 btn-outline-primary" type="button" style="width: 100pt;" onclick = "location.href = '/member/register'">회원가입</button>
				<button class="btn mb-2 btn-outline-primary" type="button" style="width: 100pt;" onclick = "location.href = '/customLogin'">로그인</button>
		        <button class="btn mb-2 btn-outline-primary" type="button" style="width: 100pt;" onclick = "location.href = '/memberFind/findIdInputMail'">아이디 찾기</button>	
		        <button class="btn mb-2 btn-outline-primary" type="button" style="width: 100pt;" onclick = "location.href = '/memberFind/findPassInputMail'">비밀번호 찾기</button>
              
              </div>
           </div> <!-- row mt-1 align-items-center -->
         </div> <!-- .card-body -->
       </div> <!-- .card -->
   	</div>
	</sec:authorize>
	
	
	<!-- 관리자로 로그인한 경우 -->
	<sec:authorize access="hasRole('ROLE_ADMIN')">
	<!-- <hr class="my-4">
	<form action="#" method='post' class="col-lg-3 col-md-4 col-10 text-center">
       	<h5>관리자</h5>
       	<button class="btn btn-lg btn-primary btn-block" type="button" onclick = "location.href = '/member/list'">회원관리</button>
    </form>  --> 	
	</sec:authorize>




            </div> <!-- .col-12 -->
          </div> <!-- .row -->
        </div> <!-- .container-fluid -->
<%@include file="./includes/footer.jsp" %>