<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
  <head>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.0.0/jquery.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-modal/0.9.1/jquery.modal.min.js"></script>
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/jquery-modal/0.9.1/jquery.modal.min.css" />
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="favicon.ico">
    <title>차량 등록</title>
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
      
      
      
      
       <form role="form" action="/carReg1_company2" method="post" class="col-lg-6 col-md-8 col-10 mx-auto">
          <div class="mx-auto text-center my-4">
            <a class="navbar-brand mx-auto mt-2 flex-fill text-center" href="/">
 			<span>      
             	 <img src="/resources/light/assets/images/car_logo.png" alt="..." 
              		  class="img-rounded" width="50px" height="45px"></span>     
            </a>
            <h2 class="my-3">내 차량 목록</h2>
          </div>
	
	   
	       </p>
	      <div class="form-group">
	       <p><label for="car_company">제조사 : ${carRegistrationVO.car_company}</label>
	                 
	       </p>
	       </div>
	       
	      <div class="form-group">
	       <p><label for="car_model">모델 :</label>
	        <select name = "car_model" id="car_model" onchange="firstChange(this.form);">
	            <option value="">차량 모델을 선택 하세요</option> 
	            <option value="현대">모닝</option>
	            <option value="기아">스파크</option>
	            <option value="쉐보레">벨로스터</option>
	        </select></p>
	       </div>
	          
	        <div class="form-group"> <p>             
	        <label for="car_fual">연료 : </label>
	        <input type="checkbox" name="genre" id="car_fual" value="가솔린">가솔린
	        <input type="checkbox" name="genre" id="car_fual" value="디젤">디젤
	        <input type="checkbox" name="genre" id="car_fual" value="전기">전기
	        </p></div>
                
          <div class="form-group">
            <label for="car_model_year">차량 연식</label>
            <input type="month" class="form-control" id=car_model_year 
            name="car_model_year" value="0000-00" required>
          </div>


          <div class="form-group">
	       <p><label for="car_engineoilrp">엔진오일 교체 시기 :</label>
	        <select name = "car_engineoilrp" id="car_engineoilrp" onchange="firstChange(this.form);">
	            <option value="">엔진오일 교체 시기를 선택 하세요</option> 
	            <option value="현대">1개월 이내</option>
	            <option value="현대">1 ~ 3개월</option>
	            <option value="기아">4 ~ 6개월</option>
	            <option value="쉐보레">6개월 이상</option>
	            <option value="쉐보레">잘 모르겠어요</option>
	            
	        </select></p>
	       </div>
		  
		  <div class="form-group">
            <label for="car_distancedriven">차량 주행거리</label>
            <input type="text" class="form-control" id="car_distancedriven" 
            name="car_distancedriven" value="0000Km" required>
          </div> 
          
          <button class="btn btn-lg btn-primary btn-block" type="submit">완료</button>
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