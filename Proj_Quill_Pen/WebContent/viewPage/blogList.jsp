<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>작가 조회페이지</title>
<link rel="stylesheet" href="/Proj_Quill_Pen/style/style_Common.css">
<script src="/Proj_Quill_Pen/source/jquery-3.6.0.min.js"></script>
<script src="/Proj_Quill_Pen/script/script.js"></script>
</head>
<body>
	<div id="wrap">
		<main>
			<!-- section#blogList_title : 작가 게시판 제목 영역 시작 -->
			<section id="blogList_title">
				<div id="blogList_title_container">작가 게시판 제목</div>
			</section>
			<!-- section#blogList_title : 작가 게시판 제목 영역 끝 -->

			<!-- section#blogList_content : 작가 게시판 영역 시작 -->
			<section id="blogList_content">
				<div id="blogList_content_container" class="dFlex">
					<div class="writer">
						<div class="writer_img">작가 프로필 이미지</div>
						<div class="writer_name">작가명</div>
						<div class="writer_title">작가 소개 멘트</div>
						<div class="writer_content">작가 소개글</div>
					</div>
					<!-- div.writer -->
				</div>
				<!-- div#blogList_content_container -->
			</section>
			<!-- section#blog_info : 작가 게시판 영역 끝 -->

			<!-- section#hidden : hidden input 영역 시작 -->
			<section id="hidden"></section>
			<!-- section#hidden : hidden input 영역 끝 -->
		</main>

	</div>
</body>
</html>