<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>게시판 글 목록 출력 페이지</title>
<link rel="stylesheet" href="/Proj_Quill_Pen/style/style_bbs.css">
<script src="/Proj_Quill_Pen/source/jquery-3.6.0.min.js"></script>
<script src="/Proj_Quill_Pen/script/script.js"></script>
</head>
<body>
	<jsp:include page="/ind/headerTmp.jsp" />
	<div id="wrap">

		<main>
			<!-- section#bbs_title : 게시판 제목 영역 시작 -->
			<section id="bbs_title">
				<div id="bbs_title_container">
					<h1>Quill Pen 모두가 작가가 되는 공간</h1>
				</div>
			</section>
			<!-- section#bbs_title : 게시판 제목 영역 끝 -->

			<div id="btn_bbs">
				<button id="write_Btn" type="button">글쓰기</button>
			</div>

			<!-- section#bbs : 게시판 목록 영역 시작 -->
			<section id="bbs">


				<div id="bbs_container">
						<c:choose>
							<c:when test="${bbsList eq null}">
								<div id="content_null">게시글이 아직 없습니다. quill pen과 함께 글쓰기를 시작해보세요!</div>
							</c:when>
							<c:when test="${bbsList ne null}">
							<c:forEach var="BoardBean" items="${bbsList}">
								<!-- 반복 출력 영역 시작 -->
								<div class="ContentDiv dFlex">
									<div class="no_bbs">${BoardBean.bno}</div>
									<div class="title_bbs">${BoardBean.title}</div>
									<div class="content_bbs">${BoardBean.subTitle}</div>
									<div class="writer_bbs">${BoardBean.writer}</div>
									<div class="writeDate_bbs">${BoardBean.modifyDate}</div>
									<div class="viewCnt_bbs">${BoardBean.viewCnt}</div>
								</div>
								<!-- 반복 출력 영역 끝 -->
							</c:forEach>
						</c:when>
					</c:choose>




				</div>
			</section>

			<!-- section#bbs : 게시판 목록 영역 끝 -->

			<!-- section#hidden : hidden input 영역 시작 -->
			<section id="hidden"></section>
			<!-- section#hidden : hidden input 영역 끝 -->
		</main>

		<jsp:include page="/ind/footerTmp.jsp" />

	</div>

</body>
</html>