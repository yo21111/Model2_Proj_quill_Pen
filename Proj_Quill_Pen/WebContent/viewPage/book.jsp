<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>책방 페이지</title>
<link rel="stylesheet" href="/Proj_Quill_Pen/style/style_Common.css">
<script src="/Proj_Quill_Pen/source/jquery-3.6.0.min.js"></script>
<script src="/Proj_Quill_Pen/script/script.js"></script>
</head>
<body>
	<jsp:include page="/ind/headerTmp.jsp" />
	<div id="wrap">
		<main>
			<!-- section#book_slide : 책 리스트 슬라이드 영역 시작 -->
			<section id="book_slide">
				<div id="book_slide_title">슬라이드 영역 제목</div>
				<div id="book_slide_container" class="dFlex">
					<!-- ///////////////////// 반복 영역 시작 ///////////////////// -->
					<div class="book_book_container">
						<div class="book_img">책 이미지</div>
						<div class="book_title">책 제목</div>
						<div class="book_writer">책 저자</div>
					</div>
					<!-- div.book_book_container -->

					<!-- ///////////////////// 반복 영역 끝 ///////////////////// -->
				</div>
				<!-- div#book_slide_container -->

				<div id="book_slide_nav">슬라이드 네비게이션 부분</div>
			</section>
			<!-- section#book_slide : 책 리스트 슬라이드 영역 끝 -->

			<!-- section#book_info : 책 세부 정보 출력 영역 끝 -->
			<section id="book_info" class="dFlex">
				<div id="info_left">
					<div id="book_info_container">
						<div id="book_info_title">책 제목 출력</div>
						<!-- div#book_info_title -->
						<div id="book_info_content" class="dFlex">
							<div id="book_info_content_left">
								<div id="book_info_content_intro">책 소개글 구역</div>
								<div id="book_info_content_btn">
									<button type="button">책 구매하기</button>
								</div>
							</div>
							<!-- div#book_info_content_left -->
							<div id="book_info_content_img">책 이미지</div>
						</div>
						<!-- div#book_info_content -->
					</div>
					<!-- div#book_info_container -->
				</div>
				<!-- div#info_left -->
				<div id="info_right">
					<div id="writer_img">작가 이미지</div>
					<div id="writer_name">작가이름</div>
					<div id="writer_content">작가 소개멘트</div>
					<div id="writer_subBtn">
						<button type="button">구독하기</button>
					</div>
				</div>
				<!-- div#info_right -->
			</section>
			<!-- section#book_info : 책 세부 정보 출력 영역 끝 -->

			<!-- section#hidden : hidden input 영역 시작 -->
			<section id="hidden"></section>
			<!-- section#hidden : hidden input 영역 끝 -->
		</main>
	</div>
	<jsp:include page="/ind/footerTmp.jsp" />
</body>
</html>