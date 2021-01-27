<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>


<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8"/>
	<title>Kakao 지도 시작하기</title>
</head>
<body>
<form action="mapResult" method="get">
위도 입력:<input type="text" name="Latitude" id="Latitude"><br>
경도 입력:<input type="text" name="Longitude" id="Longitude"><br>
아이디 입력:<input type="text" name="GpsNo" id="GpsNo"><br>
<input type="submit" value="입력">


</form>
</body>
</html>