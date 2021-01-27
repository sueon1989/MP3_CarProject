<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>


<%@include file="/WEB-INF/views/includes/header.jsp" %>  
        <div class="container-fluid">
          <div class="row justify-content-center">
            <div class="col-12">
              
              
              
              
	<!-- 기본 화면 -->
	<h2 class="mb-2 page-title">기상청 날씨예보</h2>
	<hr class="my-4">
	
	<!-- 예보시각		(0200, 0500, 0800, 1100, 1400, 1700, 2000, 2300 (1일 8회)) -->
	<%-- <c:set var="baseTime" value="${weather.baseTime}"/> --%>
	<%-- 길이: ${fn:length(BaseTime) }	<br> --%> 
	
	<div class="mb-2 align-items-center">
	    <div class="card shadow mb-4">
	      <div class="card-body">
	        <div class="row mt-1 align-items-center">
	        
	          <div class="col-12 col-lg-4 text-left pl-4">
	            
	            <span>	
					<span>
						<p class="mb-1 small text-muted"> ${weatherLocation.lo2nd_si } ${weatherLocation.lo2nd_gu } ${weatherLocation.lo3rd }</p>
					</span>
	             	<span>	
	            	<c:if test="${weather.sky eq '맑음'}">
						<img src="/resources/weatherSVG/sun.svg" alt="맑음" height="80px">
					</c:if>	
					<c:if test="${weather.sky eq '구름많음'}">
						<img src="/resources/weatherSVG/clouds.svg" alt="구름많음" height="100px">
					</c:if>
					<c:if test="${weather.sky eq '흐림'}">
						<img src="/resources/weatherSVG/cloud.svg" alt="흐림" height="120px">
					</c:if>
					<c:if test="${weather.pty eq '비'}">
						<img src="/resources/weatherSVG/umbrella-drizzle.svg" alt="비" height="80px">
					</c:if>
					</span>
				</span>
	          </div>
	          <div class="col-6 col-lg-2 text-center py-4">
				<p class="mb-1 small text-muted">${fn:substring(weather.baseTime,0,2) }시 예보</p>
	            <span class="h3">${weather.sky}</span><br />
	          </div>
	          <div class="col-6 col-lg-2 text-center py-4 mb-2">
	            <p class="mb-1 small text-muted">온도</p>
	            <span class="h3">${weather.t3h}℃</span><br />
	          </div>
	          <div class="col-6 col-lg-2 text-center py-4">
	            <p class="mb-1 small text-muted">습도</p>
	            <span class="h3">${weather.reh}%</span><br />
	          </div>
			  <div class="col-6 col-lg-2 text-center py-4">
	            <p class="mb-1 small text-muted">강수확률</p>
	            <span class="h3">${weather.pop}%</span><br />
	          </div>
                           
			  <c:if test="${weather.pty eq '비'}">	
			  <div class="col-6 col-lg-2 text-center py-4">
	            <p class="mb-1 small text-muted">강수량</p>
	            <span class="h3">${weather.r06}</span><br />
	          </div>
			  </c:if>
			  
			  <c:if test="${weather.pty eq '눈'}">	
			  <div class="col-6 col-lg-2 text-center py-4">
	            <p class="mb-1 small text-muted">신적설</p>
	            <span class="h3">${weather.s06}</span><br />
	          </div>
			  </c:if>	          
	          
	        </div> <!-- row mt-1 align-items-center -->
	      </div> <!-- .card-body -->
	    </div> <!-- .card -->
	</div>
		
	<!-- 
	private String pop;			// 강수확률	(%)
	private String pty;			// 강수형태
	private String r06;			// 6시간 강수량	(1 mm)
	private String reh;			// 습도		(%)
	private String s06;			// 6시간 신적설	(1 cm)
	private String sky;			// 하늘상태
	private String t3h;			// 3시간 기온		(℃)
	private String tmn;			// 아침 최저기온	(℃)
	private String tmx; 		// 낮 최고기온		(℃)
	private String uuu;			// 풍속(동서성분)	(m/s)
	private String vvv;			// 풍속(남북성분)	(m/s)
	private String wav; 	//파고	(M)
	private String vec;			// 풍향		(deg)
	private String wsd;			// 풍속		(m/s) -->

	
	<!-- 로그인하지 않은 경우 -->
	<sec:authorize access="isAnonymous()">
	<p class="mb-1 small text-muted">
		회원가입 후 자동차관리용 플러그를 신청하세요! <br>
		평균 주행거리, 연비 자동계산, 
		실시간 기상정보에 따른 차량점검 tip 등의 
		편리한 기능을 사용하실 수 있습니다! 
		<!-- 회원가입 후 자동차관리용 플러그를 신청하세요!<br>
		평균 주행거리, 연비 자동계산,<br>
		실시간 날씨정보에 따른 차량점검 tip 등의<br>
		편리한 기능을 사용하실 수 있습니다!<br> -->
    </p>
        <a href="/customLogin">로그인</a><br>
        <a href="/member/register">회원가입</a><br>
	</sec:authorize>
	
	
	<!-- 로그인한 경우 -->
	<sec:authorize access="isAuthenticated()">
	 
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
<%@include file="/WEB-INF/views/includes/footer.jsp" %>