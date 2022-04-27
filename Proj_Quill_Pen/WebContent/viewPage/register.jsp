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
<link rel="stylesheet" href="/Proj_Quill_Pen/style/style_register.css">
<script src="/Proj_Quill_Pen/source/jquery-3.6.0.min.js"></script>
<script src="/Proj_Quill_Pen/script/script_register.js"></script>
</head>
<body>
	<jsp:include page="/ind/headerTmp.jsp" />
	<div id="wrap">
		<main>
			<!-- //////////////// 회원가입 폼 시작 //////////////// -->
			<form id="register_Frm" method="post" action="">
				<!-- section#register : 회원가입 영역 시작 -->
				<section id="register">
					<div id="register_title">
						<h1>Quill Pen 회원가입</h1>
					</div>
					<!-- div#register_title -->
					
					<div id="register_id" class="dFlex">
						<span class="field">아이디</span>
						<input type="text" name="uId" maxlength="20">
						<button type="button" id="idChkBtn">아이디 중복 확인</button>
					</div>
					<!-- div#register_id -->
					<div id="register_idValid">아이디는 3~20글자, 영문,숫자만 입력 가능합니다.</div>
					<!-- div#register_idValid -->
					
					<div id="register_writer" class="dFlex">
						<span class="field">작가명</span>
						<input type="text" name="writer" maxlength="10">
						<button type="button" id="writerChkBtn">작가명 중복 확인</button>
					</div>
					<!-- div#register_writer -->
					<div id="register_writerValid">작가명은 2~10글자, 한글만 입력 가능합니다.</div>
					<!-- div#register_writerValid -->
					
					<div id="register_pw" class="dFlex">
						<span class="field">비밀번호</span>
						<input type="password" name="uPw" maxlength="20">
					</div>
					<!-- div#register_pw -->
					<div id="register_pwValid">비밀번호는 6~20글자, 영어, 숫자, 특수문자만 입력 가능합니다.</div>
					<!-- div#register_pwValid -->
					<div id="register_pwCheck" class="dFlex">
						<span class="field">비밀번호 확인</span>
						<input type="password" maxlength="20">
					</div>
					<!-- div#register_pwCheck -->
					<div id="register_pwCheckValid">입력한 비밀번호와 동일한 값을 입력해 주세요.</div>
					<!-- div#register_pwCheckValid -->
					
					<div id="register_name" class="dFlex">
						<span class="field">이름</span>
						<input type="text" name="uName">
					</div>
					<!-- div#register_name -->
					<div id="register_nameValid">이름을 입력해 주세요.</div>
					<!-- div#register_nameValid -->
					
					<div id="register_email" class="dFlex">
						<span class="field">이메일</span>
						<input type="text" id="uEmail_01" maxlength="20" size="7">
						<span id="sepTxt">@</span>
						<input type="text" id="uEmail_02" maxlength="40" size="10">
	   					<select id="emailDomain">
							<option value="">직접입력</option>
							<option>naver.com</option>
							<option>daum.net</option>
							<option>google.com</option>
						</select>
					</div>
					<!-- div#register_email -->
					<div id="register_emailValid">이메일을 입력해 주세요</div>
					<!-- div#register_emailValid -->
					
					<div id="register_phone" class="dFlex">
						<span class="field">휴대폰 번호</span>
						<input type="text" name="uPhone" maxlength="11">
						<button type=button id="confirmBtn">인증하기</button>
					</div>
					<!-- div#register_phone -->
					<div id="register_phoneValid">휴대폰 번호를 입력해 주세요.</div>
					<!-- div#register_phoneValid -->
					
					<div id="register_birth" class="dFlex">
						<span class="field">생년월일</span>
						<input type="text" name="uBirth" maxlength="8">
					</div>
					<!-- div#register_birth -->
					<div id="register_birthValid">생년월일을 입력해 주세요.</div>
					<!-- div#register_birthValid -->
					
				</section>
				<!-- section#register : 회원가입 영역 끝 -->

				<!-- section#agreement : 이용약관 동의 시작 -->
				<section id="agreement">
					<div id="agreement_content" class="dFlex">
						<iframe src="/Proj_Quill_Pen/viewPage/joinAgreement.jsp" id="blogAgreeFrame"></iframe>
					</div>
				</section>
				<!-- section#agreement : 이용약관 동의 끝 -->

				<!-- section#registerBtn : 회원가입 버튼 시작 -->
				<section id="registerBtn">
					<div id="registerBtnArea">
						<button type="button" id="registerSubBtn">회원가입</button>
					</div>
				</section>
				<!-- section#registerBtn : 회원가입 버튼 끝 -->

				<!-- section#hidden : hidden input 영역 시작 -->
				<section id="hidden">
					<input type="hidden" name="uEmail" id="uEmail">
				</section>
				<!-- section#hidden : hidden input 영역 끝 -->
			</form>
			<!-- //////////////// 회원가입 폼 끝 //////////////// -->
		</main>
	</div>
	<jsp:include page="/ind/footerTmp.jsp" />
</body>
</html>