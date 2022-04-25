<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
request.setCharacterEncoding("UTF-8");
String uId_Session = (String) session.getAttribute("uId_Session");

%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>회원가입 페이지</title>
<link rel="stylesheet" href="/Proj_Quill_Pen/style/style_Common.css">
<script src="/Proj_Quill_Pen/source/jquery-3.6.0.min.js"></script>
<script src="/Proj_Quill_Pen/script/script.js"></script>
</head>
<body>
	<jsp:include page="/ind/headerTmp.jsp" />
	<div id="wrap">
		<main>
			<!-- //////////////// 회원가입 폼 시작 //////////////// -->
			<form id="register_Frm" method="post" action="">
				<!-- section#register : 회원가입 영역 시작 -->
				<section id="register">
					<div id="register_title">회원가입 제목 출력</div>
					<!-- div#register_title -->
					<div id="register_id" class="dFlex">
						<span>아이디 입력</span><input type="text">
						<button type="button">중복검사</button>
					</div>
					<!-- div#register_id -->
					<div id="register_idValid">아이디 유효성 검사</div>
					<!-- div#register_idValid -->
					<div id="register_writer" class="dFlex">
						<span>작가명 입력</span><input type="text">
						<button type="button">중복검사</button>
					</div>
					<!-- div#register_writer -->
					<div id="register_idValid">작가명 유효성 검사</div>
					<!-- div#register_idValid -->
					<div id="register_pw" class="dFlex">
						<span>비밀번호 입력</span><input type="text">
					</div>
					<!-- div#register_pw -->
					<div id="register_pwValid">비밀번호 유효성 검사</div>
					<!-- div#register_pwValid -->
					<div id="register_pwCheck" class="dFlex">
						<span>비밀번호 확인</span><input type="text">
					</div>
					<!-- div#register_pwCheck -->
					<div id="register_pwCheckValid">비밀번호 확인 유효성 검사</div>
					<!-- div#register_pwCheckValid -->
					<div id="register_name" class="dFlex">
						<span>이름</span><input type="text">
					</div>
					<!-- div#register_name -->
					<div id="register_email" class="dFlex">
						<span>이메일</span><input type="text"> @ <input type="text">
					</div>
					<!-- div#register_email -->
					<div id="register_phone" class="dFlex">
						<span>휴대폰 번호</span><input type="text"><input type="text"><input
							type="text">
					</div>
					<!-- div#register_phone -->
					<div id="register_birth" class="dFlex">
						<span>생년월일</span><input type="text">
					</div>
					<!-- div#register_birth -->
				</section>
				<!-- section#register : 회원가입 영역 끝 -->

				<!-- section#agreement : 이용약관 동의 시작 -->
				<section id="agreement">
					<div id="agreement_content" class="dFlex">이용약관 동의 내용</div>
				</section>
				<!-- section#agreement : 이용약관 동의 끝 -->

				<!-- section#registerBtn : 회원가입 버튼 시작 -->
				<section id="registerBtn">
					<div id="registerBtnArea">
						<button type="button">회원가입</button>
					</div>
				</section>
				<!-- section#registerBtn : 회원가입 버튼 끝 -->

				<!-- section#hidden : hidden input 영역 시작 -->
				<section id="hidden"></section>
				<!-- section#hidden : hidden input 영역 끝 -->
			</form>
			<!-- //////////////// 회원가입 폼 끝 //////////////// -->
		</main>
	</div>
	<jsp:include page="/ind/footerTmp.jsp" />
</body>
</html>