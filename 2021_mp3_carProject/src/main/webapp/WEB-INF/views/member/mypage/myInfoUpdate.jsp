<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>

<!DOCTYPE html>
<html lang="kr">
  <head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="favicon.ico">
    <title>회원가입</title>
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
  <body class="light ">
    <div class="wrapper vh-100">
      <div class="row align-items-center h-100">
      
      
      
      
        <form role="form" action="/mypage/myInfoUpdatePassCheck" method="post" class="col-lg-6 col-md-8 col-10 mx-auto">
          <div class="mx-auto text-center my-4">
            <a class="navbar-brand mx-auto mt-2 flex-fill text-center" href="/">
 			<span>      
             	 <img src="/resources/light/assets/images/car_logo.png" alt="..." 
              		  class="img-rounded" width="50px" height="45px"></span>     
            </a>
            <h2 class="my-3">회원 정보 수정</h2>
          </div>

    
<!--           <div class="form-group"> -->
<!--             <label for="input1">아이디</label> -->
<%--             <input type="text" class="form-control" id="member_id" name="member_id" value="${member.member_id}" required> --%>
<!--           </div> -->
<!--           <div class="form-group"> -->
<!--             <label for="input2">비밀번호</label> -->
<!--             <input type="password" class="form-control" id="member_pass" name="member_pass" value="" required> -->
<!--           </div> -->
		  <div class="form-group">
            <label for="input3">이름</label>
            <input type="text" class="form-control" id="member_name" name="member_name" value="<sec:authentication property="principal.member.member_name"/>" required>
          </div>
		  <div class="form-group">
            <label for="input4">성별</label>
            <input type="text" class="form-control" id="member_gender" name="member_gender" value="<sec:authentication property="principal.member.member_gender"/>" required>
          </div>
<!-- 		  <div class="form-group"> -->
<!--             <label for="input5">생년월일</label> -->
<%--             <input type="date" class="form-control" id="input5" name="member_birth" value="${member.member_birth}" required> --%>
<!--           </div> -->
		  <div class="form-group">
            <label for="input6">전화번호</label>
            <input type="text" class="form-control" id="member_phone" name="member_phone" value="<sec:authentication property="principal.member.member_phone"/>" required>
          </div>
		  <div class="form-group">
            <label for="input7">주소</label>
            <input type="text" class="form-control" id="member_address" name="member_address" value="<sec:authentication property="principal.member.member_address"/>" required>
          </div>
		  <div class="form-group">
            <label for="input8">메일</label>
            <input type="text" class="form-control" id="member_mail" name="member_mail" value="<sec:authentication property="principal.member.member_mail"/>" required>
          </div>
		  <div class="form-group">
            <label for="input9">메일수신여부</label>
            <input type="text" class="form-control" id="member_mailaccept" name="member_mailaccept" value="<sec:authentication property="principal.member.member_mailaccept"/>" required>
          </div>          
         
          <input type="hidden" name="member_no"   id="member_no"  value="<sec:authentication property="principal.member.member_no"/>"/>
         
          <hr class="my-4">
          
          
          <button class="btn btn-lg btn-primary btn-block" type="submit">수정하기</button>
          <p class="mt-5 mb-3 text-muted text-center">© 2020</p>	
          
			<!-- CSRF (Cross-site Request Forgery) 토큰: CSRF(사이트간 요청 위조) 방지 -->
			<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
			<%-- ${_csrf.parameterName}: 실제 브라우저에서는 "_csrf"라는 이름으로 처리됨 --%>
			
        </form>
        
        
        
        
      </div>
    </div>
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
  </body>
</html>
</body>
</html>