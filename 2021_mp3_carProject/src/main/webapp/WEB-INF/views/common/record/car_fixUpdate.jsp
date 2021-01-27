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
      
      
       <form role="form" action="car_fix" method="post" class="col-lg-6 col-md-8 col-10 mx-auto">
          <div class="mx-auto text-center my-4">
            <a class="navbar-brand mx-auto mt-2 flex-fill text-center" href="/">
 			<span>      
             	 <img src="/resources/light/assets/images/car_logo.png" alt="..." 
              		  class="img-rounded" width="50px" height="45px"></span>     
            </a>
            <h2 class="my-3">정비 / 기타</h2>
          </div>
       
          <div class="form-group">
	       <p><label for="repair">정비 목록</label>
	        <select name = "repair" id="repair" onchange="firstChange(this.form);">
	            <option value="">"${car_fixUpdate.repair}"</option> 
	            <option value="엔진오일 및 오일필터">엔진오일 및 오일필터</option>
	            <option value="에어컨필터(향균필터)">에어컨필터(향균필터)</option>
	            <option value="와이퍼 블레이드">와이퍼 블레이드</option>
	            <option value="구동벨트">구동벨트</option>
	            <option value="미션오일">미션오일</option>
	            <option value="배터리">배터리</option>
	            <option value="보증수리">보증수리</option>
	            <option value="브레이크 오일">브레이크 오일</option>
	            <option value="브레이크 패드 및 디스크">브레이크 패드 및 디스크</option>
	            <option value="에어클리너 필터">에어클리너 필터</option>
	            <option value="엔진 부동액(냉각수)">엔진 부동액(냉각수)</option>
	            <option value="연료 필터">연료 필터</option>
	            <option value="외장수리복원">외장수리복원</option>
	            <option value="일반 수리">일반 수리</option>
	            <option value="점화 플러그">점화 플러그</option>
	            <option value="타이밍 벨트">타이밍 벨트</option>
	            <option value="타이어">타이어</option>
	            <option value="타이어 위치 교환">타이어 위치 교환</option>
	            <option value="타이어 펑크 수리">타이어 펑크 수리</option>
	            <option value="파워 스티어링 오일">파워 스티어링 오일</option>
	            <option value="휠 얼라인먼트">휠 얼라인먼트</option>
	            <option value="기타">기타</option>	            
	        </select></p>
	       </div>
          
          <div class="form-group">
            <label for="repair_date">정비 일자</label>
            <input type="date" class="form-control" id=repair_date 
            name="repair_date"  required>
          </div>
          
          
          <div class="form-group">
            <label for="amount">정비 / 기타 비용</label>
            <input type="text" class="form-control" id="amount" 
            name="amount" value="${car_fixUpdate.setAmount}" required>
          </div> 
          
         <div class="form-group">
	       <p><label for="repairshop">서비스 센터</label>
	        <select name = "repairshop" id="repairshop" onchange="firstChange(this.form);">
	            <option value="">${car_fixUpdate.repairshop}" </option> 
	            <option value="현대 블루핸즈">현대 블루핸즈</option>
	            <option value="기아 오토큐">기아 오토큐</option>
	            <option value="보레 서비스센터">쉐보레 서비스센터</option>
	            <option value="르노삼성 엔젤센터">르노삼성 엔젤센터</option>
	            <option value="Master">Master</option>
	            <option value="KTAMG (케이티에이엠지)">KTAMG (케이티에이엠지)</option>
	            <option value="투투정비소">투투정비소</option>
	            <option value="공임나라">공임나라</option>
	            <option value="카포스">카포스</option>
	            <option value="SPEEDMATE">SPEEDMATE</option>
	            <option value="Auto Oasis (오토 오아시스)">Auto Oasis (오토 오아시스)</option>
	            <option value="카젠">카젠</option>	            
	            <option value="T station(티스테이션)">T station(티스테이션)</option>
	            <option value="한국타이어">한국타이어</option>
	            <option value="금호타이어">금호타이어</option>
	            <option value="넥센타이어">넥센타이어</option>
	            <option value="타이어 테크">타이어 테크</option>
	            <option value="타이어 프로">타이어 프로</option>
	            <option value="타이어 뱅크">타이어 뱅크</option>
	            <option value="기타">기타</option>
	            
	            
	        </select></p>
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
	var result =${car_fix}; //result 값을 읽고 get타입으로 보내온
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