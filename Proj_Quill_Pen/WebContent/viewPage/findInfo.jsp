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
<title>아이디/비밀번호 찾기 페이지</title>
<link rel="stylesheet" href="/Proj_Quill_Pen/style/style_Common.css">
<script src="/Proj_Quill_Pen/source/jquery-3.6.0.min.js"></script>
<script src="/Proj_Quill_Pen/script/script.js"></script>
</head>
<body>
	<jsp:include page="/ind/headerTmp.jsp" />
	<div id="wrap">
		<main>
		<!-- form 영역 시작 -->
		<form id= "findinfo_Btn" method="post" action="">
			<!-- section#findinfo : 아이디/비밀번호 찾기 페이지 시작 -->
			<section id="findinfo">
				<div id="findinfo_title">아이디/비밀번호 찾기 제목 출력</div>
				<!-- div#findinfo_title -->
				<div class="findinfo_input_title">input 제목 부분1</div>
				<!-- div.findinfo_input_title -->
				<div class="findinfo_input">
					input 입력 부분1<input type="text">
				</div>
				<!-- div.findinfo_input -->
				<div class="findinfo_input_title">input 제목 부분2</div>
				<!-- div.findinfo_input_title -->
				<div class="findinfo_input">
					input 입력 부분2<input type="text">
				</div>
				<!-- div.findinfo_input -->
				<div id="findinfo_result">찾은 결과 확인 부분</div>
				<!-- div#findinfo_result -->
				<div id="findinfo_findinfoBtn">
					<button type="button">아이디/비밀번호 찾기</button>
				</div>
				<!-- div#findinfo_findinfoBtn -->
				<div id="findinfo_findinfoBtn">
					<button type="button">아이디/비밀번호 찾기로 이동</button>
				</div>
				<!-- div#findinfo_findinfoBtn -->
				<div id="findinfo_loginBtn">
					<button type="button">로그인</button>
				</div>
				<!-- div#findinfo_loginBtn -->
			</section>
			<!-- section#findinfo : 아이디/비밀번호 찾기 페이지 끝 -->

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