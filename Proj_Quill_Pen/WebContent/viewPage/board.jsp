<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="BoardBean" value="${boardBean}" />
<c:set var="WriterBean" value="${writerBean}" />
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
<script src="/Proj_Quill_Pen/script/script_board.js"></script>

</head>

<body>
	<jsp:include page="/ind/headerTmp.jsp" />
	<div id="wrap">
		<main>
			<!-- section#board_title : 게시글 상단 영역 시작 -->
			<section id="board_header">
				<div id="board_header_util" class="dFlex">
					<button id="recomend_Btn" type="button">
						<i class="fa-regular fa-thumbs-up"></i>
					</button>
					<button id="comment_Btn" type="button">
						<i class="fa-regular fa-comment"></i>
					</button>
					<button id="report_Btn" type="button">
						<i class="fa-solid fa-bullhorn"></i>
					</button>
				</div>


				<div id="board_header">
					<div id="board_header_title">
						<input type="hidden" id="fileImg" value="${BoardBean.fileName}">
						<input type="text" name="title" value="${BoardBean.title}"
							${readonly}>
					</div>
					<div id="board_header_subTitle">
						<input type="text" name="subTitle" value="${BoardBean.subTitle}"
							${readonly}>
					</div>
				</div>

				<div id="board_header_info" class="dFlex">
					작가명 : <input type="text" id="writer" name="writer"
						value="${BoardBean.writer}" readonly> 작성일자 : <input
						type="text" value="${BoardBean.writeDate}" readonly>
				</div>
			</section>
			<!-- section#board_title : 게시글 상단 영역 끝 -->

			<!-- section#board_content : 게시글 내용 영역 시작 -->
			<section id="board_content">
				<div id="board_content">

					<textarea name="content" id="content" ${readonly}>${BoardBean.content}</textarea>

				</div>
				<!-- div#board_content-->
			</section>
			<!-- section#blog_info : 게시글 내용 영역 끝 -->

			<!-- ///////////////////////////////////////////////////////////////////////////// -->
			<!-- ///////////////// 게시글 수정, 글쓰기 시 버튼 출력 영역  /////////////////// -->
			<section id="board_btn">
				<div id="board_btnArea" class="dFlex">
					<button id="bbs_Btn" type="button">목록</button>
					<button id="reportBtn" type="button">신고</button>
					<button id="modify_Btn" type="button">수정</button>
					<button id="delete_Btn" type="button">삭제</button>
					<button id="admin_delete_Btn" type="button">삭제</button>
				</div>
			</section>



			<!-- ///////////////// 게시글 수정, 글쓰기 시 여기까지만 출력 /////////////////// -->
			<!-- ///////////////////////////////////////////////////////////////////////////// -->

			<!-- section#board_comment : 게시글 댓글 영역 시작 -->
			<section id="board_comment">
				<div id="board_comment_info">
					댓글 갯수 : <span id="comment_cnt">${commentCnt}</span>
				</div>
				<!-- div#board_comment_info -->
				<div id="board_comment_List">
					<!-- ///////////////// 댓글 있을 시 반복 구역 시작 ///////////////// -->
					<c:choose>
						<c:when test="${commentCnt eq 0}">
							<div id="comment_Null">아직 작성된 댓글이 없습니다.</div>
						</c:when>
						<c:when test="${commentCnt ne 0}">
							<c:forEach items="${cmntList}" var="CmntBean">
								<div class="comment_read dFlex">
									<div class="comment_container">
										<div class="comment_content_info">
											작성자 : <span class="writer">${CmntBean.writer}</span> 작성일자 :
											${CmntBean.modifyDate}
										</div>
										
										<div class="comment_content dFlex">
											<input type="text" name="cmtContent" class="comment_input"
												value="${CmntBean.content}" ${readonly}>
											<div class="comment_btn" class="dFlex">
												<button id="report_Btn" type="button">신고</button>
												<c:if test="${uId eq CmntBean.writer}">
													<button id="modifyCmnt_Btn" type="button">수정</button>
													<button id="deleteCmnt_Btn" type="button">삭제</button>
												</c:if>
											</div>
										</div>
										<input id="cmntNum" type="hidden" class="hiddenValue"
											value="${CmntBean.cno} ">
									</div>
									<!-- div.comment_container -->
								</div>
								<!-- div.comment_read -->
							</c:forEach>
						</c:when>
					</c:choose>
					<!-- ///////////////// 댓글 있을 시 반복 구역 끝 ///////////////// -->
				</div>
				<!-- div#board_comment_List -->
			</section>
			<!-- section#board_comment : 게시글 댓글 영역 끝 -->

			<div id="commenticon">
				<button id="icon">
					댓글 <i class="fa-solid fa-comment"></i>
				</button>
			</div>

			<div id="cmntWrite">
				<form action="/Proj_Quill_Pen/cmnt" method="post">
				<input type="hidden" name="cmntBno" value="${BoardBean.bno}">
					<input type="text" id="cmntWriteContent" name="cmnt" placeholder="댓글을 입력해주세요.">
					<button id="cmntWriteBtn" type="button">댓글 등록</button>
				</form>
			</div>
			
			<div id="cmntReWrite">
				<form action="/Proj_Quill_Pen/cmnt" method="post">
				<input type="hidden" name="cmntkind" value="updateCmnt">
				<input type="hidden" name="cmntNumber" id="cmntNumber">
				<input type="hidden" name="cmntBno" value="${BoardBean.bno}">
					<input type="text" id="cmntWriteContent" name="cmnt" placeholder="수정할 댓글 내용을 입력해주세요.">
					<button id="cmntReWriteBtn" type="button">댓글 수정</button>
				</form>
			</div>
			

			<!-- section#board_writer : 게시글 작가 정보 영역 시작 -->
			<section id="board_writer">
				<div id="writer_container" class="dFlex">
					<div id="writer_img" class="dFlex">
						<div class="imgDiv">
							<img src="/Proj_Quill_Pen/images/test/${WriterBean.fileName}"
								alt="${WriterBean.writer}">
						</div>
					</div>
					<div id="writer_info">
						<div id="writer_name">${WriterBean.writer}</div>
						<div id="writer_title">${WriterBean.content}</div>
					</div>
				</div>
			</section>
			<!-- section#board_writer : 게시글 작가 정보 영역 끝 -->

			<!-- section#hidden : hidden input 영역 시작 -->
			<section id="hidden">
				<input type="hidden" id="bno" name="bno" value="${BoardBean.bno}">
				<input type="hidden" id="isLogin" name="isLogin" value="${isLogin}">
				<input type="hidden" id="myPost" name="myPost" value="${myPost}">
				<input type="hidden" id="submitWriter" value="${BoardBean.writer }">
				<input type="hidden" id="isAdmin" value="${isAdmin}">
				<input type="hidden" id="getDno" value="${param.dno}">
			</section>
			<!-- section#hidden : hidden input 영역 끝 -->
		</main>
	</div>
	<jsp:include page="/ind/footerTmp.jsp" />
</body>
</html>