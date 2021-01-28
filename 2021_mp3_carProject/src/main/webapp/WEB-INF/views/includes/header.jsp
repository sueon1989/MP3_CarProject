<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="favicon.ico">
	<title>MIT Car Project</title>
	
    <!-- Simple bar CSS -->
    <link rel="stylesheet" href="/resources/light/css/simplebar.css">
    
    <!-- Fonts CSS -->
    <link href="https://fonts.googleapis.com/css2?family=Overpass:ital,wght@0,100;0,200;0,300;0,400;0,600;0,700;0,800;0,900;1,100;1,200;1,300;1,400;1,600;1,700;1,800;1,900&display=swap" rel="stylesheet">
    
    <!-- Icons CSS -->
    <link rel="stylesheet" href="/resources/light/css/feather.css">
    
    <!-- Date Range Picker CSS -->
    <link rel="stylesheet" href="/resources/light/css/daterangepicker.css">
    
    <!-- App CSS -->
    <link rel="stylesheet" href="/resources/light/css/app-light.css" id="lightTheme">
    <link rel="stylesheet" href="/resources/light/css/app-dark.css" id="darkTheme" disabled>
</head>


<body class="vertical  light  ">
    <div class="wrapper">
      <nav class="topnav navbar navbar-light">
        <button type="button" class="navbar-toggler text-muted mt-2 p-0 mr-3 collapseSidebar">
          <i class="fe fe-menu navbar-toggler-icon"></i>
        </button>
        <ul class="nav">
          <li class="nav-item">
            <a class="nav-link text-muted my-2" href="#" id="modeSwitcher" data-mode="light">
              <i class="fe fe-sun fe-16"></i>
            </a>
          </li>
          <!-- <li class="nav-item">
            <a class="nav-link text-muted my-2" href="./#" data-toggle="modal" data-target=".modal-shortcut">
              <span class="fe fe-grid fe-16"></span>
            </a>
          </li>
          <li class="nav-item nav-notif">
            <a class="nav-link text-muted my-2" href="./#" data-toggle="modal" data-target=".modal-notif">
              <span class="fe fe-bell fe-16"></span>
              <span class="dot dot-md bg-success"></span>
            </a>
          </li> -->
          
          
	          	<sec:authorize access="isAnonymous()">
	          
		          <li class="nav-item">
		          	<a class="nav-link text-muted my-2" href="/customLogin">로그인</a>
		          </li>
		          <li class="nav-item">
		          	<a class="nav-link text-muted my-2" href="/member/register">회원가입</a>
		          </li>
	
	          	</sec:authorize>
	          
	
				<sec:authorize access="hasRole('ROLE_ADMIN')">
	
		          <li class="nav-item">
		          	<a class="nav-link text-muted my-2" href="/member/list">회원관리</a>
		          </li>
	
				</sec:authorize>
	
				<sec:authorize access="isAuthenticated()">
				
		          <!-- <li class="nav-item">
		          	<a class="nav-link text-muted my-2" href="/mypage/myInfoRead"">내 정보</a>
		          </li> -->
		          <li class="nav-item">
		          	<form action="/customLogout" method='post'>
						<button class="btn nav-link text-muted my-2">로그아웃</button>
						<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
					</form>
		          </li>
	
				</sec:authorize>
			
            </div>
          </li>
        </ul>
      </nav>
      <aside class="sidebar-left border-right bg-white shadow" id="leftSidebar" data-simplebar>
        <a href="#" class="btn collapseSidebar toggle-btn d-lg-none text-muted ml-2 mt-3" data-toggle="toggle">
          <i class="fe fe-x"><span class="sr-only"></span></i>
        </a>
        <nav class="vertnav navbar navbar-light">
          <!-- nav bar -->
          <div class="w-100 mb-4 d-flex">
            <a class="navbar-brand mx-auto mt-2 flex-fill text-center" href="/">
<!-- 		<span>       -->
<!--               <img src="/resources/light/assets/images/car_logo.png" alt="..."  -->
<!--               class="img-rounded" width="25px" height="20px"></span> -->
              
<!--         <span>       -->
<!--               <img src="/resources/light/assets/images/car_logo.png" alt="..."  -->
<!--               class="img-rounded" width="30px" height="25px"></span> -->
        <span>      
              <img src="/resources/light/assets/images/car_logo.png" alt="..." 
              class="img-rounded" width="40px" height="35px"></span>     
        
         </a>

            </a>
          </div>
          <ul class="navbar-nav flex-fill w-100 mb-2">
            <li class="nav-item dropdown">
              <a href="#dashboard" data-toggle="collapse" aria-expanded="false" class="dropdown-toggle nav-link">
                <i class="fe fe-home fe-16"></i>
                <span class="ml-3 item-text">Home</span><span class="sr-only">(current)</span>
              </a>
              <ul class="collapse list-unstyled pl-4 w-100" id="dashboard">
<!--                 <li class="nav-item active"> -->
<!--                   <a class="nav-link pl-3" href="./index.html"><span class="ml-1 item-text">메인화면</span></a> -->
<!--                 </li> -->
                <li class="nav-item">
                  <a class="nav-link pl-3" href="/mypage/ServiceInfo"><span class="ml-1 item-text">서비스 소개</span></a>
                </li>
<!--                 <li class="nav-item"> -->
<!--                   <a class="nav-link pl-3" href="./dashboard-sales.html"><span class="ml-1 item-text">내 정보 관리</span></a> -->
<!--                 </li> -->
<!--                 <li class="nav-item"> -->
<!--                   <a class="nav-link pl-3" href="./dashboard-saas.html"><span class="ml-1 item-text">차량 정보 관리</span></a> -->
<!--                 </li> -->
<!--                 <li class="nav-item"> -->
<!--                   <a class="nav-link pl-3" href="./dashboard-system.html"><span class="ml-1 item-text">인사말</span></a> -->
<!--                 </li> -->
              </ul>
            </li>
          </ul>
          <p class="text-muted nav-heading mt-4 mb-1">
            <span>Car Management</span>
          </p>
          <ul class="navbar-nav flex-fill w-100 mb-2">
            <li class="nav-item dropdown">
              <a href="#driving" data-toggle="collapse" aria-expanded="false" class="dropdown-toggle nav-link">
                <i class="fe fe-box fe-16"></i>
                <span class="ml-3 item-text">차량 메뉴</span>
              </a>
              <ul class="collapse list-unstyled pl-4 w-100" id="driving">
                <li class="nav-item">
                  <a class="nav-link pl-3" href="/mypage/ViewTest"><span class="ml-1 item-text">주행기록 <span class="badge badge-pill badge-primary">업데이트 예정</span></span></a>
                </li>
                <li class="nav-item">
                  <a class="nav-link pl-3" href="/fix/car_fix"><span class="ml-1 item-text">정비/기타 기록</span></a>
                </li>
                <li class="nav-item">
                  <a class="nav-link pl-3" href="/fix/car_fix"><span class="ml-1 item-text">정비/기타 목록/수정</span></a>
                </li>
                <li class="nav-item">
                  <a class="nav-link pl-3" href="/mypage/ViewTest2"><span class="ml-1 item-text">주유기록</span></a>
                </li>
                <li class="nav-item">
                  <a class="nav-link pl-3" href="/mypage/ViewTest2"><span class="ml-1 item-text">주유기록 목록/수정</span></a>
            	 </li>
               <li class="nav-item">
                  <a class="nav-link pl-3" href="/fix/car_fix"><span class="ml-1 item-text">월별 사용내역</span></a>
                </li>
              </ul>
            </li>
          
          <ul class="navbar-nav flex-fill w-100 mb-2">
            <li class="nav-item dropdown">
              <a href="#ui-elements" data-toggle="collapse" aria-expanded="false" class="dropdown-toggle nav-link">
                <i class="fe fe-box fe-16"></i>
                <span class="ml-3 item-text">기상정보</span>
              </a>
              <ul class="collapse list-unstyled pl-4 w-100" id="ui-elements">
                <li class="nav-item">
                  <a class="nav-link pl-3" href="/weather/weatherInfo"><span class="ml-1 item-text">내 주변 실시간 기상 정보</span></a>
                </li>
                <li class="nav-item">
                  <a class="nav-link pl-3" href="/weather/carMagTipBySeason"><span class="ml-1 item-text">계절별 차량 관리 Tip</span></a>
                </li>
                <li class="nav-item">
                  <a class="nav-link pl-3" href="/weather/driveCourseBySeason"><span class="ml-1 item-text">계절별 추천 드라이브 코스</span></a>
                </li>
<!--                 <li class="nav-item"> -->
<!--                   <a class="nav-link pl-3" href="/mypage/mapView"><span class="ml-1 item-text">지도보기</span></a> -->
<!--                 </li> -->
<!--                 <li class="nav-item"> -->
<!--                   <a class="nav-link pl-3" href="./ui-notification.html"><span class="ml-1 item-text">Notifications</span></a> -->
<!--                 </li> -->
<!--                 <li class="nav-item"> -->
<!--                   <a class="nav-link pl-3" href="./ui-modals.html"><span class="ml-1 item-text">Modals</span></a> -->
<!--                 </li> -->
<!--                 <li class="nav-item"> -->
<!--                   <a class="nav-link pl-3" href="./ui-tabs-accordion.html"><span class="ml-1 item-text">Tabs & Accordion</span></a> -->
<!--                 </li> -->
<!--                 <li class="nav-item"> -->
<!--                   <a class="nav-link pl-3" href="./ui-progress.html"><span class="ml-1 item-text">Progress</span></a> -->
<!--                 </li> -->
              </ul>
<!--             </li> -->
<!--             <li class="nav-item w-100"> -->
<!--               <a class="nav-link" href="widgets.html"> -->
<!--                 <i class="fe fe-layers fe-16"></i> -->
<!--                 <span class="ml-3 item-text">차량용품 보러가기</span> -->
<!--                 <span class="badge badge-pill badge-primary">New</span> -->
<!--               </a> -->
<!--             </li> -->
            <li class="nav-item dropdown">
              <a href="#forms" data-toggle="collapse" aria-expanded="false" class="dropdown-toggle nav-link">
                <i class="fe fe-credit-card fe-16"></i>
                <span class="ml-3 item-text">My Car GPS</span>
              </a>
              <ul class="collapse list-unstyled pl-4 w-100" id="forms">
                <li class="nav-item">
                  <a class="nav-link pl-3" href="./form_elements.html"><span class="ml-1 item-text">주행거리 관리<span class="badge badge-pill badge-primary">업데이트 예정</span></span></a>
                <li class="nav-item">
                  <a class="nav-link pl-3" href="/mypage/ViewTest"><span class="ml-1 item-text">현재 차량 위치</span></a>
                </li>
                <li class="nav-item">
                  <a class="nav-link pl-3" href="/mypage/mapView"><span class="ml-1 item-text">예상 경로 거리 측정</span></a>
                </li>
                <li class="nav-item">
                  <a class="nav-link pl-3" href="/mypage/ViewTest1"><span class="ml-1 item-text">차량 주변 편의시설</span></a>
                </li>
                <li class="nav-item">
                  <a class="nav-link pl-3" href="/mypage/ViewTest3"><span class="ml-1 item-text">내 주변 실시간 교통정보</span></a>
                </li>
              </ul>
            </li>
<!--             <li class="nav-item dropdown"> -->
<!--               <a href="#tables" data-toggle="collapse" aria-expanded="false" class="dropdown-toggle nav-link"> -->
<!--                 <i class="fe fe-grid fe-16"></i> -->
<!--                 <span class="ml-3 item-text">통계자료</span> -->
<!--               </a> -->
<!--               <ul class="collapse list-unstyled pl-4 w-100" id="tables"> -->
<!--                 <li class="nav-item"> -->
<!--                   <a class="nav-link pl-3" href="/mypage/ViewTest"><span class="ml-1 item-text">지도 테스트 1</span></a> -->
<!--                 </li> -->
<!--                 <li class="nav-item"> -->
<!--                   <a class="nav-link pl-3" href="/mypage/ViewTest1"><span class="ml-1 item-text">지도 테스트 2</span></a> -->
<!--                 </li> -->
<!--                 <li class="nav-item"> -->
<!--                   <a class="nav-link pl-3" href="/mypage/ViewTest2"><span class="ml-1 item-text">날씨 위치 최신화</span></a> -->
<!--                 </li> -->
<!--               </ul> -->
<!--             </li> -->
            <li class="nav-item dropdown">
              <a href="#charts" data-toggle="collapse" aria-expanded="false" class="dropdown-toggle nav-link">
                <i class="fe fe-pie-chart fe-16"></i>
                <span class="ml-3 item-text">마이페이지</span>
              </a>
              <ul class="collapse list-unstyled pl-4 w-100" id="charts">
                <li class="nav-item">
                  <a class="nav-link pl-3" href="/mypage/myInfoRead"><span class="ml-1 item-text">내 정보 보기</span></a>
                </li>
                <li class="nav-item">
                  <a class="nav-link pl-3" href="/mypage/myInfoUpdate"><span class="ml-1 item-text">내 정보 수정</span></a>
                </li>
                <li class="nav-item">
                  <a class="nav-link pl-3" href="/mycar/carReg1_company"><span class="ml-1 item-text">내 차량 정보 등록</span></a>
                </li>  
               <li class="nav-item">
                  <a class="nav-link pl-3" href="/mycar/myCarUpdate"><span class="ml-1 item-text">내 차량정보 목록/수정</span></a>
                </li>  
                <li class="nav-item">
                  <a class="nav-link pl-3" href="/mypage/myInfoDelete"><span class="ml-1 item-text">회원 탈퇴</span></a>
                </li>
              </ul>
            </li>
          <!-- <div class="btn-box w-100 mt-4 mb-1">
            <a href="https://www.google.com/search?q=%EA%B5%AC%EA%B8%80+%EC%B0%A8%EB%9F%89%EC%9A%A9%ED%92%88&sxsrf=ALeKk01YN3m3gLX-Y5fb28t4izQtBP7qUw:1611327302438&source=lnms&tbm=shop&sa=X&ved=2ahUKEwiot-n75a_uAhUMBZQKHc1zDrwQ_AUoAHoECAUQCg&biw=1920&bih=937" target="_blank" class="btn mb-2 btn-primary btn-lg btn-block">
              <i class="fe fe-shopping-cart fe-12 mx-2"></i><span class="small">BEST ITEM 보러가기</span>
            </a>
          </div> -->
        </nav>
      </aside>
      
      
      <main role="main" class="main-content">	      