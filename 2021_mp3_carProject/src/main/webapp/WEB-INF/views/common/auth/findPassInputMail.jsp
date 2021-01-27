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




<div class="wrapper vh-100">
     <div class="row align-items-center h-100">
     <form role="form" action= "findPassInputMail" method="post" class="col-lg-3 col-md-4 col-10 mx-auto text-center">
       
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
         
 
       
         <h1 class="h1 mb-3"><font size="15"> Find Pass </font></h1>
        
        <div class="form-group">
           <label>ID</label>
           <input type="text" name='member_id' 
           	id="member_id" class="form-control form-control-lg" required>
         </div>     	
         <div class="form-group">
           <label>Name</label>
           <input type="text" name='member_name'  
           	id="member_name" class="form-control form-control-lg" required>
         </div>
         <div class="form-group">
           <label>Email</label>
           <input type="text" name='member_mail'  
           	id="member_mail" class="form-control form-control-lg" required>
         </div>

         
         <button type="submit" id=findBtn class="btn btn-lg btn-primary btn-block">find</button>
         <button class="btn btn-lg btn-primary btn-block" type="button" onclick = "location.href = '/customLogin'"> Login </button>
         <p class="mt-5 mb-3 text-muted">© 2021-</p>
         
		
	

			<!-- CSRF (Cross-site Request Forgery) 토큰: CSRF(사이트간 요청 위조) 방지 -->
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
		<%-- ${_csrf.parameterName}: 실제 브라우저에서는 "_csrf"라는 이름으로 처리됨 --%>
		</form>
		<!-- Modal -->
                            <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                                <div class="modal-dialog">
                                    <div class="modal-content">
                                        <div class="modal-header">
                                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                                            <h4 class="modal-title" id="myModalLabel">처리완료</h4>
                                        </div>
                                        <div class="modal-body">
                                            해당 메일로 발송하였습니다.                            </div>
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
    <script src='/resources/light/js/jquery.dataTables.min.js'></script>
    <script src='/resources/light/js/dataTables.bootstrap4.min.js'></script>



	
  
  <script>  
$(document).ready(function(){
	var result =${result}; //result 값을 읽고 get타입으로 보내온
	console.log("값찍기"+result);  //크롬F12 console 클릭
	
	console.log("전"+history.state);
	checkModal(result);
	
	history.replaceState({},null,null);
	console.log("후"+history.state);
	
	function checkModal(result){
		
//      	if(result == ''){ //뒤로 가기가 아닐때
//     		console.log("후sdadasda");
//    		return;
    		
//     	}
    	if(result == true ){
    		console.log("후dkdkdkdk");
    			$(".modal-body").html("메일 발송 완료 되었습니다.");
    			$("#myModal").modal("show");
    		}else{
    			$(".modal-body").html("해당 회원이 없습니다.");
    			$("#myModal").modal("show");
    		}
	   	}
 	
})
 </script>    
</body>
</html>