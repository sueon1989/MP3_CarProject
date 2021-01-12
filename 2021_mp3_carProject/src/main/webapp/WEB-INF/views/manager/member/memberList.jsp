<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>memberList</title>
</head>
<body>


<h2> <a href='/member/list'> 회원 목록 </a> </h2>
<h2> <a href='/member/get?member_no=1'> 회원정보 상세보기 </a> </h2>
<h2> <a href='/member/register'> 회원가입 </a> </h2>
<!-- <h2> <a href='/member/memberRegFinished'> 회원가입 완료화면 </a> </h2> -->

<h1>회원 조회</h1>
${list}


</body>
</html>