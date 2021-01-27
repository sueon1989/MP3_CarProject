<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>

<%@include file="/WEB-INF/views/includes/header.jsp" %> 


<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>지도에 교통정보 표시하기</title>
    
</head>
<body>
      <div class="container-fluid">
          <div class="row justify-content-center">
            <div class="col-12">.
	<h2 class="mb-2 page-title">내 주변 실시간 교통정보</h2>
	<hr class="my-4">
<div class="wrap_content">
	      <div class="card-body">
	        <div class="row mt-1 align-items-center">
	        
	          <div class="col-12 col-lg-4 text-left pl-4"> 
<div id="map" style="width:100%;height:350px;"></div>

<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=89a27e9b9c5188451b86f925bb3f4a6f"></script>
<script>

var Latitude=${Latitude};
var Longitude=${Longitude};

var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
    mapOption = { 
        center: new kakao.maps.LatLng(Latitude, Longitude), // 지도의 중심좌표
        level: 4 // 지도의 확대 레벨
    };

var map = new kakao.maps.Map(mapContainer, mapOption); // 지도를 생성합니다

// 지도에 교통정보를 표시하도록 지도타입을 추가합니다
map.addOverlayMapTypeId(kakao.maps.MapTypeId.TRAFFIC);    

// 아래 코드는 위에서 추가한 교통정보 지도타입을 제거합니다
// map.removeOverlayMapTypeId(kakao.maps.MapTypeId.TRAFFIC);   


	   </script>
      </div>
     </div>
    </div>
   </div>
  </div>
 </div>
</div>
<p>
    <em>현재 주변 교통 상황 입니다.</em>
</p>
 <button type="button" class="btn mb-2 btn-outline-info" onclick = "location.href = '/mypage/ViewTest3'">새로고침</button>
</body>

            </div> <!-- .col-12 -->
          </div> <!-- .row -->
        </div> <!-- .container-fluid -->
<%@include file="/WEB-INF/views/includes/footer.jsp" %>
</html>