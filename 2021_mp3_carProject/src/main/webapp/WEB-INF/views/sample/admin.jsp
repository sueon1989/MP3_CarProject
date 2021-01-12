<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
        
<%@include file="../includes/header.jsp" %>
        <div class="container-fluid">
          <div class="row justify-content-center">
            <div class="col-12">
              
              
              <h2 class="mb-2 page-title">관리자 페이지</h2>
                <%-- <div class="form-group">
		          <label for="input1">관리자 ID</label>
		          <input type="text" class="form-control" id="input1" name="member_id" value='<sec:authentication property="principal.username"/>' readonly>
		        </div> --%>
		        
		        <div class="form-group">
					<p>principal : <sec:authentication property="principal"/></p>
					<p>MemberVO : <sec:authentication property="principal.member"/></p>
					<p>사용자이름 : <sec:authentication property="principal.member.member_name"/></p>
					<p>사용자ID : <sec:authentication property="principal.username"/></p>
					<p>사용자 권한 리스트  : <sec:authentication property="principal.member.authList"/></p>
		        </div>
				
		        <div class="form-group">
					<a href="/customLogout">Logout</a>
		        </div>
		        
		        <hr class="my-4">
              
              
              <h2 class="mb-2 page-title">회원 조회</h2>
              <div class="row my-4">
                <!-- Small table -->
                <div class="col-md-12">
                  <div class="card shadow">
                    <div class="card-body">
                      <!-- table -->
                      <table class="table datatables" id="dataTable-1">
                        <thead>
                          <tr>
                            <th></th>
                            <th>#No</th>
                            <th>ID</th>
                            <th>Name</th>
                            <th>Gender</th>
                            <th>Birth</th>
                            <th>Phone</th>
                            <th>Address</th>
                            <th>Mail</th>
                            <th>MailAccept</th>
                            <th>RegDate</th>
                            <th>UpdateDate</th>
                            <th>Permission</th>
                            <th>Action</th>
                          </tr>
                        </thead>
                        
                        <tbody>
                        <!-- 회원 목록 불러오기 -->
						<c:forEach items="${list}" var="member">
						
                          <tr>
                            <td>
                              <div class="custom-control custom-checkbox">
                                <input type="checkbox" class="custom-control-input">
                                <label class="custom-control-label"></label>
                              </div>
                            </td>
                            
                            <td><c:out value="${member.member_no}" /></td>
                            <td><c:out value="${member.member_id}" /></td>
                            <td><c:out value="${member.member_name}" /></td>
                            <td><c:out value="${member.member_gender}" /></td>
                            <td><fmt:formatDate pattern="yyyy-MM-dd" value="${member.member_birth}" /></td>
                            <td><c:out value="${member.member_phone}" /></td>
                            <td><c:out value="${member.member_address}" /></td>
                            <td><c:out value="${member.member_mail}" /></td>
                            <td><c:out value="${member.member_mailaccept}" /></td>
                            <td><fmt:formatDate pattern="yyyy-MM-dd" value="${member.member_regDate}" /></td>
                            <td><fmt:formatDate pattern="yyyy-MM-dd" value="${member.member_updateDate}" /></td>
                            <td><c:out value="${member.member_permission}" /></td>
                                                        
                            <td><button class="btn btn-sm dropdown-toggle more-horizontal" type="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                <span class="text-muted sr-only">Action</span>
                              </button>
                              <div class="dropdown-menu dropdown-menu-right">
                                <a class="dropdown-item" href="#">Edit</a>
                                <a class="dropdown-item" href="#">Remove</a>
                                <a class="dropdown-item" href="#">Assign</a>
                              </div>
                            </td>
                            
                          </tr>
                        
						</c:forEach>                            
                        </tbody>
                        
                      </table>
                      
                      
                    </div>
                  </div>
                </div> <!-- simple table -->
              </div> <!-- end section -->
            </div> <!-- .col-12 -->
          </div> <!-- .row -->
        </div> <!-- .container-fluid -->
    
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

<%@include file="../includes/footer.jsp" %>