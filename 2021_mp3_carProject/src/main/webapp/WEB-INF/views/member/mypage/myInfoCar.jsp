<%@ page language="java" contentType="text/html; charset=UTF-8"
     pageEncoding="UTF-8"%> 
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
 <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
 <%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
        
 <%@include file="/WEB-INF/views/includes/header.jsp" %>   
        <div class="container-fluid">
<!--           <div class="row justify-content-center"> -->
<!--             <div class="col-12"> -->
              
              
              
              
 	<!-- 기본 화면 --> 
	<h2 class="mb-2 page-title">차량 관리 프로그램</h2>
	<hr class="my-4">
	
	<!-- 로그인하지 않은 경우 -->
	<sec:authorize access="isAnonymous()">
		        <a href="/customLogin">로그인후이용하세요</a><br>
				<a href="/member/register">회원이 아닌경우 회원가입으로</a> <br>
	</sec:authorize>
	
<!-- ************	데이터 테이블 멤버 테이블에 차량번호 키 추가 해야됨 *********** -->
		
<!-- 	로그인한 경우 -->
	<sec:authorize access="isAuthenticated()">
		    <hr class="my-4"> 
              <h2 class="mb-2 page-title">내 차량 정보</h2>
              <div class="row my-4">
                Small table
                <div class="col-md-12">
                  <div class="card shadow">
                    <div class="card-body">
                      table
                      <table class="table datatables" id="dataTable-1">
                        <thead>
                          <tr>
                            <th width="30" >No.</th>
                            <td width="250" ><sec:authentication property="principal.car.car_no"/></td>
                          </tr>
                          <tr>
                            <th width="30" >number</th>
                            <td width="250"><sec:authentication property="principal.car.car_number"/></td>
                          </tr>  
                          <tr>
                            <th width="30" >company</th>
                            <td width="250"><sec:authentication property="principal.car.car_company"/></td>
                          </tr>  
                          <tr>
                            <th width="30" >type</th>
                            <td width="250"><sec:authentication property="principal.car.car_type"/></td>
                          </tr>  
                          <tr>
                            <th width="30" >model</th>
                            <td width="250"><sec:authentication property="principal.car.car_model"/></td>
                          </tr> 
                          <tr>
                            <th width="30" >fual</th>
                            <td width="250"><sec:authentication property="principal.car.car_fual"/></td>
                          </tr> 
                          <tr>
                            <th width="30" >엔진오일 교체시기</th>
                            <td width="250"><sec:authentication property="principal.car.car_engineoilrp"/></td>
                          </tr>  
                          <tr>
                            <th width="30" >Action</th>
                			<td width="250"><button class="btn btn-sm dropdown-toggle more-horizontal" type="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                <span class="text-muted sr-only">Action</span>
                              </button>
                              <div class="dropdown-menu dropdown-menu-right">
                                <a class="dropdown-item" href="/mypage/myInfoUpdate">Edit</a>
                                <a class="dropdown-item" href="/mypage/myInfoDelete">Remove</a>
                                <a class="dropdown-item" href="/">Assign</a>
                              </div>
                            </td>
                          </tr>  
                        </thead>
		      
	</sec:authorize>
	  
	
	<!-- 관리자로 로그인한 경우 -->
	<sec:authorize access="hasRole('ROLE_ADMIN')">
				<hr class="my-4">
		        <div class="form-group">
		        	<h5>관리자</h5>
		        </div>
              	<a href="/sample/admin">회원관리</a>
	</sec:authorize>



            </div> .col-12
          </div> .row
        </div> .container-fluid
      <script>
       $('#dataTable-1').DataTable(
       {
         autoWidth: true,
         "lengthMenu": [
           [16, 32, 64, -1],
           [16, 32, 64, "All"]
         ]
     });
    </script>
<%@include file="/WEB-INF/views/includes/footer.jsp" %>    








