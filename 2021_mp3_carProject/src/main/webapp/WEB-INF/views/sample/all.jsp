<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
        
<%@include file="../includes/header.jsp" %>
        <div class="container-fluid">
          <div class="row justify-content-center">
            <div class="col-12">
              
              
              
              
				<!-- all or member or admin -->
				
				<h2 class="mb-2 page-title">Main Page</h2>
				
				<P>  현재시간 ${serverTime} </P>
				
				<sec:authorize access="isAnonymous()">
				
				  <a href="/customLogin">로그인</a>
				
				</sec:authorize>
				
				<sec:authorize access="isAuthenticated()">
				
				  <a href="/customLogout">로그아웃</a>
				
				</sec:authorize>



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