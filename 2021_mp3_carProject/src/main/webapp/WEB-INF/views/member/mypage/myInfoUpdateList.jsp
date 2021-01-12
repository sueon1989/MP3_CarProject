<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
        



<%@include file="/WEB-INF/views/includes/header.jsp" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 정보 수정</title>
</head>
<body>
<form action="myInfoUpdatePassCheck" method="get">

		 <h2 class="mb-2 page-title">내 정보 수정</h2>
         <table border="1">
               <tr>
                   <th>No.</th>
                   <td><input type="text" name='member_no'  value="${member.member_no}"></td>
               </tr>
               <tr>
                   <th>ID</th>
                   <td><input type="text" name='member_id'  value="${member.member_id}"></td>
               </tr>
               <tr>
                   <th>PassWord</th>
                   <td><input type="password" name='member_pass'  value="${member.member_pass}"></td>
               </tr>    
               <tr>
                   <th>Name</th>
                   <td><input type="text" name='member_name'  value="${member.member_name}"></td>
               </tr>
               <tr>
                   <th>Gender</th>
                   <td><input type="text" name='member_gender'  value="${member.member_gender}"></td>
               </tr>
               <tr>
                   <th>Birth</th>
                   <td><input type="text" name='member_birth'  value="<fmt:formatDate pattern='yyyy-MM-dd' value='${member.member_birth}'/>"/></td>
               </tr>     
               <tr>
                   <th>Phone</th>
                   <td><input type="text" name='member_phone'  value="${member.member_phone}"></td>
               </tr>
               <tr>
                   <th>Address</th>
                   <td><input type="text" name='member_address'  value="${member.member_address}"></td>
               </tr>
               <tr>
                   <th>Mail</th>
                   <td><input type="text" name='member_mail'  value="${member.member_mail}"></td>
               </tr>    
               <tr>
                   <th>MailAccept</th>
                   <td><input type="text" name='member_mailaccept'  value="${member.member_mailaccept}"></td>
               </tr>                                                                     
         </table>
            <div class="btn-box w-100 mt-4 mb-1">
            <a href="/mypage/myInfoRead" target="_blank" class="btn mb-2 btn-primary btn-lg btn-block">
              <i class="fe fe-shopping-cart fe-12 mx-2"></i><span class="small">수정 하기</span>
            </a>
          </div>
         <input type="submit" value="수정">
</form>
<%@include file="/WEB-INF/views/includes/footer.jsp" %>    
</body>
</html>