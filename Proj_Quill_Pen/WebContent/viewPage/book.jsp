<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>책방 페이지</title>
<link rel="stylesheet" href="/Proj_Quill_Pen/style/style_Common.css">
<link rel="stylesheet" href="/Proj_Quill_Pen/style/style_book.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script src="/Proj_Quill_Pen/script/script_book.js"></script>
</head>
<body>
	<jsp:include page="/ind/headerTmp.jsp" />
	<div id="wrap">
		<main>
			<!-- section#book_slide : 책 리스트 슬라이드 영역 시작 -->
			<section id="book_slide">
				<div id="book_slide_title">
					<h2>${pageTitle}</h2>
				</div>
				<div id="book_slide_container" class="dFlex" data-positionX="0">
					<!-- ///////////////////// 반복 영역 시작 ///////////////////// -->
					<c:forEach items="${bookList}" var="BookBean">
						<div class="book_book_container">
							<div class="book_img">
								<img src="/Proj_Quill_Pen/images/test/${BookBean.fileName}"
									alt="${BookBean.title}">
							</div>
							<div class="book_title">${BookBean.title}</div>
							<div class="book_writer">${BookBean.writer}</div>
							<div class="book_hidden">
								<input type="hidden" class="no" value="${BookBean.bookNo}">
								<input type="hidden" class="fileName" value="${BookBean.fileName}">
								<input type="hidden" class="subTitle" value="${BookBean.subTitle}">
								<input type="hidden" class="imageName" value="${BookBean.imageName}">
								<input type="hidden" class="link" value="${BookBean.link}">
							</div>
						</div>
						<!-- div.book_book_container -->

					</c:forEach>
					<!-- ///////////////////// 반복 영역 끝 ///////////////////// -->
				</div>
				<!-- div#book_slide_container -->

				<div id="book_slide_nav" class="dFlex">
					<div id="left">&lt;</div>
					<div id="right">&gt;</div>
				</div>
			</section>
			<!-- section#book_slide : 책 리스트 슬라이드 영역 끝 -->

			<!-- section#book_info : 책 세부 정보 출력 영역 끝 -->
			<section id="book_info" class="dFlex">
				<div id="info_left">
					<div id="book_info_container">
						<div id="book_info_title">책 제목 출력</div>
						<input type="hidden" id="book_info_no" name="bookNo">
						<!-- div#book_info_title -->
						<div id="book_info_content" class="dFlex">
							<div id="book_info_content_left">
								<div id="book_info_content_intro">
									<div id="content_img">
										<img src="/Proj_Quill_Pen/images/test/imageName_1.PNG" alt="한줄평">
									</div>
									<div id="content_subTitle">한줄평</div>
								</div>
								<div id="book_info_content_btn">
									<button type="button">책 구매하기</button>
									<input type="hidden">
								</div>
							</div>
							<!-- div#book_info_content_left -->
							<div id="book_info_content_img">
								<img src="/Proj_Quill_Pen/images/test/5398915.jpeg" alt="책이미지">
							</div>
						</div>
						<!-- div#book_info_content -->
					</div>
					<!-- div#book_info_container -->
				</div>
				<!-- div#info_left -->
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