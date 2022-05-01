<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="boardBean" value="${boardBean}" />
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>글 쓰기, 게시글 세부페이지</title>
<link rel="stylesheet" href="/Proj_Quill_Pen/style/style_board.css">
<link rel="stylesheet"
	href="/Proj_Quill_Pen/style/style_boardRewrite.css">
<script src="https://kit.fontawesome.com/e223fa8a5e.js"></script>
<script src="/Proj_Quill_Pen/source/jquery-3.6.0.min.js"></script>
<script src="/Proj_Quill_Pen/script/script_board.js"></script>
<script src="/Proj_Quill_Pen/script/script_boardRewrite.js"></script>

</head>

<body>
	<jsp:include page="/ind/headerTmp.jsp" />
	<div id="wrap">
		<main>
			<form id="rewriteFrm" method="post" enctype="multipart/form-data">
				<input type="hidden" id="bno" name="bno" value="${boardBean.bno}">
				<c:choose>
					<c:when test="${nowPage eq 'insert'}">
						<!-- ////////////////////////////////////////// insert 시 ////////////////////////////////////////// -->
						<!-- section#board_title : 게시글 상단 영역 시작 -->
						<section id="board_header">
							<div id="board_header" class="insert_header">
								<div id="board_header_title">
									<input type="text" id="title" name="title"
										placeholder="제목을 입력해주세요.">
								</div>
								<div id="board_header_subTitle">
									<input type="text" name="subTitle" placeholder="부제목을 입력해주세요.">
								</div>
							</div>

							<div id="board_header_info" class="dFlex">
								작가명 : <input type="text" id="writer" name="writer"
									value="${writer}" readonly> <input type="file"
									id="fileInput" name="fileName">
							</div>
						</section>
						<!-- section#board_title : 게시글 상단 영역 끝 -->

						<!-- section#board_content : 게시글 내용 영역 시작 -->
						<section id="board_content">
							<div id="board_content">
								<textarea name="content" id="content" placeholder="내용을 입력해주세요."
									wrap="hard"></textarea>
							</div>
							<!-- div#board_content-->

							<input type="hidden" id="nowPage" value="insert">
						</section>
						<!-- section#blog_info : 게시글 내용 영역 끝 -->
						<!-- ////////////////////////////////////////// insert 시 ////////////////////////////////////////// -->
					</c:when>
					<c:when test="${nowPage eq 'update'}">
						<!-- ////////////////////////////////////////// update 시 ////////////////////////////////////////// -->
						<!-- section#board_title : 게시글 상단 영역 시작 -->
						<section id="board_header">
							<div id="board_header">
								<div id="board_header_title">
									<input type="hidden" id="fileImg" value="${boardBean.fileName}">
									<input type="text" id="title" name="title"
										value="${boardBean.title}">
								</div>
								<div id="board_header_subTitle">
									<input type="text" name="subTitle"
										value="${boardBean.subTitle}">
								</div>
							</div>

							<div id="board_header_info" class="dFlex">
								작가명 : <input type="text" id="writer" name="writer"
									value="${boardBean.writer}" readonly> <input type="file"
									id="fileInput" name="fileName" value="${boardBean.fileName}">
							</div>
						</section>
						<!-- section#board_title : 게시글 상단 영역 끝 -->

						<!-- section#board_content : 게시글 내용 영역 시작 -->
						<section id="board_content">
							<div id="board_content">
								<textarea name="content" id="content" wrap="hard">${boardBean.content}</textarea>
							</div>
							<!-- div#board_content-->

							<input type="hidden" id="nowPage" value="update">
						</section>
						<!-- section#blog_info : 게시글 내용 영역 끝 -->
						<!-- ////////////////////////////////////////// update 시 ////////////////////////////////////////// -->
					</c:when>
				</c:choose>
			</form>


			<!-- ///////////////////////////////////////////////////////////////////////////// -->
			<!-- ///////////////// 게시글 수정, 글쓰기 시 버튼 출력 영역  /////////////////// -->
			<section id="board_btn">
				<div id="board_btnArea" class="dFlex">
					<button id="bbs_Btn" type="button">목록</button>
					<button id="reWrite_Btn" type="reset">다시쓰기</button>
					<c:choose>
						<c:when test="${nowPage eq 'insert'}">
							<button id="insert_Btn" type="button">등록</button>
						</c:when>
						<c:when test="${nowPage eq 'update'}">
							<button id="modify_Btn" type="button">등록</button>
						</c:when>
					</c:choose>
				</div>
			</section>



			<!-- ///////////////// 게시글 수정, 글쓰기 시 여기까지만 출력 /////////////////// -->
			<!-- ///////////////////////////////////////////////////////////////////////////// -->



			<!-- section#hidden : hidden input 영역 시작 -->
			<section id="hidden">
				<input type="hidden" id="isLogin" name="isLogin" value="${isLogin}">
				<input type="hidden" id="myPost" name="myPost" value="${myPost}">
			</section>
			<!-- section#hidden : hidden input 영역 끝 -->
		</main>
	</div>
	<jsp:include page="/ind/footerTmp.jsp" />
</body>
</html>