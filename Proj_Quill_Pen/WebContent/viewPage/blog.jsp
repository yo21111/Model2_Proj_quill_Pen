<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>마이페이지, 작가페이지</title>
<link rel="stylesheet" href="/style/style_Common.css">
<script src="/source/jquery-3.6.0.min.js"></script>
<script src="/script/script.js"></script>
</head>
<body>
	<div id="wrap">
		<main>
			<!-- section#blog_title : 작가 정보 영역 시작 -->
			<section id="blog_title">
				<div id="blog_title_container">작가 정보 요약 출력(작가명, 소개멘트, 프로필 이미지)</div>
			</section>
			<!-- section#blog_title : 작가 정보 영역 끝 -->

			<!-- section#blog_subs : 작가 구독 영역 시작 -->
			<section id="blog_subs">
				<div id="blog_subs_container">작가 구독관련 출력(구독자수, 관심작가수, 구독하기버튼,
					신고하기버튼)</div>
			</section>
			<!-- section#blog_subs : 작가 구독 영역 끝 -->

			<!-- section#blog_info : 작가 세부 정보 영역 시작 -->
			<section id="blog_info">
				<div id="blog_infos_container">
					<div id="info_content">작가 소개글 출력</div>
					<div id="info_writing">작가가 쓴 글 리스트 출력</div>
				</div>
			</section>
			<!-- section#blog_info : 작가 세부 정보 영역 끝 -->

			<!-- section#hidden : hidden input 영역 시작 -->
			<section id="hidden"></section>
			<!-- section#hidden : hidden input 영역 끝 -->
		</main>

	</div>
</body>
</html>