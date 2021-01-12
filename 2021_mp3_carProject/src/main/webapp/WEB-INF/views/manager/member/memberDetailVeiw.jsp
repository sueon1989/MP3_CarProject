<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>memberDetailVeiw</title>
</head>
<body>


${Member}

              <h2 class="mb-2 page-title">회원 상세조회</h2>
                <div class="form-group">
		          <label for="input1">회원 ID</label>
		          <input type="text" class="form-control" id="input1" name="member_id" value='<sec:authentication property="principal.username"/>' readonly>
		        </div>


</body>
</html>