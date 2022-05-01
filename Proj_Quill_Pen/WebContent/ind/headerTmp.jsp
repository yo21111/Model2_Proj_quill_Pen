<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Document</title>
<link rel="stylesheet" href="/Proj_Quill_Pen/style/style_ind.css" />
<script src="https://kit.fontawesome.com/e223fa8a5e.js"
	crossorigin="anonymous"></script>
</head>
<body>
	<div id="wrap">
		<header id="header">

			<div id="headerMenu" class="dFlex">

				<nav id="lnb">
					<div id="lnb_top">
						<div id="lnb_top_Logo" class="dFlex">
							<img id="list" src="/Proj_Quill_Pen/images/header/LNB_Logo.png"
								alt="LNB로고">
						</div>
						<c:if test="${isLogin ne 'true'}">
							<div id="lnb_top_register">
								<button type="button">
									quill pen<br>시작하기
								</button>
							</div>
						</c:if>
					</div>
					<div id="lnb_bot">
						<ul id="LNBul">
							<c:if test="${isLogin ne 'true'}">
								<li class="lnbMenu"><a href="/Proj_Quill_Pen/login">로그인</a></li>
								<li class="lnbMenu"><a href="/Proj_Quill_Pen/book">quill pen 책방</a></li>
								<li class="lnbMenu"><a href="/Proj_Quill_Pen/bbs">quill pen 게시판</a></li>
							</c:if>
							<c:if test="${isLogin eq 'true'}">
								<li class="lnbMenu"><a href="/Proj_Quill_Pen/logout">로그아웃</a></li>
								<li class="lnbMenu"><a href="/Proj_Quill_Pen/myPage">마이 페이지</a></li>
								<li class="lnbMenu"><a href="/Proj_Quill_Pen/book">quill pen 책방</a></li>
								<li class="lnbMenu"><a href="/Proj_Quill_Pen/bbs">quill pen 게시판</a></li>
							</c:if>
						</ul>
					</div>
				</nav>


				<div id="imgArea" class="dFlex">
					<!-- 로고 부분  -->
					<div id="imgArea_left" class="dFlex">
						<div id="lnbBtn">
							<img id="list" src="/Proj_Quill_Pen/images/header/list.png"
								alt="목록로고">
						</div>
						<a href="/Proj_Quill_Pen/main"><img id="Logo"
							src="/Proj_Quill_Pen/images/header/mainLogo.png" alt="헤더로고">
						</a>
					</div>

					<div id="imgArea_right" class="dFlex">
						<input id="searchInput" type="text" placeholder="검색어를 입력해주세요." name="search">
						<i id="search" class="fa-solid fa-magnifying-glass"></i>
						<c:if test="${isLogin eq 'true'}">
							<a href="/Proj_Quill_Pen/myPage"><i class="fa-solid fa-user"></i></a>
						</c:if>
					</div>

				</div>

			</div>

		</header>


		<!-- <nav>LNB메뉴자리(LNB버튼,로고,회원가입,검색)</nav> -->
	</div>
	<!-- div#wrap -->
	<script src="/Proj_Quill_Pen/source/jquery-3.6.0.min.js"></script>
	<script src="/Proj_Quill_Pen/script/script_ind.js"></script>
</body>
</html>