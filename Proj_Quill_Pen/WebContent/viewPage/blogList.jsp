<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
request.setCharacterEncoding("UTF-8");


%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>작가 조회페이지</title>
<link rel="stylesheet" href="/Proj_Quill_Pen/style/style_Common.css">
<link rel="stylesheet" href="/Proj_Quill_Pen/style/style_blogList.css">
<script src="/Proj_Quill_Pen/source/jquery-3.6.0.min.js"></script>
<script src="/Proj_Quill_Pen/script/script.js"></script>
</head>
<body>
	<jsp:include page="/ind/headerTmp.jsp" />
	<div id="wrap">
		<main>
			<!-- section#blogList_title : 작가 게시판 제목 영역 시작 -->
			<section id="blogList_title">
				<div id="blogList_title_container">작가 게시판 제목</div>
			</section>
			<!-- section#blogList_title : 작가 게시판 제목 영역 끝 -->

			<!-- section#blogList_content : 작가 게시판 영역 시작 -->
			<section id="blogList_content">
				<div id="blogList_content_container" class="dFlex">
					<div class="writer">
						<table>
							<tbody>
								<tr>
									<td class="writer_name"><a href="#">작가명</a></td>
									<td class="writer_img" rowspan="3">
										<a href="#"><img src="/Proj_Quill_Pen/images/profile/profile1.jpg" alt="프로필이미지"></a>
									</td>
								</tr>
								<tr>
									<td class="writer_title"><a href="#">작가 소개 멘트 veniet fuga doloremque quas praesentium mollitia deserunt nesciunt earum dolorum debitis perferendis quasi.</a></td>
								</tr>
								<tr>
									<td class="writer_content">
										<div>글 수 180</div>
										<div>구독자 수 8,615</div>
									</td>
								</tr>
							</tbody>
						</table>
					</div>
					<div class="writer">
						<table>
							<tbody>
								<tr>
									<td class="writer_name"><a href="#">작가명</a></td>
									<td class="writer_img" rowspan="3">
										<a href="#"><img src="/Proj_Quill_Pen/images/profile/profile1.jpg" alt="프로필"></a>
									</td>
								</tr>
								<tr>
									<td class="writer_title"><a href="#">작가 소개 멘트Lour adi praesentium enim obcaecati dicta?</a></td>
								</tr>
								<tr>
									<td class="writer_content">
										<div>글 수 0</div>
										<div>구독자 수 0</div>
									</td>
								</tr>
							</tbody>
						</table>
					</div>
					<div class="writer">
						<table>
							<tbody>
								<tr>
									<td class="writer_name"><a href="#">작가명</a></td>
									<td class="writer_img" rowspan="3">
										<a href="#"><img src="/Proj_Quill_Pen/images/profile/profile1.jpg" alt="프로필이미지"></a>
									</td>
								</tr>
								<tr>
									<td class="writer_title"><a href="#">작가 소개 멘트 veniet fuga doloremque quas praesentium mollitia deserunt nesciunt earum dolorum debitis perferendis quasi.</a></td>
								</tr>
								<tr>
									<td class="writer_content">
										<div>글 수 180</div>
										<div>구독자 수 8,615</div>
									</td>
								</tr>
							</tbody>
						</table>
					</div>
					<div class="writer">
						<table>
							<tbody>
								<tr>
									<td class="writer_name"><a href="#">작가명</a></td>
									<td class="writer_img" rowspan="3">
										<a href="#"><img src="/Proj_Quill_Pen/images/profile/profile1.jpg" alt="프로필"></a>
									</td>
								</tr>
								<tr>
									<td class="writer_title"><a href="#">작가 소개 멘트Lour adi praesentium enim obcaecati dicta?</a></td>
								</tr>
								<tr>
									<td class="writer_content">
										<div>글 수 0</div>
										<div>구독자 수 0</div>
									</td>
								</tr>
							</tbody>
						</table>
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