<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
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
        <form class="form-inline mr-auto searchform text-muted">
          <input class="form-control mr-sm-2 bg-transparent border-0 pl-4 text-muted" type="search" placeholder="Type something..." aria-label="Search">
        </form>
        <ul class="nav">
          <li class="nav-item">
            <a class="nav-link text-muted my-2" href="#" id="modeSwitcher" data-mode="light">
              <i class="fe fe-sun fe-16"></i>
            </a>
          </li>
          <li class="nav-item">
            <a class="nav-link text-muted my-2" href="./#" data-toggle="modal" data-target=".modal-shortcut">
              <span class="fe fe-grid fe-16"></span>
            </a>
          </li>
          <li class="nav-item nav-notif">
            <a class="nav-link text-muted my-2" href="./#" data-toggle="modal" data-target=".modal-notif">
              <span class="fe fe-bell fe-16"></span>
              <span class="dot dot-md bg-success"></span>
            </a>
          </li>
          <li class="nav-item dropdown">
            <a class="nav-link dropdown-toggle text-muted pr-0" href="#" id="navbarDropdownMenuLink" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
              <span class="avatar avatar-sm mt-2">
                <img src="/resources/light/assets/avatars/face-1.jpg" alt="..." class="avatar-img rounded-circle">
              </span>
            </a>
            <div class="dropdown-menu dropdown-menu-right" aria-labelledby="navbarDropdownMenuLink">
            
            
<sec:authorize access="isAnonymous()">

              <a class="dropdown-item" href="/customLogin">로그인</a>
              <a class="dropdown-item" href="/member/register">회원가입</a>

</sec:authorize>

<sec:authorize access="hasRole('ROLE_ADMIN')">

              <a class="dropdown-item" href="/sample/admin">회원관리(관리자)</a>

</sec:authorize>

<sec:authorize access="isAuthenticated()">

              <a class="dropdown-item" href="/mypage/myInfoRead">내 정보</a>
              <a class="dropdown-item" href="/customLogout">로그아웃</a>

</sec:authorize>
            
            
              <!-- 
              <a class="dropdown-item" href="#">Profile</a>
              <a class="dropdown-item" href="#">Settings</a>
              <a class="dropdown-item" href="#">Activities</a> -->
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
<!--               <svg version="1.1" id="logo" class="navbar-brand-img brand-sm" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" x="0px" y="0px" viewBox="0 0 120 120" xml:space="preserve"> -->
<!--                 <g> -->
<!--                   <polygon class="st0" points="78,105 15,105 24,87 87,87 	" /> -->
<!--                   <polygon class="st0" points="96,69 33,69 42,51 105,51 	" /> -->
<!--                   <polygon class="st0" points="78,33 15,33 24,15 87,15 	" /> -->
<!--                 </g> -->
<!--               </svg> -->

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
                  <a class="nav-link pl-3" href="/Intro/ServiceInfo"><span class="ml-1 item-text">서비스 소개</span></a>
                </li>
<!--                 <li class="nav-item"> -->
<!--                   <a class="nav-link pl-3" href="./dashboard-sales.html"><span class="ml-1 item-text">내 정보 관리</span></a> -->
<!--                 </li> -->
<!--                 <li class="nav-item"> -->
<!--                   <a class="nav-link pl-3" href="./dashboard-saas.html"><span class="ml-1 item-text">차량 정보 관리</span></a> -->
<!--                 </li> -->
                <li class="nav-item">
                  <a class="nav-link pl-3" href="./dashboard-system.html"><span class="ml-1 item-text">인사말</span></a>
                </li>
              </ul>
            </li>
          </ul>
          <p class="text-muted nav-heading mt-4 mb-1">
            <span>Car Management</span>
          </p>
          <ul class="navbar-nav flex-fill w-100 mb-2">
            <li class="nav-item dropdown">
              <a href="#ui-elements" data-toggle="collapse" aria-expanded="false" class="dropdown-toggle nav-link">
                <i class="fe fe-box fe-16"></i>
                <span class="ml-3 item-text">기상정보</span>
              </a>
              <ul class="collapse list-unstyled pl-4 w-100" id="ui-elements">
                <li class="nav-item">
                  <a class="nav-link pl-3" href="/weather/weatherInfo"><span class="ml-1 item-text">내 주변 실시간 기상 정보</span>
                  </a>
                </li>
                <li class="nav-item">
                  <a class="nav-link pl-3" href="./ui-typograpy.html"><span class="ml-1 item-text">계절별 차량 관리 Tip</span></a>
                </li>
                <li class="nav-item">
                  <a class="nav-link pl-3" href="./ui-icons.html"><span class="ml-1 item-text">계절별 추천 드라이브 코스</span></a>
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
                <span class="ml-3 item-text">My Car Care & GPS</span>
              </a>
              <ul class="collapse list-unstyled pl-4 w-100" id="forms">
                <li class="nav-item">
                  <a class="nav-link pl-3" href="./form_elements.html"><span class="ml-1 item-text">주행거리 관리</span></a>
                </li>
                <li class="nav-item">
                  <a class="nav-link pl-3" href="./form_advanced.html"><span class="ml-1 item-text">주행거리별 차량점검 List</span></a>
                </li>
                <li class="nav-item">
                  <a class="nav-link pl-3" href="/mypage/ViewTest"><span class="ml-1 item-text">현재 차량 위치</span></a>
                </li>
                <li class="nav-item">
                  <a class="nav-link pl-3" href="/mypage/mapView"><span class="ml-1 item-text">최근 주행 경로</span></a>
                </li>
                <li class="nav-item">
                  <a class="nav-link pl-3" href="/mypage/ViewTest1"><span class="ml-1 item-text">차량 주변 편의시설</span></a>
                </li>
              </ul>
            </li>
            <li class="nav-item dropdown">
              <a href="#tables" data-toggle="collapse" aria-expanded="false" class="dropdown-toggle nav-link">
                <i class="fe fe-grid fe-16"></i>
                <span class="ml-3 item-text">통계자료</span>
              </a>
              <ul class="collapse list-unstyled pl-4 w-100" id="tables">
                <li class="nav-item">
                  <a class="nav-link pl-3" href="/mypage/ViewTest"><span class="ml-1 item-text">지도 테스트 1</span></a>
                </li>
                <li class="nav-item">
                  <a class="nav-link pl-3" href="/mypage/ViewTest1"><span class="ml-1 item-text">지도 테스트 2</span></a>
                </li>
                <li class="nav-item">
                  <a class="nav-link pl-3" href="/mypage/ViewTest2"><span class="ml-1 item-text">지도 테스트 3</span></a>
                </li>
              </ul>
            </li>
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
                  <a class="nav-link pl-3" href="/mypage/myInfoUpdate""><span class="ml-1 item-text">내 정보 수정</span></a>
                </li>
                <li class="nav-item">
                  <a class="nav-link pl-3" href="/mypage/myInfoCar"><span class="ml-1 item-text">등록된 차량 관리</span></a>
                </li>
                <li class="nav-item">
                  <a class="nav-link pl-3" href="/mypage/myInfoDelete"><span class="ml-1 item-text">회원 탈퇴</span></a>
                </li>
              </ul>
            </li>
            <li class="nav-item dropdown">
             <a href="#auth" data-toggle="collapse" aria-expanded="false" class="dropdown-toggle nav-link"> 
                <i class="fe fe-pie-chart fe-16"></i>
                <span class="ml-3 item-text">차량 용품</span>
                 <span class="badge badge-pill badge-primary">업데이트 예정</span>
              </a>
              <ul class="collapse list-unstyled pl-4 w-100" id="auth">
                <li class="nav-item">
                  <a class="nav-link pl-3" href="/mypage/myInfoDelete"><span class="ml-1 item-text">BEST 아이템</span></a>
                </li>
                <li class="nav-item">
                  <a class="nav-link pl-3" href="/mypage/myInfoUpdate""><span class="ml-1 item-text">여름 차량 용품</span></a>
                </li>
                <li class="nav-item">
                  <a class="nav-link pl-3" href="/mypage/myInfoCar"><span class="ml-1 item-text">겨울 차량 용품</span></a>
                </li>
                <li class="nav-item">
                  <a class="nav-link pl-3" href="/mypage/myInfoDelete"><span class="ml-1 item-text">장바구니</span></a>
                </li>
                <li class="nav-item">
                  <a class="nav-link pl-3" href="/mypage/myInfoDelete"><span class="ml-1 item-text">최근결제내역</span></a>
                </li>
                <li class="nav-item">
                  <a class="nav-link pl-3" href="/mypage/myInfoDelete"><span class="ml-1 item-text">배송내역</span></a>
                </li>
              </ul>
            </li>
          </ul>
<!--           <p class="text-muted nav-heading mt-4 mb-1"> -->
<!--             <span>Apps</span> -->
<!--           </p> -->
<!--           <ul class="navbar-nav flex-fill w-100 mb-2"> -->
<!--             <li class="nav-item w-100"> -->
<!--               <a class="nav-link" href="calendar.html"> -->
<!--                 <i class="fe fe-calendar fe-16"></i> -->
<!--                 <span class="ml-3 item-text">Calendar</span> -->
<!--               </a> -->
<!--             </li> -->
<!--             <li class="nav-item dropdown"> -->
<!--               <a href="#contact" data-toggle="collapse" aria-expanded="false" class="dropdown-toggle nav-link"> -->
<!--                 <i class="fe fe-book fe-16"></i> -->
<!--                 <span class="ml-3 item-text">Contacts</span> -->
<!--               </a> -->
<!--               <ul class="collapse list-unstyled pl-4 w-100" id="contact"> -->
<!--                 <a class="nav-link pl-3" href="./contacts-list.html"><span class="ml-1">Contact List</span></a> -->
<!--                 <a class="nav-link pl-3" href="./contacts-grid.html"><span class="ml-1">Contact Grid</span></a> -->
<!--                 <a class="nav-link pl-3" href="./contacts-new.html"><span class="ml-1">New Contact</span></a> -->
<!--               </ul> -->
<!--             </li> -->
<!--             <li class="nav-item dropdown"> -->
<!--               <a href="#profile" data-toggle="collapse" aria-expanded="false" class="dropdown-toggle nav-link"> -->
<!--                 <i class="fe fe-user fe-16"></i> -->
<!--                 <span class="ml-3 item-text">Profile</span> -->
<!--               </a> -->
<!--               <ul class="collapse list-unstyled pl-4 w-100" id="profile"> -->
<!--                 <a class="nav-link pl-3" href="./profile.html"><span class="ml-1">Overview</span></a> -->
<!--                 <a class="nav-link pl-3" href="./profile-settings.html"><span class="ml-1">Settings</span></a> -->
<!--                 <a class="nav-link pl-3" href="./profile-security.html"><span class="ml-1">Security</span></a> -->
<!--                 <a class="nav-link pl-3" href="./profile-notification.html"><span class="ml-1">Notifications</span></a> -->
<!--               </ul> -->
<!--             </li> -->
<!--             <li class="nav-item dropdown"> -->
<!--               <a href="#fileman" data-toggle="collapse" aria-expanded="false" class="dropdown-toggle nav-link"> -->
<!--                 <i class="fe fe-folder fe-16"></i> -->
<!--                 <span class="ml-3 item-text">File Manager</span> -->
<!--               </a> -->
<!--               <ul class="collapse list-unstyled pl-4 w-100" id="fileman"> -->
<!--                 <a class="nav-link pl-3" href="./files-list.html"><span class="ml-1">Files List</span></a> -->
<!--                 <a class="nav-link pl-3" href="./files-grid.html"><span class="ml-1">Files Grid</span></a> -->
<!--               </ul> -->
<!--             </li> -->
<!--             <li class="nav-item dropdown"> -->
<!--               <a href="#support" data-toggle="collapse" aria-expanded="false" class="dropdown-toggle nav-link"> -->
<!--                 <i class="fe fe-compass fe-16"></i> -->
<!--                 <span class="ml-3 item-text">Help Desk</span> -->
<!--               </a> -->
<!--               <ul class="collapse list-unstyled pl-4 w-100" id="support"> -->
<!--                 <a class="nav-link pl-3" href="./support-center.html"><span class="ml-1">Home</span></a> -->
<!--                 <a class="nav-link pl-3" href="./support-tickets.html"><span class="ml-1">Tickets</span></a> -->
<!--                 <a class="nav-link pl-3" href="./support-ticket-detail.html"><span class="ml-1">Ticket Detail</span></a> -->
<!--                 <a class="nav-link pl-3" href="./support-faqs.html"><span class="ml-1">FAQs</span></a> -->
<!--               </ul> -->
<!--             </li> -->
<!--           </ul> -->
<!--           <p class="text-muted nav-heading mt-4 mb-1"> -->
<!--             <span>Extra</span> -->
<!--           </p> -->
<!--           <ul class="navbar-nav flex-fill w-100 mb-2"> -->
<!--             <li class="nav-item dropdown"> -->
<!--               <a href="#pages" data-toggle="collapse" aria-expanded="false" class="dropdown-toggle nav-link"> -->
<!--                 <i class="fe fe-file fe-16"></i> -->
<!--                 <span class="ml-3 item-text">Pages</span> -->
<!--               </a> -->
<!--               <ul class="collapse list-unstyled pl-4 w-100 w-100" id="pages"> -->
<!--                 <li class="nav-item"> -->
<!--                   <a class="nav-link pl-3" href="./page-orders.html"> -->
<!--                     <span class="ml-1 item-text">Orders</span> -->
<!--                   </a> -->
<!--                 </li> -->
<!--                 <li class="nav-item"> -->
<!--                   <a class="nav-link pl-3" href="./page-timeline.html"> -->
<!--                     <span class="ml-1 item-text">Timeline</span> -->
<!--                   </a> -->
<!--                 </li> -->
<!--                 <li class="nav-item"> -->
<!--                   <a class="nav-link pl-3" href="./page-invoice.html"> -->
<!--                     <span class="ml-1 item-text">Invoice</span> -->
<!--                   </a> -->
<!--                 </li> -->
<!--                 <li class="nav-item"> -->
<!--                   <a class="nav-link pl-3" href="./page-404.html"> -->
<!--                     <span class="ml-1 item-text">Page 404</span> -->
<!--                   </a> -->
<!--                 </li> -->
<!--                 <li class="nav-item"> -->
<!--                   <a class="nav-link pl-3" href="./page-500.html"> -->
<!--                     <span class="ml-1 item-text">Page 500</span> -->
<!--                   </a> -->
<!--                 </li> -->
<!--                 <li class="nav-item"> -->
<!--                   <a class="nav-link pl-3" href="./page-blank.html"> -->
<!--                     <span class="ml-1 item-text">Blank</span> -->
<!--                   </a> -->
<!--                 </li> -->
<!--               </ul> -->
<!--             </li> -->
<!--             <li class="nav-item dropdown"> -->
<!--               <a href="#auth" data-toggle="collapse" aria-expanded="false" class="dropdown-toggle nav-link"> -->
<!--                 <i class="fe fe-shield fe-16"></i> -->
<!--                 <span class="ml-3 item-text">Authentication</span> -->
<!--               </a> -->
<!--               <ul class="collapse list-unstyled pl-4 w-100" id="auth"> -->
<!--                 <a class="nav-link pl-3" href="./auth-login.html"><span class="ml-1">Login 1</span></a> -->
<!--                 <a class="nav-link pl-3" href="./auth-login-half.html"><span class="ml-1">Login 2</span></a> -->
<!--                 <a class="nav-link pl-3" href="./auth-register.html"><span class="ml-1">Register</span></a> -->
<!--                 <a class="nav-link pl-3" href="./auth-resetpw.html"><span class="ml-1">Reset Password</span></a> -->
<!--                 <a class="nav-link pl-3" href="./auth-confirm.html"><span class="ml-1">Confirm Password</span></a> -->
<!--               </ul> -->
<!--             </li> -->
<!--             <li class="nav-item dropdown"> -->
<!--               <a href="#layouts" data-toggle="collapse" aria-expanded="false" class="dropdown-toggle nav-link"> -->
<!--                 <i class="fe fe-layout fe-16"></i> -->
<!--                 <span class="ml-3 item-text">Layout</span> -->
<!--               </a> -->
<!--               <ul class="collapse list-unstyled pl-4 w-100" id="layouts"> -->
<!--                 <li class="nav-item"> -->
<!--                   <a class="nav-link pl-3" href="./index.html"><span class="ml-1 item-text">Default</span></a> -->
<!--                 </li> -->
<!--                 <li class="nav-item"> -->
<!--                   <a class="nav-link pl-3" href="./index-horizontal.html"><span class="ml-1 item-text">Top Navigation</span></a> -->
<!--                 </li> -->
<!--                 <li class="nav-item"> -->
<!--                   <a class="nav-link pl-3" href="./index-boxed.html"><span class="ml-1 item-text">Boxed</span></a> -->
<!--                 </li> -->
<!--               </ul> -->
<!--             </li> -->
<!--           </ul> -->
<!--           <p class="text-muted nav-heading mt-4 mb-1"> -->
<!--             <span>#### ??? ###</span> -->
<!--           </p> -->
<!--           <ul class="navbar-nav flex-fill w-100 mb-2"> -->
<!--             <li class="nav-item w-100"> -->
<!--               <a class="nav-link" href="../docs/index.html"> -->
<!--                 <i class="fe fe-help-circle fe-16"></i> -->
<!--                 <span class="ml-3 item-text">??@@@!!#$$$#</span> -->
<!--               </a> -->
<!--             </li> -->
<!--           </ul> -->
          <div class="btn-box w-100 mt-4 mb-1">
            <a href="https://www.google.com/search?q=%EA%B5%AC%EA%B8%80+%EC%B0%A8%EB%9F%89%EC%9A%A9%ED%92%88&sxsrf=ALeKk01YN3m3gLX-Y5fb28t4izQtBP7qUw:1611327302438&source=lnms&tbm=shop&sa=X&ved=2ahUKEwiot-n75a_uAhUMBZQKHc1zDrwQ_AUoAHoECAUQCg&biw=1920&bih=937" target="_blank" class="btn mb-2 btn-primary btn-lg btn-block">
              <i class="fe fe-shopping-cart fe-12 mx-2"></i><span class="small">BEST ITEM 보러가기</span>
            </a>
          </div>
        </nav>
      </aside>
      
      
      <main role="main" class="main-content">	      