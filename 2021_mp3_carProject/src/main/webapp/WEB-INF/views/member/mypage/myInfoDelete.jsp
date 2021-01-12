<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
        
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="favicon.ico">
	<title>MIT Car Project</title>
	
    <!-- Simple bar CSS -->
    <link rel="stylesheet" href="/resources/light/css/simplebar.css">
    
    <!-- Fonts CSS -->
    <link href="https://fonts.googleapis.com/css2?family=Overpass:ital,wght@0,100;0,200;0,300;0,400;0,600;0,700;0,800;0,900;1,100;1,200;1,300;1,400;1,600;1,700;1,800;1,900&display=swap" rel="stylesheet">
    
    <!-- Icons CSS -->
    <link rel="stylesheet" href="/resources/light/css/feather.css">
    
    <!-- Date Range Picker CSS -->
    <link rel="stylesheet" href="/resources/light/css/daterangepicker.css">
    
    <!-- App CSS -->
    <link rel="stylesheet" href="/resources/light/css/app-light.css" id="lightTheme">
    <link rel="stylesheet" href="/resources/light/css/app-dark.css" id="darkTheme" disabled>
    
</head>


<%-- <h1>Custom Login Page</h1>

<h2>${error}</h2>
<h2>${logout}</h2>
  
<h2><c:out value="${error}"/></h2>
<h2><c:out value="${logout}"/></h2> --%>

<body>
<div class="wrapper vh-100">
     <div class="row align-items-center h-100">
     
       <form action="/mypage/myInfoDeletePassCheck" method='post' class="col-lg-3 col-md-4 col-10 mx-auto text-center">
         <a class="navbar-brand mx-auto mt-2 flex-fill text-center" href="/">
<!--            <svg version="1.1" id="logo" class="navbar-brand-img brand-md" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" x="0px" y="0px" viewBox="0 0 120 120" xml:space="preserve"> -->
<!--              <g> -->
<!--                <polygon class="st0" points="78,105 15,105 24,87 87,87 	" /> -->
<!--                <polygon class="st0" points="96,69 33,69 42,51 105,51 	" /> -->
<!--                <polygon class="st0" points="78,33 15,33 24,15 87,15 	" /> -->
<!--              </g> -->
<!--            </svg> -->
		
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
         
         
    <!-- 로그인하지 않은 경우 -->
	<sec:authorize access="isAnonymous()">
				<br>
		        <a href="/customLogin">로그인</a><br>
		        <a href="/member/register">회원가입</a><br>
				<a href="/memberFind/findIdInputMail">메일</a> / 
				<a href="/memberFind/findIdInputPhone">전화번호</a>로 ID 찾기<br>
				<a href="/memberFind/findPassInputMail">메일</a> / 
				<a href="/memberFind/findPassInputPhone">전화번호</a>로 PW 찾기<br>
	</sec:authorize>
         
         
 
 	<!-- 로그인한 경우 -->
	<sec:authorize access="isAuthenticated()">        
         <h1 class="h1 mb-3"><font size="5"> 비밀번호 확인 </font></h1>
         
         
         <div class="form-group">
           <input type="password" name='Deletenum' value='' 
           	id="Deletenum" class="form-control form-control-lg" class="form-control" placeholder="비밀번호 입력" required="" autofocus="">
		   <a href="/mypage/myInfoDeletePassCheck" class="btn btn-lg btn-success btn-block">비밀번호 확인</a> 
	       <input type="hidden" name="Deletenum1"  id="Deletenum1"  value="<sec:authentication property="principal.member.member_pass"/>"/>
		   <input type="hidden" name="member_no"   id="member_no"  value="<sec:authentication property="principal.member.member_no"/>"/>
		   <input type="hidden" name="member_id"   id="member_id"  value="<sec:authentication property="principal.member.member_id"/>"/>
           </div>
 		 
		 <p class="mt-5 mb-3 text-muted">비밀번호 확인 입력시 회원정보가 사라집니다.</p>
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />


       </form>
    </sec:authorize>
     </div>
</div>
         
         
         <!-- 관리자로 로그인한 경우 -->
	<sec:authorize access="hasRole('ROLE_ADMIN')">
				관리자는 탈퇴 안됨 또는 구현준비중
	</sec:authorize>
         
         
    
    <script src="/resources/light/js/jquery.min.js"></script>
    <script src="/resources/light/js/popper.min.js"></script>
    <script src="/resources/light/js/moment.min.js"></script>
    <script src="/resources/light/js/bootstrap.min.js"></script>
    <script src="/resources/light/js/simplebar.min.js"></script>
    <script src='/resources/light/js/daterangepicker.js'></script>
    <script src='/resources/light/js/jquery.stickOnScroll.js'></script>
    <script src="/resources/light/js/tinycolor-min.js"></script>
    <script src="/resources/light/js/config.js"></script>
    <script src="/resources/light/js/apps.js"></script>
    <script src='/resources/light/js/jquery.dataTables.min.js'></script>
    <script src='/resources/light/js/dataTables.bootstrap4.min.js'></script>
    
    <!-- Global site tag (gtag.js) - Google Analytics -->
    <!-- <script async src="https://www.googletagmanager.com/gtag/js?id=UA-56159088-1"></script>
    <script>
      window.dataLayer = window.dataLayer || [];

      function gtag()
      {
        dataLayer.push(arguments);
      }
      gtag('js', new Date());
      gtag('config', 'UA-56159088-1');
    </script> -->
    
	<script>
	  $(".btn-success").on("click", function(e){
	    
	    e.preventDefault();
	    $("form").submit();
	    
	  });
	</script>
  
  
</body>
</html>






