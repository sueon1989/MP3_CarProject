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
	<div id="map" style="width:500px;height:400px;"></div>
	<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=89a27e9b9c5188451b86f925bb3f4a6f"></script>
	<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=89a27e9b9c5188451b86f925bb3f4a6f&libraries=LIBRARY"></script>
	<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=89a27e9b9c5188451b86f925bb3f4a6f&libraries=services"></script>
	<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=89a27e9b9c5188451b86f925bb3f4a6f&libraries=services,clusterer,drawing"></script>
	<script>
		var Latitude=${Latitude};
		var Longitude=${Longitude};
		var container = document.getElementById('map');
		var options = {
			center: new kakao.maps.LatLng(Latitude,Longitude),
			level: 3
		};

		var map = new kakao.maps.Map(container, options);
		
		map.addOverlayMapTypeId(kakao.maps.MapTypeId.ROADVIEW); 
	</script> 
	
</body>
</html>