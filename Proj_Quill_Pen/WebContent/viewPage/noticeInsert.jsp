<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%-- <c:set var="NoticeBean" value="${NoticeBean}" /> --%>
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
<script src="/Proj_Quill_Pen/script/script_noticeMod.js"></script>

</head>

<body>
	<jsp:include page="/ind/headerTmp.jsp" />
	<div id="wrap">
		<main>
			<form id="inNoticeFrm" method="get" enctype="multipart/form-data">
				<%-- <input type="hidden" id="bno" name="bno" value="${NoticeBean.bno}"> --%>
						<!-- ////////////////////////////////////////// insert 시 ////////////////////////////////////////// -->
						<!-- section#board_title : 게시글 상단 영역 시작 -->
						<section id="board_header">
							<div id="board_header" class="insert_header">
								<div id="board_header_title">
									<input type="text" id="title" name="title"
										placeholder="제목을 입력해주세요.">
								</div>
							</div>

							<div id="board_header_info" class="dFlex">
								작가명 : <input type="text" id="writer" name="writer"
									value="${writer}" readonly>
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
							<input type="hidden" name="mId" id="myId" value="${NoticeBean.mId}">
							<input type="hidden" name="type"  value="mod">
						</section>
						<!-- section#blog_info : 게시글 내용 영역 끝 -->
			</form>


			<!-- ///////////////////////////////////////////////////////////////////////////// -->
			<!-- ///////////////// 게시글 글쓰기 시 버튼 출력 영역  /////////////////// -->
			<section id="board_btn">
				<div id="board_btnArea" class="dFlex">
					<button id="bbs_Btn" type="button">목록</button>
					<button id="reWrite_Btn" type="reset">다시쓰기</button>
					<button id="insert_Btn" type="button">등록</button>
				</div>
			</section>



			<!-- ///////////////// 게시글 글쓰기 시 여기까지만 출력 /////////////////// -->
			<!-- ///////////////////////////////////////////////////////////////////////////// -->



			<!-- section#hidden : hidden input 영역 시작 -->
			<section id="hidden">
			</section>
			<!-- section#hidden : hidden input 영역 끝 -->
		</main>
	</div>
	<jsp:include page="/ind/footerTmp.jsp" />
</body>
</html>