<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
request.setCharacterEncoding("UTF-8");
String uId_Session = (String) session.getAttribute("uId_Session");

%>
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
	<jsp:include page="/ind/headerTmp.jsp" />
	<div id="wrap">

		<main>
			<!-- section#bbs_title : 게시판 제목 영역 시작 -->
			<section id="bbs_title">
				<div id="bbs_title_container">게시판 제목 출력</div>
			</section>
			<!-- section#bbs_title : 게시판 제목 영역 끝 -->

			<!-- section#bbs : 게시판 목록 영역 시작 -->
			<section id="bbs">
				<div id="bbs_container">
					<p>게시글 영역 출력</p>
					<button id = "write_Btn" type="button">작성</button>
					<button id = "modify_Btn" type="button">수정</button>
					<button id = "delete_Btn" type="button">삭제</button>
				</div>
			</section>
			<!-- section#bbs : 게시판 목록 영역 끝 -->

			<!-- section#hidden : hidden input 영역 시작 -->
			<section id="hidden"></section>
			<!-- section#hidden : hidden input 영역 끝 -->
		</main>

	</div>
	<jsp:include page="/ind/footerTmp.jsp" />
</body>
</html>