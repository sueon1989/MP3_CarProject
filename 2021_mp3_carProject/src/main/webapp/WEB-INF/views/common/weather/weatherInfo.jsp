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
	<h2 class="mb-2 page-title">내 주변 실시간 기상 정보</h2>
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
                  <%-- <p class="mb-1 small text-muted"> ${weather.baseDate} </p> --%>
                  <p class="mb-1 small text-muted"> ${weatherLocation.lo2nd_si } ${weatherLocation.lo2nd_gu } ${weatherLocation.lo3rd }</p>
               </span>
               <span>  
					<c:if test="${weather.pty == '비'}">
						<img src="/resources/weatherSVG/umbrella-drizzle.svg" alt="비" height="80px">
					</c:if>
					<c:if test="${weather.pty == '눈'}">
						<img src="/resources/weatherSVG/snow.svg" alt="눈" height="100px">
					</c:if>
	            	<c:if test=" ${weather.pty =='' && weather.sky == '맑음'}">
						<img src="/resources/weatherSVG/sun.svg" alt="맑음" height="80px">
					</c:if>	
					<c:if test="${weather.pty =='' && weather.sky == '구름많음'}">
						<img src="/resources/weatherSVG/clouds.svg" alt="구름많음" height="100px">
					</c:if>
					<c:if test="${weather.pty =='' && weather.sky == '흐림'}">
						<img src="/resources/weatherSVG/cloud.svg" alt="흐림" height="120px">
					</c:if>
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
                           
           <c:if test="${weather.pty eq '비' && weather.r06 !=''}">   
           <div class="col-6 col-lg-2 text-center py-4">
               <p class="mb-1 small text-muted">강수량</p>
               <span class="h3">${weather.r06}</span><br />
             </div>
           </c:if>
           
           <c:if test="${weather.pty eq '눈' && weather.s06 !=''}" >   
           <div class="col-6 col-lg-2 text-center py-4">
               <p class="mb-1 small text-muted">신적설</p>
               <span class="h3">${weather.s06}</span><br />
             </div>
           </c:if>
             
           </div> <!-- row mt-1 align-items-center -->
         </div> <!-- .card-body -->
       </div> <!-- .card -->
   </div>
      
      
	<div class="mb-2 align-items-center">
	    <div class="card shadow mb-4">
	      <div class="card-body">
	        <div class="mt-1 align-items-center">
	        
              <div class="text-center">
                  <p class="mb-1 small text-muted">오늘의 운전 Tip</p>
               		<c:if test=" ${weather.pty =='' && weather.sky == '맑음'}">
	                     <span class="h3">안전거리 확보</span><br><br>
	                     <span>
	                        운전하기 좋은 맑은 날이지만,
	                        방심하지 말고 도로 상황을 살피며 안전운전!
	                        <br> 
	                     </span>
					</c:if>	
					<c:if test="${weather.pty =='' && weather.sky == '구름많음'}">
	                     <span class="h3">낮에도 미등 켜기</span><br><br>
	                     <span>
	                           흐린 날에는 낮에도 미등이나 전조등을 켜고 운행하면 다른 차량이나 보행자가 차량 위치를 쉽게 알 수 있어서 사고를 줄이는 효과가 있습니다.<br> 
	                     </span>
					</c:if>
					<c:if test="${weather.pty =='' && weather.sky == '흐림'}">
	                     <span class="h3">낮에도 미등 켜기</span><br><br>
	                     <span>
	                       흐린 날에는 낮에도 미등이나 전조등을 켜고 운행하면 다른 차량이나 보행자가 차량 위치를 쉽게 알 수 있어서 사고를 줄이는 효과가 있습니다.<br> 
	                     </span>
					</c:if>
					<c:if test="${weather.pty == '비'}">
                     <span class="h3">20% 감속운행 & 전조등 켜기</span><br><br>
                        <span>
                           비가 오는 날에는 앞차의 후미등 불빛이 도로 바닥에 반사되어 차선이 잘 보이지 않으므로, 무조건 20% 감속운행을 해 돌발상황에 대비해야 합니다.<br>
                        또한, 전조등을 켜고 운행하면 다른 차량이나 보행자가 차량 위치를 쉽게 알 수 있어서 사고를 줄이는 효과가 있습니다.<br> 
                        </span>
					</c:if>
					<c:if test="${weather.pty == '눈'}">
                     <span class="h3">급출발·급핸들·급제동 금지</span><br><br>
                     <span>
                        눈이 오는 날에는 도로가 미끄러워져 정지거리가 길어지고 핸들과 제동 조작이 잘 안 되므로 무조건 <b>20% 감속운행</b>을 해 돌발상황에 대비하되, 
                        노면이 결빙되었을 때나 눈이 20mm이상 쌓였을 때는 <b>50% 감속 운행</b>하여야 합니다.<br><br> 
                        또한, 급출발·급핸들·급제동 조작은 결국 눈·빗길에 미끄러져 사고의 원인이 되므로 차량을 정지시킬 때에는 <b>브레이크 페달을 여러번 나누어 살짝 밟거나</b> 특히 눈길에서는 <b>엔진 브레이크(2단기어)</b>를 효과적으로 사용해주세요. 
                     </span>
					</c:if>
                  <!-- 폭염 -->
                  <!-- 폭설 -->
	        	</div>
	        	
	        </div> <!-- row mt-1 align-items-center -->
	      </div> <!-- .card-body -->
	    </div> <!-- .card -->
	</div>


   <div class="mb-2 align-items-center">
       <div class="card shadow mb-4">
         <div class="card-body">
           <div class="mt-1 align-items-center">
              <div class="text-center">
                  <p class="mb-1 small text-muted">계절별 차량점검 Tip</p>
               <span class="h3">봄 맞이 차량점검 체크리스트</span><br /><br />
                     <p>겨울동안 추위와 눈, 비로 고생했던 내 차를 위한 봄맞이 차량 점검!
               아래 체크리스트에서 관리가 필요한 항목들을 체크해보고 꼭 점검해보세요!</p>
                 <img src="/resources/carManagementTip/springChecklist.png" alt="봄" width="80%"><br><br>
                 <button type="button" class="btn mb-2 btn-outline-info" onclick = "location.href = '/weather/carMagTipBySeason'">체크하러 가기</button>
              </div>
           </div> <!-- row mt-1 align-items-center -->
         </div> <!-- .card-body -->
       </div> <!-- .card -->
   </div>

            </div> <!-- .col-12 -->
          </div> <!-- .row -->
        </div> <!-- .container-fluid -->
<%@include file="/WEB-INF/views/includes/footer.jsp" %>