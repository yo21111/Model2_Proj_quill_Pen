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
<link rel="stylesheet" href="/Proj_Quill_Pen/style/style_blog.css">
<script src="/Proj_Quill_Pen/source/jquery-3.6.0.min.js"></script>
<script src="/Proj_Quill_Pen/script/script_blog.js"></script>
</head>
<body>
	<jsp:include page="/ind/headerTmp.jsp" />
	<div id="wrap">
		<main>
			<!-- section#blog_title : 작가 정보 영역 시작 -->
			<section id="blog_title">
				<div id="blog_title_container">
					<table id=profileTbl>
						<thead>
							<tr>
								<th>이름</th>
								<th rowspan="2">
									<div id="profileImg"><img src="/Proj_Quill_Pen/images/profile/profile1.jpg" alt="프로필이미지"></div>
								</th>
							</tr>
							<tr>
								<th id=introMent>도서출판경제21c 칼럼니스트</th>
							</tr>
						</thead>
					</table>
				</div>
			</section>
			<!-- section#blog_title : 작가 정보 영역 끝 -->

			<!-- section#blog_subs : 작가 구독 영역 시작 -->
			<section id="blog_subs">
				<div id="blog_subs_container">
					<table id="subArea">
						<tbody>
							<tr>
								<td id="cntArea">
									<div>
										<a href="#">구독자<span>123</span></a>
									</div>
									<div>
										<a href="#">관심작가<span>123</span></a>
									</div>
								</td>
								<!-- <form id = "blog_Frm" method="" action=""> -->
								<td>
									<button id="subscribe_Btn" type="button">구독하기</button>
									<button id = "report_Btn" type="button">신고하기</button>
								</td>
								<!-- </form> -->
							</tr>
						</tbody>
					</table>
				</div>
			</section>
			<!-- section#blog_subs : 작가 구독 영역 끝 -->

			<!-- section#blog_info : 작가 세부 정보 영역 시작 -->
			<section id="blog_info">
				<div id="blog_infos_container">
					<div id="info_content">
						<ul class="dFlex">
							<li><a href="#" id="navInt">작가소개</a></li>
							<li><a href="#" id="navList">작가의 글</a></li>
						</ul>
					</div>
					<div id="info_intro">
						<h1>소개</h1>
						<p>도서출판 경제21c 대표. 강의 및 교육 문의 test@naver.com</p>
					</div>
					<div id="info_writing">
						<table>
							<tbody>
								<tr>
									<td colspan="2" id="writeTitle">
										<a href="#">글번호.글제목</a>
									</td>
									<td rowspan="3">
										<a href=""><img src="/Proj_Quill_Pen/images/profile/profile1.jpg" alt="썸네일"></a>
									</td>
								</tr>
								<tr>
									<td colspan="2" id="writeSubTitle">
										<span>[부제목]</span>글내용Lorem ipsum dolor sit amet, consectetur adipisicing elit. Quasi quisquam rerum praesentium tenetur vero dicta. Maiores tempore ut maxime architecto ex nam magni cumque iste accusantium quisquam reiciendis ab quis?
									</td>
								</tr>
								<tr>
									<td colspan="2" id="etcArea">
											<div>댓글0</div>
											<div>2022-04-26</div>
									</td>
								</tr>
							</tbody>
						</table>
						<hr id="sepLine">
						
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