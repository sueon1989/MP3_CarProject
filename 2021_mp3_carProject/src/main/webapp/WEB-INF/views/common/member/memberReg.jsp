<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
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
      
      
      
      
        <form role="form" action="/member/register" method="post" class="col-lg-6 col-md-8 col-10 mx-auto">
          <div class="mx-auto text-center my-4">
            <a class="navbar-brand mx-auto mt-2 flex-fill text-center" href="/">
 			<span>      
             	 <img src="/resources/light/assets/images/car_logo.png" alt="..." 
              		  class="img-rounded" width="50px" height="45px"></span>     
            </a>
            <h2 class="my-3">회원가입</h2>
          </div>

    
          <div class="form-group">
            <label for="input1">아이디</label>
            <input type="text" class="form-control" id="input1" name="member_id" value="user00001" required>
          </div>
          <div class="form-group">
            <label for="input2">비밀번호</label>
            <input type="password" class="form-control" id="input2" name="member_pass" value="1234" required>
          </div>
		  <div class="form-group">
            <label for="input3">이름</label>
            <input type="text" class="form-control" id="input3" name="member_name" value="김길동" required>
          </div>
		  <div class="form-group">
            <label for="input4">성별</label>
            <input type="text" class="form-control" id="input4" name="member_gender" value="남" required>
          </div>
		  <div class="form-group">
            <label for="input5">생년월일</label>
            <input type="date" class="form-control" id="input5" name="member_birth" value="2010-12-25" required>
          </div>
		  <div class="form-group">
            <label for="input6">전화번호</label>
            <input type="tel" class="form-control" id="input6" name="member_phone" value="010-1245-1231" required>
          </div>
		  <div class="form-group">
            <label for="input7">주소</label>
            <input type="text" class="form-control" id="input7" name="member_address" value="수원시" required>
          </div>
		  <div class="form-group">
            <label for="input8">메일</label>
            <input type="text" class="form-control" id="input8" name="member_mail" value="12aaa@mp3.com" required>
          </div>
		  <div class="form-group">
            <label for="input9">메일수신여부</label>
            <input type="text" class="form-control" id="input9" name="member_mailaccept" value="yes" required>
          </div>          
          
          <hr class="my-4">
          
          
          <button class="btn btn-lg btn-primary btn-block" type="submit">Sign up</button>
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