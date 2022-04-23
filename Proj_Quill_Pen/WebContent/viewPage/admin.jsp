<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>관리자 페이지</title>
<link rel="stylesheet" href="/style/style_Common.css">
<script src="/source/jquery-3.6.0.min.js"></script>
<script src="/script/script.js"></script>
</head>
<body>
	<div id="wrap">
		<main>
			<!-- section#noticeList : 공지사항 영역 시작 -->
			<section id="noticeList">
				<div id="noticeList_title">공지사항 영역 제목</div>
				<div id="noticeList_container">공지사항 목록 출력</div>
			</section>
			<!-- section#noticeList : 공지사항 영역 끝 -->

			<!-- section#reportList : 신고목록 영역 시작 -->
			<section id="reportList">
				<div id="reportList_title">신고 영역 제목</div>
				<div id="reportList_container">신고 접수 목록 출력</div>
			</section>
			<!-- section#reportList : 신고목록 영역 끝 -->

			<!-- section#bookList : 책소개 영역 시작 -->
			<section id="bookList">
				<div id="bookList_title">책소개 영역 제목</div>
				<div id="bookList_container">책소개 목록 출력</div>
			</section>
			<!-- section#bookList : 책소개 영역 끝 -->

			<!-- section#hidden : hidden input 영역 시작 -->
			<section id="hidden"></section>
			<!-- section#hidden : hidden input 영역 끝 -->
		</main>
	</div>
</body>
</html>