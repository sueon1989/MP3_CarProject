<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
     <%@include file="/WEB-INF/views/includes/header.jsp" %>   
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
  
  
  
  
        	<!-- 로그인하지 않은 경우 -->
	<sec:authorize access="isAnonymous()">
		        <a href="/customLogin">로그인후이용하세요</a><br>
				<a href="/member/register">회원이 아닌경우 회원가입으로</a> <br>
	</sec:authorize>
	

      
      

      
   <sec:authorize access="isAuthenticated()">
		    <hr class="my-4"> 
              <h2 class="mb-2 page-title"></h2>
              <div class="row my-4">
            
                <div class="col-md-12">
                  <div class="card shadow">
                    <div class="card-body">
                     
                      <table class="table datatables" id="dataTable-1">
                        <thead>
      
      
       <form role="form" action="carReg1_company" method="post" class="col-lg-6 col-md-8 col-10 mx-auto">
          <div class="mx-auto text-center my-4">
            <a class="navbar-brand mx-auto mt-2 flex-fill text-center" href="/">
 			<span>      
             	 <img src="/resources/light/assets/images/car_logo.png" alt="..." 
              		  class="img-rounded" width="50px" height="45px"></span>     
            </a>
            <h2 class="my-3">차량 등록</h2>
          </div>
	
	    
	      <div class="form-group">
	       <p><label for="car_company">제조사 :</label>
	        <select name = "car_company" id="car_company" onchange="firstChange(this.form);">
	            <option value="">제조사를 선택 하세요</option> 
	            <option value="현대">현대</option>
	            <option value="기아">기아</option>
	            <option value="쉐보레">쉐보레</option>
	            <option value="르노삼성">르노삼성</option>
	            <option value="쌍용자동차">쌍용자동차</option>
	        </select></p>
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
	          

	 <div class="form-group">
	       <p><label for="car_model">연료 :</label>
	        <select name = "car_fual" id="car_fual" onchange="firstChange(this.form);">
	            <option value="">차량 연료를 선택 하세요</option> 
	            <option value="가솔린">가솔린</option>
	            <option value="고급 가솔린">고급 가솔린</option>
	            <option value="디젤">디젤</option>
	            <option value="전기">전기</option>
	            <option value="하이브리드">하이브리드</option>
	        </select></p>
	       </div>
                
          <div class="form-group">
            <label for="car_model_year">차량 연식</label>
            <input type="date" class="form-control" id=car_model_year 
            name="car_model_year"  required>
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
          
          <div class="form-group">
           <input type="hidden" name="member_id"   id="member_id" value="<sec:authentication property="principal.member.member_id"/>"/>
          </div> 
          
          <button class="btn btn-lg btn-primary btn-block" type="submit">완료</button>
          <p class="mt-5 mb-3 text-muted text-center">© 2020</p>	
          
			<!-- CSRF (Cross-site Request Forgery) 토큰: CSRF(사이트간 요청 위조) 방지 -->
			<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
			<%-- ${_csrf.parameterName}: 실제 브라우저에서는 "_csrf"라는 이름으로 처리됨 --%>
			
        </form>
        
   </sec:authorize>     
       <!-- 관리자로 로그인한 경우 -->
	<sec:authorize access="hasRole('ROLE_ADMIN')">
				<hr class="my-4">
		        <div class="form-group">
		        	<h5>관리자</h5>
		        </div>
              	<a href="/sample/admin">회원관리</a>
	</sec:authorize>
        			<!-- Modal -->
                            <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                                <div class="modal-dialog">
                                    <div class="modal-content">
                                        <div class="modal-header">
                                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                                            <h4 class="modal-title" id="myModalLabel">처리완료</h4>
                                        </div>
                                        <div class="modal-body">
                                            처리 완료 되었습니다.                            </div>
                                        <div class="modal-footer">
                                            <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                                        </div>
                                    </div>
                                    <!-- /.modal-content -->
                                </div>
                                <!-- /.modal-dialog -->
                            </div>
                            <!-- /.modal -->
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
    <%@include file="/WEB-INF/views/includes/footer.jsp" %>    
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
	var result =${Mycar}; //result 값을 읽고 get타입으로 보내온
	console.log("값찍기"+result);  //크롬F12 console 클릭
	
	console.log("전"+history.state);
	checkModal(result);
	
	history.replaceState({},null,null);
	console.log("후"+history.state);
	
	function checkModal(result){
		
//     	if(result == ''){ //뒤로 가기가 아닐때
//     	  		return;
//       	}
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