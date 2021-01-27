<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
    

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
<body>

<%-- <h1>Custom Login Page</h1>

<h2>${error}</h2>
<h2>${logout}</h2>
  
<h2><c:out value="${error}"/></h2>
<h2><c:out value="${logout}"/></h2> --%>


<div class="wrapper vh-100">
     <div class="row align-items-center h-100">
     
       <form action="/login" method='post' class="col-lg-3 col-md-4 col-10 mx-auto text-center">
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
 
         
         <h1 class="h1 mb-3"><font size="15"> Login </font></h1>
         
			<p>
				<c:out value="${error}"/>
				<c:out value="${logout}"/>
			</p>
         
         <div class="form-group">
           <label for="inputID" class="sr-only">username</label>
           <input type="text" name='username' 
           	id="inputID" class="form-control form-control-lg" placeholder="ID" required="" autofocus="">
         </div>
         <div class="form-group">
           <label for="inputPassword" class="sr-only">password</label>
           <input type="password" name='password' 
           	id="inputPassword" class="form-control form-control-lg" placeholder="PW" required="">
         </div>
         <div class="checkbox mb-3">
           <label><input type="checkbox" name="remember-me" id="remember-me"> Remember Me </label>
         </div>
         <!-- Change this to a button or input when using this as a form -->
         <!--  <button class="btn btn-lg btn-primary btn-block" type="submit">Login</button><br> -->
		 <a href="/member/get?member_id=user2001" class="btn btn-lg btn-success btn-block">Login</a>
         <button class="btn btn-lg btn-primary btn-block" type="button" onclick = "location.href = 'member/findIdInput'">Find ID</button>
         <button class="btn btn-lg btn-primary btn-block" type="button" onclick = "location.href = 'member/findPassInput'">Find PW</button>
         <button class="btn btn-lg btn-primary btn-block" type="button" onclick = "location.href = 'member/register'">Sign Up</button>
         <p class="mt-5 mb-3 text-muted">© 2021-</p>
         
		
	<!-- CSRF (Cross-site Request Forgery) 토큰: CSRF(사이트간 요청 위조) 방지 -->
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
		<%-- ${_csrf.parameterName}: 실제 브라우저에서는 "_csrf"라는 이름으로 처리됨 --%>
	<!-- 페이지 소스 보기: 
		강제로 세션 쿠키를 삭제한 후에 "/customLogin"을 다시 호출했을 때 CSRF 토큰의 값이 변경된 것 확인
		<input type="hidden" name="_csrf" value="c9c2f8c9-b49b-4faf-87ef-46e973c8cffd" /> 
		<input type="hidden" name="_csrf" value="3c446b1b-6e93-4c9f-b3de-3146d1757c3c" />  -->

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

