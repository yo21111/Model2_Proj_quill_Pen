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
<title>글 쓰기, 게시글 세부페이지</title>
<link rel="stylesheet" href="/Proj_Quill_Pen/style/style_board.css">
<script src="https://kit.fontawesome.com/e223fa8a5e.js"></script>
<script src="/Proj_Quill_Pen/source/jquery-3.6.0.min.js"></script>
<script src="/Proj_Quill_Pen/script/script.js"></script>

</head>

<body>
	<jsp:include page="/ind/headerTmp.jsp" />
	<div id="wrap">
		<main>
			<!-- section#board_title : 게시글 상단 영역 시작 -->
			<section id="board_header">
				<div id="board_header_util" class="dFlex">
					<button id="recomend_Btn" type="button"><i class="fa-regular fa-thumbs-up"></i></button>
					<button id="comment_Btn" type="button"><i class="fa-regular fa-comment"></i></button>
					<button id ="report_Btn" type="button"><i class="fa-solid fa-bullhorn"></i></button>
				</div>
				<div id="board_header_title">
					<h1>${title}게시글 제목</h1>
				
				</div>
				<div id="board_header_subTitle">		
					<h3>${subTitle}게시글 소제목</h3>
				
				</div>
				<div id="board_header_info"> 	
				   <input type="text" name="writer" value="${writer}작가명 ">
				<input type="text" value="${writeDate}작성일자 ">
				</div>
			</section>
			<!-- section#board_title : 게시글 상단 영역 끝 -->

			<!-- section#board_content : 게시글 내용 영역 시작 -->
			<section id="board_content">
				<div id="board_content">
				
				<textarea name="content" id="content" >${content}게시글 내용 출력 공간</textarea>
				
				</div>
				<!-- div#board_content-->
			</section>
			<!-- section#blog_info : 게시글 내용 영역 끝 -->

			<!-- ///////////////////////////////////////////////////////////////////////////// -->
			<!-- ///////////////// 게시글 수정, 글쓰기 시 버튼 출력 영역  /////////////////// -->
			<section id="board_btn" class="dFlex">
				<div id="board_btnArea">
					<button id="confirm_Btn" type="button">등록</button>
					<button id = "modify_Btn" type="button">수정</button>
					<button id = "delete_Btn" type="button">삭제</button>
				</div>
			</section>
			
			<div id="commenticon">

				<button id="icon">댓글 <i class="fa-solid fa-comment"></i></button>
			</div>
			
			<!-- ///////////////// 게시글 수정, 글쓰기 시 여기까지만 출력 /////////////////// -->
			<!-- ///////////////////////////////////////////////////////////////////////////// -->

			<!-- section#board_comment : 게시글 댓글 영역 시작 -->
			<section id="board_comment">
				<div id="board_comment_info">
					댓글 : <span id="comment_cnt">숫자
					${bno}</span>
				</div>

				<!-- div#board_comment_info -->
				<div id="board_comment_List">
					<!-- ///////////////// 댓글 있을 시 반복 구역 시작 ///////////////// -->
					<div class="comment_read dFlex">
						<div class="comment_img">프로필이미지${fileName}</div>
						<div class="comment_container">

							<div class="comment_content_info">

								<div class="comment_btn">
									<button id = "report_Btn" type="button">신고</button>
									<button id = "modify_Btn" type="button">수정</button>
									<button id = "delete_Btn" type="button">삭제</button>
								</div>
								<span class="writer">작성자${writer}</span> 작성일자${writeDate}
								(수정버튼이 있기에 수정 날짜도 필요해 보임)
							</div>

							<div class="comment_content">댓글 출력부분${content}</div>
						</div>
						<input type="hidden" class="hiddenValue" value="hidden input 작성 공간${cnt} ">
	
						<!-- div.comment_container -->
					</div>
					<!-- div.comment_read -->
					<!-- ///////////////// 댓글 있을 시 반복 구역 끝 ///////////////// -->
				</div>
				<!-- div#board_comment_List -->

				<div id="board_comment_container">
					<div class="comment_write dFlex">
						<div class="comment_img">프로필이미지${fileName}</div>
						<div class="comment_input"> 댓글 작성 공간${content}

							
							<div class="comment_Btn">
								<button id= "comment_btn" type="button">댓글 등록</button>
							</div>


						</div>
					</div>
				
					<!-- div.comment_write -->
				</div>
				<!-- div#board_comment_container-->
			</section>
			<!-- section#board_comment : 게시글 댓글 영역 끝 -->

			<!-- section#board_writer : 게시글 작가 정보 영역 시작 -->
			<section id="board_writer">
				<div id="writer_container" class="dFlex">
					<div id="writer_info">
						<div id="writer_name">*작가테이블 ${writer}작가이름</div>
						<div id="writer_title">*작가테이블 ${title}작가 소개멘트</div>
					</div>
					<div id="writer_img">*${fileName} 프로필이미지</div>
				</div>
			</section>
			<!-- section#board_writer : 게시글 작가 정보 영역 끝 -->

			<!-- section#bbs : 작가의 게시판 목록 영역 시작 -->
			<!-- ////// bbs에서 가져온 것으로 해당 부분에 css코드 있음 ////// -->
			<section id="bbs">
				<div id="bbs_container"> 게시글 영역 출력</div>
			</section>
			<!-- section#bbs : 작가의 게시판 목록 영역 끝 -->

			<!-- section#hidden : hidden input 영역 시작 -->
			<section id="hidden"></section>
			<!-- section#hidden : hidden input 영역 끝 -->
		</main>
	</div>
	<jsp:include page="/ind/footerTmp.jsp" />
</body>
</html>