<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
request.setCharacterEncoding("UTF-8");

%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>로그인 페이지</title>
<link rel="stylesheet" href="/Proj_Quill_Pen/style/style_Common.css">
<script src="/Proj_Quill_Pen/source/jquery-3.6.0.min.js"></script>
<script src="/Proj_Quill_Pen/script/script.js"></script>
</head>
<body>
	<jsp:include page="/ind/headerTmp.jsp" />
	<div id="wrap">
		<main>
		<!-- form 영역 시작 -->
			<form id="login_Frm" method="post" action="">
				<!-- section#login : 로그인 페이지 시작 -->
				<section id="login">
					<div id="login_title">로그인 제목 출력</div>
					<!-- div#login_title -->
					<div id="login_error">로그인 유효성검사 안내 멘트(없을 때는 빈칸)</div>
					<!-- div#login_error -->
					<div id="login_idInput">
						아이디 입력하기<input type="text">
					</div>
					<!-- div#login_idInput -->
					<div id="login_pwInput">
						비밀번호 입력하기<input type="text">
					</div>
					<!-- div#login_pwInput -->
					<div id="login_util" class="dFlex">
						<p>
							<input type="checkbox">보안접속
						</p>
						<p>
							<button type="button">아이디/비밀번호 찾기</button>
						</p>
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
			<section id="hidden"></section>
			<!-- section#hidden : hidden input 영역 끝 -->
			</form>
			<!-- form 영역 끝 -->
		</main>
	</div>
	<jsp:include page="/ind/footerTmp.jsp" />
</body>
</html>