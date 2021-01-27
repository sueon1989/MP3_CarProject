<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>


<%@include file="/WEB-INF/views/includes/header.jsp"%>
<div class="container-fluid">
	<div class="row justify-content-center">
		<div class="col-12">

<!-- 기본 화면 -->
<h2 class="mb-2 page-title">차량 관리 프로그램</h2>
<hr class="my-4">
<body class="light ">
	<!-- 로그인하지 않은 경우 -->
	<sec:authorize access="isAnonymous()">
				<p><em>로그인후 이용하세요.</em></p>
		      <button type="button" class="btn mb-2 btn-outline-info" onclick = "location.href = '/customLogin'">로그인</button><br>
		      <button type="button" class="btn mb-2 btn-outline-info" onclick = "location.href = '/member/register'">회원가입</button>
	</sec:authorize>
	
	
			<!-- 로그인한 경우 -->
			<sec:authorize access="isAuthenticated()">

				<form role="form" action="/mypage/myInfoUpdatePassCheck"
					method="post" class="col-lg-6 col-md-8 col-10 mx-auto">
					<hr class="my-4">
					<h2 class="mb-2 page-title">내 정보</h2>
					<div class="row my-4">
						<!-- Small table -->
						<div class="col-md-12">
							<div class="card shadow">
								<div class="card-body">


									<!--           <div class="form-group"> -->
									<!--             <label for="input1">아이디</label> -->
									<%--             <input type="text" class="form-control" id="member_id" name="member_id" value="${member.member_id}" required> --%>
									<!--           </div> -->
									<!--           <div class="form-group"> -->
									<!--             <label for="input2">비밀번호</label> -->
									<!--             <input type="password" class="form-control" id="member_pass" name="member_pass" value="" required> -->
									<!--           </div> -->
									<div class="form-group">
										<label for="input3">이름</label> <input type="text"
											class="form-control" id="member_name" name="member_name"
											value="<sec:authentication property="principal.member.member_name"/>"
											required>
									</div>
									<div class="form-group">
										<label for="input4">성별</label> <input type="text"
											class="form-control" id="member_gender" name="member_gender"
											value="<sec:authentication property="principal.member.member_gender"/>"
											required>
									</div>
									<div class="form-group">
										<label for="input5">생년월일</label> <input type="date"
											class="form-control" id="input5" name="member_birth"
											value="<sec:authentication property="principal.member.member_birth"/>"
											required>
									</div>
									<div class="form-group">
										<label for="input6">전화번호</label> <input type="text"
											class="form-control" id="member_phone" name="member_phone"
											value="<sec:authentication property="principal.member.member_phone"/>"
											required>
									</div>
									<div class="form-group">
										<label for="input7">주소</label> <input type="text"
											class="form-control" id="member_address"
											name="member_address"
											value="<sec:authentication property="principal.member.member_address"/>"
											required>
									</div>
									<div class="form-group">
										<label for="input8">메일</label> <input type="text"
											class="form-control" id="member_mail" name="member_mail"
											value="<sec:authentication property="principal.member.member_mail"/>"
											required>
									</div>
									<div class="form-group">
										<label for="input9">메일수신여부</label> <input type="text"
											class="form-control" id="member_mailaccept"
											name="member_mailaccept"
											value="<sec:authentication property="principal.member.member_mailaccept"/>"
											required>
									</div>

									<input type="hidden" name="member_no" id="member_no"
										value="<sec:authentication property="principal.member.member_no"/>" />

									<hr class="my-4">


									<button class="btn btn-lg btn-primary btn-block" type="submit">수정하기</button>
									<p class="mt-5 mb-3 text-muted text-center">© 2020</p>

									<!-- CSRF (Cross-site Request Forgery) 토큰: CSRF(사이트간 요청 위조) 방지 -->
									<input type="hidden" name="${_csrf.parameterName}"
										value="${_csrf.token}" />
									<%-- ${_csrf.parameterName}: 실제 브라우저에서는 "_csrf"라는 이름으로 처리됨 --%>
								</div>
							</div>
						</div>
					</div>

				</form>

			</sec:authorize>

			<!-- 관리자로 로그인한 경우 -->
			<sec:authorize access="hasRole('ROLE_ADMIN')">
				관리자는 탈퇴 안됨 ...... 구현준비중
	</sec:authorize>

		</div>
	</div>
	<script src="/resources/light/js/jquery.min.js"></script>
	<script src="/resources/light/js/popper.min.js"></script>
	<script src="/resources/light/js/moment.min.js"></script>
	<script src="/resources/light/js/bootstrap.min.js"></script>
	<script src="/resources/light/js/simplebar.min.js"></script>
	<script src='/resources/light/js/daterangepicker.js'></script>
	<script src='/resources/light/js/jquery.stickOnScroll.js'></script>
	<script src="/resources/light/js/tinycolor-min.js"></script>
	<script src="/resources/light/js/config.js"></script>
	<script src="/resources/light/js/apps.js"></script>
	<!-- Global site tag (gtag.js) - Google Analytics -->
	<!-- <script async src="https://www.googletagmanager.com/gtag/js?id=UA-56159088-1"></script>
    <script>
      window.dataLayer = window.dataLayer || [];

      function gtag()
      {
        dataLayer.push(arguments);
      }
      gtag('js', new Date());
      gtag('config', 'UA-56159088-1');
    </script> -->
</body>
			</html>
			</body>
			</html>