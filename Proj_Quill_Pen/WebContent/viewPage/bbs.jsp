<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>게시판 글 목록 출력 페이지</title>
<link rel="stylesheet" href="/Proj_Quill_Pen/style/style_Common.css">
<script src="/Proj_Quill_Pen/source/jquery-3.6.0.min.js"></script>
<script src="/Proj_Quill_Pen/script/script.js"></script>
</head>
<body>
	<div id="wrap">

		<main>
			<!-- section#bbs_title : 게시판 제목 영역 시작 -->
			<section id="bbs_title">
				<div id="bbs_title_container">게시판 제목 출력</div>
			</section>
			<!-- section#bbs_title : 게시판 제목 영역 끝 -->

			<!-- section#bbs : 신고목록 영역 시작 -->
			<section id="bbs">
				<div id="bbs_container">게시글 영역 출력</div>
			</section>
			<!-- section#reportList : 신고목록 영역 끝 -->

			<!-- section#hidden : hidden input 영역 시작 -->
			<section id="hidden"></section>
			<!-- section#hidden : hidden input 영역 끝 -->
		</main>

	</div>
</body>
</html>