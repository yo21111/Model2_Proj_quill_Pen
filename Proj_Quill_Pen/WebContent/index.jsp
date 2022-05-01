<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Quill Pen</title>
<link rel="stylesheet" href="/Proj_Quill_Pen/style/style_Common.css">
<link rel="stylesheet" href="/Proj_Quill_Pen/style/style_index.css">
</head>
<body>
	<jsp:include page="/ind/headerTmp.jsp" />
	<div id="wrap">
		<main>
			<!-- section#mainTitle : 메인페이지 제목 영역 시작 -->
			<section id="mainTitle">
				<div id="mainTitle_container">
					<p>성장의 가장 강력한 원리는 인간의 선택에 있다. (G. 엘리어트)</p>
					<p>추구할 수 있는 용기가 있다면 우리의 모든 꿈은 이뤄질 수 있다. (W. 디즈니)</p>
					<p>남들이 할 수 있거나 하려는 일을 하지 말고 남들이 할 수 없거나 하지 않으려는 일을 하라. (A.
						에어하트)</p>
				</div>
			</section>
			<!-- section#mainTitle : 메인페이지 제목 영역 끝 -->

			<!-- section#notice : 공지사항 영역 시작 -->
			<section id="notice" class="dFlex">
				<div id="notice_container">
					<!-- ///////////////////// 반복 영역 시작 ///////////////////// -->
					<c:forEach items="${noticeList}" var="NoticeBean">
						<div class="notice_Content">
							<input type="hidden" class="noticeBno" name="bno" value="${NoticeBean.bno}">
							<a href="#" class="noticeLink"> <span>Notice</span>${NoticeBean.title}
							</a>
						</div>
						<!-- div.notice_Content -->

					</c:forEach>
					<!-- ///////////////////// 반복 영역 끝 ///////////////////// -->
				</div>
			</section>
			<!-- section#notice : 공지사항 영역 끝 -->

			<section id="imgSlide">
				<div id="book_slide_title">
					<h2>
						<a href="/Proj_Quill_Pen/book"> Quill Pen에 담긴 아름다운 작품을 감상해
							보세요. </a>
					</h2>
				</div>
				<div id="imgSlide_img" class="dFlex" data-positionX="0">
					<!-- ///////////////////// 반복 영역 시작 ///////////////////// -->
					<c:forEach items="${bookList}" var="BookBean">
						<div class="book_book_container">
							<div class="book_img">
								<a href="${BookBean.link}"><img
									src="/Proj_Quill_Pen/images/test/${BookBean.fileName}"
									alt="${BookBean.title}"></a>
							</div>
							<div class="book_title">${BookBean.title}</div>
							<div class="book_writer">${BookBean.writer}</div>
							<div class="book_hidden">
								<input type="hidden" class="no" value="${BookBean.bookNo}">
								<input type="hidden" class="link" value="${BookBean.link}">
							</div>
						</div>
						<!-- div.book_book_container -->

					</c:forEach>
					<!-- ///////////////////// 반복 영역 끝 ///////////////////// -->
				</div>
				<!-- div#book_slide_container -->

				<div id="imgSlide_nav" class="dFlex">
					<div id="left">&#10094;</div>
					<div id="right">&#10095;</div>
				</div>
			</section>
			<!-- section#book_slide : 책 리스트 슬라이드 영역 끝 -->


			<!-- section#category : 카테고리 영역 시작 -->
			<section id="category">
				<div id="category_title">
					<h2>Quill Pen Category</h2>
					<h4>키워드로 분류된 다양한 글 모음</h4>
				</div>
				<div id="category_container">
					<ul class="dFlex">
						<li><a href="/Proj_Quill_Pen/bbs?category=1">카테고리1</a></li>
						<li><a href="/Proj_Quill_Pen/bbs?category=2">카테고리2</a></li>
						<li><a href="/Proj_Quill_Pen/bbs?category=3">카테고리3</a></li>
						<li><a href="/Proj_Quill_Pen/bbs?category=4">카테고리4</a></li>
						<li><a href="/Proj_Quill_Pen/bbs?category=5">카테고리5</a></li>
						<li><a href="/Proj_Quill_Pen/bbs?category=6">카테고리6</a></li>
					</ul>
				</div>
			</section>
			<!-- section#category : 카테고리 영역 끝 -->

			<section id="writer">
				<div id="writer_title">
					<h2>Quill Pen Writer</h2>
					<h4>Quill Pen에서 추천하는 작가들</h4>
				</div>
				<div id="writer_container" class="dFlex">
					<!-- ///////////////////// 반복 영역 시작 ///////////////////// -->
					<c:forEach items="${writerList}" var="WriterBean">
						<div class="writer_Content">
							<div class="writer_img">
								<img src="/Proj_Quill_Pen/images/test/${WriterBean.fileName}" alt="${WriterBean.writer}">
							</div>
							<div class="writer_name">${WriterBean.writer}</div>
							<div class="writer_title">${WriterBean.title}</div>
							<div class="writer_content">${WriterBean.content}</div>
							
						</div>
						<!-- div.notice_Content -->
					</c:forEach>
					<!-- ///////////////////// 반복 영역 끝 ///////////////////// -->
				</div>
			</section>
			<!-- section#writer -->

		</main>
	</div>
	<!--div#wrap-->
	<jsp:include page="/ind/footerTmp.jsp" />
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
	<script src="/Proj_Quill_Pen/script/script_index.js"></script>
</body>
</html>