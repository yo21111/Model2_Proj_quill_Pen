<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
request.setCharacterEncoding("UTF-8");
String uId_Session = (String) session.getAttribute("uId_Session");
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>	
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>관심글 조회페이지</title>
<link rel="stylesheet" href="/Proj_Quill_Pen/style/style_Common.css">
<link rel="stylesheet" href="/Proj_Quill_Pen/style/style_blogList.css">
<script src="/Proj_Quill_Pen/source/jquery-3.6.0.min.js"></script>
<script src="/Proj_Quill_Pen/script/script_blog.js"></script>
</head>
<body>
	<jsp:include page="/ind/headerTmp.jsp" />
	<div id="wrap">
		<main>
			<!-- section#blogList_title : 작가 게시판 제목 영역 시작 -->
			<section id="blogList_title">
				<div id="blogList_title_container"><h1>나의 관심글</h1></div>
			</section>
			<!-- section#blogList_title : 작가 게시판 제목 영역 끝 -->

			<!-- section#blogList_content : 작가 게시판 영역 시작 -->
			<section id="blogList_content">
				<div id="blogList_content_container" class="dFlex">
					<div class="writer">
						<c:choose>
							<c:when test="${likeList eq '[]' }">
								<div id="nullNotice">관심 게시글이 없습니다.</div>
								<button type="button" id="subMain">메인으로</button>
							</c:when>
							<c:when test="${likeList ne '[]'}">
								<c:forEach var="BoardBean" items="${likeList }">
									<table class="likeArticle">
										<tbody>
											<tr>
												<td class="writer_name">${BoardBean.writer }</td>
												<td class="writer_img" rowspan="3">
													<img src="/Proj_Quill_Pen/images/test/${BoardBean.fileName }" alt="프로필이미지">
												</td>
											</tr>
											<tr>
												<td class="writer_title">${BoardBean.title }</td>
											</tr>
											<tr>
												<td class="writer_content">
													<div>구독자 수${BoardBean.viewCnt}</div>
												</td>
											</tr>
										</tbody>
									</table>
								</c:forEach>							
							</c:when>
						</c:choose>
						
					</div>
					<!-- div.writer -->
				</div>
				<!-- div#blogList_content_container -->
			</section>
			<!-- section#blog_info : 작가 게시판 영역 끝 -->

			<!-- section#hidden : hidden input 영역 시작 -->
			<section id="hidden"></section>
			<!-- section#hidden : hidden input 영역 끝 -->
		</main>

	</div>
	<jsp:include page="/ind/footerTmp.jsp" />
</body>
</html>