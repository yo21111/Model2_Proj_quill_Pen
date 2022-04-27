<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>로그인 페이지</title>
<link rel="stylesheet" href="/Proj_Quill_Pen/style/style_Common.css">
<link rel="stylesheet" href="/Proj_Quill_Pen/style/style_login.css">
</head>
<body>
	<jsp:include page="/ind/headerTmp.jsp" />
	<div id="wrap">
		<main>
			<!-- form 영역 시작 -->
			<form id="login_Frm" method="post" action="/Proj_Quill_Pen/login">
				<!-- section#login : 로그인 페이지 시작 -->
				<section id="login">
					<div id="login_title">
						<h2>quill pen 시작하기</h2>
					</div>
					<!-- div#login_title -->
					<div id="login_error">${errorMsg}</div>
					<!-- div#login_error -->
					<div id="login_idInput">
						<input type="text" name="uId" placeholder="아이디를 입력해주세요">
					</div>
					<!-- div#login_idInput -->
					<div id="login_pwInput">
						<input type="password" name="uPw" placeholder="비밀번호를 입력해주세요">
					</div>
					<!-- div#login_pwInput -->
					<div id="login_util" class="dFlex">
						<div>
							<input type="checkbox" name="rememId">아이디 기억하기
						</div>
						<div id="findInfo" class="dFlex">
							<div id="id">
								<a href="/Proj_Quill_Pen/login?find=id">아이디</a>
							</div>
							/
							<div id="pw">
								<a href="/Proj_Quill_Pen/login?find=pw">비밀번호 찾기</a>
							</div>
						</div>
					</div>
					<!-- div#login_util -->
					<div id="login_loginBtn">
						<button type="button">로그인</button>
					</div>
					<!-- div#login_loginBtn -->
					<div id="login_registerBtn">
						<button type="button">회원가입</button>
					</div>
					<!-- div#login_registerBtn -->
				</section>
				<!-- section#login : 탈퇴하기 페이지 끝 -->

				<!-- section#hidden : hidden input 영역 시작 -->
				<section id="hidden">
					<input type="hidden" id="rememId" value="${rememId}">
					<input type="hidden" id="updateComp" value="${updateComp}">
				</section>
				<!-- section#hidden : hidden input 영역 끝 -->
			</form>
			<!-- form 영역 끝 -->
		</main>
	</div>
	<jsp:include page="/ind/footerTmp.jsp" />
	<script src="/Proj_Quill_Pen/source/jquery-3.6.0.min.js"></script>
	<script src="/Proj_Quill_Pen/script/script_login.js"></script>
</body>
</html>