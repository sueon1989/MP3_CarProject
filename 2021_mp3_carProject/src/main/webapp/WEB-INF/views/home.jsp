<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
        
<%@include file="./includes/header.jsp" %>

<!--head 추가 -->
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="favicon.ico">
    <title>Tiny Dashboard - A Bootstrap Dashboard Template</title>
    <!-- Simple bar CSS -->
    <link rel="stylesheet" href="css/simplebar.css">
    <!-- Fonts CSS -->
    <link href="https://fonts.googleapis.com/css2?family=Overpass:ital,wght@0,100;0,200;0,300;0,400;0,600;0,700;0,800;0,900;1,100;1,200;1,300;1,400;1,600;1,700;1,800;1,900&display=swap" rel="stylesheet">
    <!-- Icons CSS -->
    <link rel="stylesheet" href="css/feather.css">
    <link rel="stylesheet" href="css/select2.css">
    <link rel="stylesheet" href="css/dropzone.css">
    <link rel="stylesheet" href="css/uppy.min.css">
    <link rel="stylesheet" href="css/jquery.steps.css">
    <link rel="stylesheet" href="css/jquery.timepicker.css">
    <link rel="stylesheet" href="css/quill.snow.css">
    <!-- Date Range Picker CSS -->
    <link rel="stylesheet" href="css/daterangepicker.css">
    <!-- App CSS -->
    <link rel="stylesheet" href="css/app-light.css" id="lightTheme">
    <link rel="stylesheet" href="css/app-dark.css" id="darkTheme" disabled>
  </head>
  
<!-- head  추가 끝 -->
  
  
        <div class="container-fluid">
          <div class="row justify-content-center">
            <div class="col-12">
              
              
              
              
	<!-- 기본 화면 -->
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
	
		        <a href="/customLogin">로그인</a><br>
		        <a href="/member/register">회원가입</a><br>
				<a href="/memberFind/findIdInputMail">메일로 ID 찾기</a> / 
				<a href="/memberFind/findIdInputPhone">전화번호로 ID 찾기</a><br>
				<a href="/memberFind/findPassInputMail">메일로 PW 찾기</a> / 
				<a href="/memberFind/findPassInputPhone">전화번호로 PW 찾기</a><br>
				
				
	</sec:authorize>
	
	
	<!-- 로그인한 경우 -->
	<sec:authorize access="isAuthenticated()">
		        <div class="form-group">
		        	<h5>로그인 정보</h5>
					<p>principal:	<sec:authentication property="principal"/></p>
					<p>MemberVO:	<sec:authentication property="principal.member"/></p>
					<p>사용자이름:	<sec:authentication property="principal.member.member_name"/></p>
					<p>사용자ID: 	<sec:authentication property="principal.username"/></p>
					<p>사용자PW:	<sec:authentication property="principal.member.member_pass"/></p>
					<p>사용자 권한 리스트:	<sec:authentication property="principal.member.authList"/></p>				
		        </div>
		        <a href="/customLogout">로그아웃</a>
	</sec:authorize>
	
	
	<!-- 관리자로 로그인한 경우 -->
	<sec:authorize access="hasRole('ROLE_ADMIN')">
				<hr class="my-4">
		        <div class="form-group">
		        	<h5>관리자</h5>
		        </div>
              	<a href="/sample/admin">회원관리</a>
	</sec:authorize>



            </div> <!-- .col-12 -->
          </div> <!-- .row -->
        </div> <!-- .container-fluid -->
<%@include file="./includes/footer.jsp" %>