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
      
      

      
        <form role="form" action="myCarUpdate" method="post" class="col-lg-6 col-md-8 col-10 mx-auto">
          <div class="mx-auto text-center my-4">
            <a class="navbar-brand mx-auto mt-2 flex-fill text-center" href="/">
 			<span>      
             	 <img src="/resources/light/assets/images/car_logo.png" alt="..." 
              		  class="img-rounded" width="50px" height="45px"></span>     
            </a>
           
            <h2 class="my-3">내 차량 정보 수정</h2>
          </div>
		  <div class="form-group">
            <label >제조사</label>
            <input type="text" class="form-control" id="car_company" name="car_company" value="${Mycarlist.car_company}" required>
          </div>
		  <div class="form-group">
            <label for="car_model">모델</label>
            <input type="text" class="form-control" id="car_model" name="car_model" value="${Mycarlist.car_model}" required>
          </div>
		  <div class="form-group">
            <label for="car_fual">연료</label>
            <input type="text" class="form-control" id="car_fual" name="car_fual" value=" ${Mycarlist.car_fual}"  required>
          </div>
		  <div class="form-group">
            <label for="car_model_year">차량 연식</label>
            <input type="date" class="form-control" id="car_model_year" name="car_model_year" value="${Mycarlist.car_model_year}"  required>
          </div>
          <div class="form-group">
            <label for="car_engineoilrp">엔진오일 교체 시기</label>
            <input type="text" class="form-control" id="car_engineoilrp" name="car_engineoilrp" value="${Mycarlist.car_engineoilrp}" required>
          </div>
      	  <div class="form-group">
            <label for="car_distancedriven">차량 주행거리</label>
            <input type="text" class="form-control" id="car_distancedriven" name="car_distancedriven" value="${Mycarlist.car_distancedriven}" required>
          </div>
         
          <div class="form-group">
           <input type="hidden" name="member_id"   id="member_id" value="<sec:authentication property="principal.member.member_id"/>"/>
          </div> 
          
      



          <hr class="my-4">
          
          
          <button class="btn btn-lg btn-primary btn-block" type="submit">수정하기</button>
          <p class="mt-5 mb-3 text-muted text-center">© 2020</p>	
          
			<!-- CSRF (Cross-site Request Forgery) 토큰: CSRF(사이트간 요청 위조) 방지 -->
			<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
			<%-- ${_csrf.parameterName}: 실제 브라우저에서는 "_csrf"라는 이름으로 처리됨 --%>
			
        </form>
                			Modal
                            <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                                <div class="modal-dialog">
                                    <div class="modal-content">
                                        <div class="modal-header">
                                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                                            <h4 class="modal-title" id="myModalLabel">처리완료</h4>
                                        </div>
                                        <div class="modal-body">
                                            완료 되었습니다.                            </div>
                                        <div class="modal-footer">
                                            <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                                        </div>
                                    </div>
                                    /.modal-content
                                </div>
                                /.modal-dialog
                            </div>
                            /.modal
        
        
        
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
      <script>  
$(document).ready(function(){
	var result =${carUpdate}; //result 값을 읽고 get타입으로 보내온
	console.log("값찍기"+result);  //크롬F12 console 클릭
	
	console.log("전"+history.state);
	checkModal(result);
	
	history.replaceState({},null,null);
	console.log("후"+history.state);
	
	function checkModal(result){
		

    	if(result == true ){
			$(".modal-body").html("등록 완료 되었습니다.");
			$("#myModal").modal("show");
		}else {
			$(".modal-body").html("다시 등록해 주세요.");
			$("#myModal").modal("show");
		}
   	}
 	
})
 </script> 
  </body>
</html>
</body>
</html>