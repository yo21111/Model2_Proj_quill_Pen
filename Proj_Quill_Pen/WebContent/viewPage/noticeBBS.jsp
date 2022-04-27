<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>게시판 글목록 출력 페이지</title>
<link rel="stylesheet" href="/Proj_Quill_Pen/style/style_Common.css">
<link rel="stylesheet" href="/Proj_Quill_Pen/style/style_notice.css">
<script src="/Proj_Quill_Pen/source/jquery-3.6.0.min.js"></script>
<script src="/Proj_Quill_Pen/script/script.js"></script>
</head>
<body>
	<jsp:include page="/ind/headerTmp.jsp" />
	<div id="wrap">

		<main>
			<!-- section#bbs_title : 게시판 제목 영역 시작 -->
			<section id="noticeBBS">
				<div id="noticeBBS_title">
					<h1>[공지 사항]게시글 제목</h1>
				</div>
				
				<div id="notice_header_info">
					<span><a href="#">admin</a></span>
					<span>2022-04-27</span>
				</div>
				<div id="noticeBBS_container">
					게시판 내용 출력Lorem ipsum dolor sit amet, consectetur adipisicing elit. Dolor et corrupti quibusdam aspernatur tempora sunt totam ea soluta minus consectetur quas error eum numquam doloribus optio ullam sequi aperiam dolore.
					Lorem ipsum dolor sit amet, consectetur adipisicing elit. Nostrum recusandae ex laboriosam debitis totam et veritatis sint labore ipsam mollitia modi iure culpa magnam fuga ea! Minima nemo voluptate et.
					Lorem ipsum dolor sit amet, consectetur adipisicing elit. Odio nostrum eligendi laboriosam consectetur animi voluptate non ad porro vitae inventore voluptatibus velit ipsam architecto voluptas ducimus! Iure quibusdam temporibus porro.
					Lorem ipsum dolor sit amet, consectetur adipisicing elit. Nostrum recusandae ex laboriosam debitis totam et veritatis sint labore ipsam mollitia modi iure culpa magnam fuga ea! Minima nemo voluptate et.
					Lorem ipsum dolor sit amet, consectetur adipisicing elit. Nostrum recusandae ex laboriosam debitis totam et veritatis sint labore ipsam mollitia modi iure culpa magnam fuga ea! Minima nemo voluptate et.
					Lorem ipsum dolor sit amet, consectetur adipisicing elit. Nostrum recusandae ex laboriosam debitis totam et veritatis sint labore ipsam mollitia modi iure culpa magnam fuga ea! Minima nemo voluptate et.
				</div>
			</section>
			<!-- section#bbs_title : 게시판 제목 영역 끝 -->
			
			<!-- section#bbs_profile : 관리자 프로필 시작 -->
			<section id="noticeBBS_profile">
				<div id="admin_profile">
					<table>
						<tbody>
							<tr>
								<td id="admin_name"><a href="#">관리자명</a></td>
								<td rowspan="2">
									<a href="#"><img src="/Proj_Quill_Pen/images/profile/admin_profile.jpg" alt="관리자 프로필"></a>
								</td>
							</tr>
							<tr>
								<td id="admin_subName">Team Quill Pen</td>
							</tr>
							<tr>
								<td colspan="2" id="introMent">누구나 자유롭게 글을 쓰는 공간 Quill Pen.</td>
							</tr>
							<tr>
								<td id="subCnt">
									<span>구독자 150</span>
								</td>
								<td id="subBtn"><button type="button">구독하기</button></td>
							</tr>
						</tbody>
					</table>
				</div>
			</section>

			<!-- section#hidden : hidden input 영역 시작 -->
			<section id="hidden"></section>
			<!-- section#hidden : hidden input 영역 끝 -->
		</main>

	</div>
	<jsp:include page="/ind/footerTmp.jsp" />
</body>
</html>