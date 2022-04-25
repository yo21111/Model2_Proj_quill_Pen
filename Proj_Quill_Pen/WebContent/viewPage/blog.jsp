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
<title>마이페이지, 작가페이지</title>
<link rel="stylesheet" href="/Proj_Quill_Pen/style/style_Common.css">
<script src="/Proj_Quill_Pen/source/jquery-3.6.0.min.js"></script>
<script src="/Proj_Quill_Pen/script/script.js"></script>
</head>
<body>
	<jsp:include page="/ind/headerTmp.jsp" />
	<div id="wrap">
		<main>
			<!-- section#blog_title : 작가 정보 영역 시작 -->
			<section id="blog_title">
				<div id="blog_title_container">
					<table>
						<thead>
							<tr>
								<td>이름</td>
								<td>프로필사진</td>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td colspan="2"></td>
							</tr>
						</tbody>
					</table>
				</div>
			</section>
			<!-- section#blog_title : 작가 정보 영역 끝 -->

			<!-- section#blog_subs : 작가 구독 영역 시작 -->
			<section id="blog_subs">
				<div id="blog_subs_container">
					<table>
						<tbody>
							<tr>
								<td>구독자수<span>123</span></td>
								<td>관심작가<span>123</span></td>
								<form id = "blog_Frm" method="" action="">
								<td><button id="subscribe_Btn" type="button">구독하기</button></td>
								<td><button id = "report_Btn" type="button">신고하기</button></td>
								</form>
							</tr>
						</tbody>
					</table>
				</div>
			</section>
			<!-- section#blog_subs : 작가 구독 영역 끝 -->

			<!-- section#blog_info : 작가 세부 정보 영역 시작 -->
			<section id="blog_info">
				<div id="blog_infos_container">
					<div id="info_content">작가 소개글 출력</div>
					<div id="info_writing">
						<table>
							<thead>
								<tr>
									<td>번호</td>
									<td>제목</td>
									<td>작가</td>
									<td>작성일시</td>
								</tr>
							</thead>
							<tbody>
								<tr>
									<td>test</td>
									<td>test</td>
									<td>test</td>
									<td>test</td>
								</tr>
							</tbody>
						</table>
					</div>
				</div>
			</section>
			<!-- section#blog_info : 작가 세부 정보 영역 끝 -->

			<!-- section#hidden : hidden input 영역 시작 -->
			<section id="hidden"></section>
			<!-- section#hidden : hidden input 영역 끝 -->
		</main>
	</div>
	<jsp:include page="/ind/footerTmp.jsp" />
</body>
</html>