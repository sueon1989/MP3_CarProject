<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
    

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
<link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">

	
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

 
<div class="wrapper vh-100">

     <div class="row align-items-center h-100">
     
             <form action="/findIdResultViewMail" method='post' class="col-lg-3 col-md-4 col-10 mx-auto text-center">
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
 
         <h1 class="h1 mb-3"><font size="15"> Find ID </font></h1>
         
         
        <div class="form-group">
           <label>Name</label>
           <input type="text" name='name'  
           	id="member_name" class="form-control form-control-lg" required>
         </div>
         <div class="form-group">
           <label>Email</label>
           <input type="text" name='email'  
           	id="member_mail" class="form-control form-control-lg" required>
         </div>
         
          <button type="submit" id=findBtn class="btn btn-lg btn-primary btn-block" >find</button>
         <button class="btn btn-lg btn-primary btn-block" type="button" onclick = "location.href = 'member/customLogin'">Login</button>
         <p class="mt-5 mb-3 text-muted">© 2021-</p>
         
		
	
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
    
   
	
  
  
</body>
</html>