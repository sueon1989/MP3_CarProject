<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
        
<%@include file="./includes/header.jsp" %>
        <div class="container-fluid">
          <div class="row justify-content-center">
            <div class="col-12">

				<div>
				     <div class="row align-items-center h-100">
				     	<form action="/customLogout" method='post' class="col-lg-3 col-md-4 col-10 mx-auto text-center">
						
              
              
              
	<!-- 기본 화면 -->
	<h2></h2>
	<h2 class="mb-2 page-title">Main Page</h2>
	<hr class="my-4">
	
	<!-- 로그인하지 않은 경우 -->
	<sec:authorize access="isAnonymous()">
	
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
                       <span class="h3">$2600</span><br />
                       <span class="small text-muted">+20%</span>
                       <span class="fe fe-arrow-up text-success fe-12"></span>
                     </div>
                     <div class="col-6 col-lg-2 text-center py-4 mb-2">
                       <p class="mb-1 small text-muted">Goal Value</p>
                       <span class="h3">$260</span><br />
                       <span class="small text-muted">+6%</span>
                       <span class="fe fe-arrow-up text-success fe-12"></span>
                     </div>
                     <div class="col-6 col-lg-2 text-center py-4">
                       <p class="mb-1 small text-muted">Completions</p>
                       <span class="h3">26</span><br />
                       <span class="small text-muted">+20%</span>
                       <span class="fe fe-arrow-up text-success fe-12"></span>
                     </div>
                     <div class="col-6 col-lg-2 text-center py-4">
                       <p class="mb-1 small text-muted">Conversion</p>
                       <span class="h3">6%</span><br />
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

		<button class="btn btn-lg btn-primary btn-block" type="button" onclick = "location.href = '/customLogin'">Login</button>
		<button class="btn btn-lg btn-primary btn-block" type="button" onclick = "location.href = '/member/register'">Sign Up</button>
        <button class="btn btn-lg btn-primary btn-block" type="button" onclick = "location.href = '/memberFind/findIdInputMail'">Find ID</button>	
        <button class="btn btn-lg btn-primary btn-block" type="button" onclick = "location.href = '/memberFind/findPassInputMail'">Find PW</button>
				
	</sec:authorize>
	
	
	<!-- 로그인한 경우 -->
	<sec:authorize access="isAuthenticated()">
	
       	<h5>로그인 정보</h5>
		<p>principal:	<sec:authentication property="principal"/></p>
		<p>MemberVO:	<sec:authentication property="principal.member"/></p>
		<p>사용자이름:	<sec:authentication property="principal.member.member_name"/></p>
		<p>사용자ID: 	<sec:authentication property="principal.username"/></p>
		<p>사용자PW:	<sec:authentication property="principal.member.member_pass"/></p>
		<p>사용자 권한 리스트:	<sec:authentication property="principal.member.authList"/></p>	
		<br>	
       	
		<button class="btn btn-lg btn-primary btn-block">로그아웃</button>
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
			
	</sec:authorize>
	
	
	<!-- 관리자로 로그인한 경우 -->
	<sec:authorize access="hasRole('ROLE_ADMIN')">
		<hr class="my-4">
        <div>
        	<h5>관리자</h5>
        	<button class="btn btn-lg btn-primary btn-block" type="button" onclick = "location.href = '/sample/admin'">회원관리</button>
        </div>
	</sec:authorize>



						</form>
					</div> <!-- wrapper vh-100 -->
		     	</div> <!-- row align-items-center -->
		     	
            </div> <!-- .col-12 -->
          </div> <!-- .row -->
        </div> <!-- .container-fluid -->
<%@include file="./includes/footer.jsp" %>