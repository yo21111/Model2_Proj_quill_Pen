<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Quill Pen</title>
<link rel="stylesheet" href="/Proj_Quill_Pen/style/style_Common.css">
</head>
<body>
	<jsp:include page="/ind/headerTmp.jsp" />
	<div id="wrap">
		<main>
			<!-- section#mainTitle : 메인페이지 제목 영역 시작 -->
			<section id="mainTitle">
				<div id="mainTitle_container">메인페이지 사이트 소개글</div>
			</section>
			<!-- section#mainTitle : 메인페이지 제목 영역 끝 -->

			<!-- section#notice : 공지사항 영역 시작 -->
			<section id="notice" class="dFlex">
				<div id="notice_container">공지사항 출력부분</div>
			</section>
			<!-- section#notice : 공지사항 영역 끝 -->

			<!-- section#imgSlide : 이미지 슬라이드 영역 시작 -->
			<section id="imgSlide">
				<div id="imgSlide_img">이미지 영역</div>
				<div id="imgSlide_nav">슬라이드 내비게이션 영역</div>
			</section>
			<!-- section#imgSlide : 이미지 슬라이드 영역 끝 -->

			<!-- section#category : 카테고리 영역 시작 -->
			<section id="category">
				<div id="category_title">카테고리 영역 제목</div>
				<div id="category_container">
					<ul class="dFlex">
						<li>카테고리1</li>
						<li>카테고리2</li>
						<li>카테고리3</li>
					</ul>
					<ul class="dFlex">
						<li>카테고리1</li>
						<li>카테고리2</li>
						<li>카테고리3</li>
					</ul>

				</div>
			</section>
			<!-- section#category : 카테고리 영역 끝 -->
		</main>
	</div>
	<!--div#wrap-->
	<jsp:include page="/ind/footerTmp.jsp" />
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
	<script src="/Proj_Quill_Pen/script/script.js"></script>
</body>
</html>