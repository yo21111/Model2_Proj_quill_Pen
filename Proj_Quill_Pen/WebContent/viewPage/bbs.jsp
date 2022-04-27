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
					<h1>
						게시판 제목 출력
						${title}
					</h1>
				</div>
			</section>
			<!-- section#bbs_title : 게시판 제목 영역 끝 -->

			<!-- section#bbs : 게시판 목록 영역 시작 -->
			<section id="bbs">
				<div id="bbs_container">
					게시글 출력 영역  
			  <div id="ContentDiv" class="dFlex">
				     <div id="divtitle"><h1 id="title_bbs">제목${title}</h1>
					  <div id="divContent">글 내용{content}</div>
					  <div id="writer_writeDate">작성자${writer} 작성일자 ${writeDate}</div>
					  <hr>

				  </div>
				  <div id="divFile" >${fileName}</div>
				</div>



				 	<div id="btn_bbs">

						 <button id = "write_Btn" type="button">작성</button>
						 <button id = "modify_Btn" type="button">수정</button>
						 <button id = "delete_Btn" type="button">삭제</button>
						</div>
				
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