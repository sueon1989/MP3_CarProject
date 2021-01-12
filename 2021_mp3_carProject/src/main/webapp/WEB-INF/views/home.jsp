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
	<h2 class="mb-2 page-title">Main Page</h2>
	<hr class="my-4">
	
	<!-- 로그인하지 않은 경우 -->
	<sec:authorize access="isAnonymous()">
		        <a href="/customLogin">로그인</a><br>
		        <a href="/member/register">회원가입</a><br>
				<a href="/memberFind/findIdInputMail">메일</a> / 
				<a href="/memberFind/findIdInputPhone">전화번호</a>로 ID 찾기<br>
				<a href="/memberFind/findPassInputMail">메일</a> / 
				<a href="/memberFind/findPassInputPhone">전화번호</a>로 PW 찾기<br>
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