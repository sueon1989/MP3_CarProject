<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="myInfoDeletePassCheck" method="get">
<h1>${message}</h1>
회원번호 입력 : <input type="number" id="member_no" name="member_no" /><br>
비밀 번호 확인 입력 : <input type="text" id="Deletenum" name="Deletenum" /><br>
<input type="submit" value="입력">
</form>

</body>
</html>