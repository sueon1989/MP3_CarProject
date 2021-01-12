<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<title>아이디 찾기</title>
</head>
<body>
	<div class="w3-content w3-container w3-margin-top">
		<div class="w3-container w3-card-4">
		
			<form action="MemverIDFindMail" method="get">
				
				<div class="w3-center w3-large w3-margin-top">
					
					<h3>아이디 찾기</h3>
				
				</div>
				<div>
					<p>
					<label>이름</label><br>
					<input class="w3-input" type="text" id="name" name="member_name" required>
					
					<label>Email</label>
					<input class="w3-input" type="text" id="email" name="member_mail" required>
					</p>
					<p class="w3-center">
				<button type="submit" id=findBtn class="w3-button w3-block w3-black w3-ripple w3-margin-top w3-round">찾기</button>
						
					</p>
				</div>
			</form>

		</div>
	</div>

</body>
			                            <!-- Modal -->
                            <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                                <div class="modal-dialog">
                                    <div class="modal-content">
                                        <div class="modal-header">
                                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                                            <h4 class="modal-title" id="myModalLabel">처리완료</h4>
                                        </div>
                                        <div class="modal-body">
                                           해당 메일로 메일을 발송하였습니다.                            </div>
                                        <div class="modal-footer">
                                            <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                                        </div>
                                    </div>
                                    <!-- /.modal-content -->
                                </div>
                                <!-- /.modal-dialog -->
                            </div>
                            <!-- /.modal -->
	<script>
$(document).ready(function(){
	var result ='${result}'; //result 값을 읽고 get타입으로 보내온
	console.log("값찍기"+result);  //크롬F12 console 클릭
	
	console.log("전"+history.state);
	checkModal(result);
	
	history.replaceState({},null,null);
	console.log("후"+history.state);}
	</script>
	
</html>