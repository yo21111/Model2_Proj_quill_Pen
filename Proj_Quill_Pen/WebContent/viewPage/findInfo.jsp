<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>아이디/비밀번호 찾기 페이지</title>
<link rel="stylesheet" href="/Proj_Quill_Pen/style/style_Common.css">
<link rel="stylesheet" href="/Proj_Quill_Pen/style/style_findInfo.css">
<script src="/Proj_Quill_Pen/source/jquery-3.6.0.min.js"></script>
<script src="/Proj_Quill_Pen/script/script_findInfo.js"></script>
</head>
<body>
	<jsp:include page="/ind/headerTmp.jsp" />
	<div id="wrap">
		<main>
			<!-- form 영역 시작 -->
			<form id="findinfo_Btn" method="post" action="/Proj_Quill_Pen/login">
				<!-- section#findinfo : 아이디/비밀번호 찾기 페이지 시작 -->
				<section id="findinfo">
					<div id="findinfo_title">
						<h2>${title}</h2>
					</div>
					<!-- div#findinfo_title -->
					<div id="findinfo_error">${errorMsg}</div>
					<input type="hidden" id="find" name="find" value="${find}">
					<c:choose>
						<c:when test="${find eq 'id'}">
							<div class="findinfo_input">
								<input type="text" name="uName" placeholder="이름을 입력해주세요.">
							</div>
							<!-- div.findinfo_input -->
							<div class="findinfo_input">
								<input type="text" name="uPhone" placeholder="휴대폰 번호를 입력해주세요.">
							</div>
							<!-- div.findinfo_input -->
						</c:when>
						<c:when test="${find eq 'pw'}">
							<div class="findinfo_input">
								<input type="text" name="uId" placeholder="아이디를 입력해주세요.">
							</div>
							<!-- div.findinfo_input -->
							<div class="findinfo_input">
								<input type="text" name="uPhone" placeholder="휴대폰 번호를 입력해주세요.">
							</div>
							<!-- div.findinfo_input -->
						</c:when>
						<c:when test="${find eq 'pwCheck'}">
							<div class="findinfo_input">
								<input type="text" name="uId" value="${uId}" readonly>
							</div>
							<!-- div.findinfo_input -->
							<div class="findinfo_input">
								<input type="text" id="updatePw" name="uPw"
									placeholder="변경하실 비밀번호를 입력해주세요.">
							</div>
							<div class="findinfo_input">
								<input type="text" id="updatePwChk"
									placeholder="비밀번호를 한번 더 입력해주세요.">
							</div>
							<input type="hidden" id="find" name="find" value="pwChange">
							<!-- div.findinfo_input -->
						</c:when>

						<c:when test="${find eq 'findId'}">
							<div id="findinfo_result">
								가입된 아이디는 <span>${findId}</span>입니다.
							</div>
							<!-- div#findinfo_result -->
						</c:when>
					</c:choose>

					<c:if test="${find ne 'findId'}">
						<div id="findinfo_findBtn">
							<button type="button">${title}</button>
						</div>
						<!-- div#findinfo_findinfoBtn -->
					</c:if>
					<div id="findinfo_findinfoBtn">
						<button type="button">
							<span>아이디/비밀번호 찾기로 이동</span>
						</button>
					</div>
					<!-- div#findinfo_findinfoBtn -->
					<div id="findinfo_loginBtn">
						<button type="button">로그인 페이지로 이동하기</button>
					</div>
					<!-- div#findinfo_loginBtn -->
				</section>
				<!-- section#findinfo : 아이디/비밀번호 찾기 페이지 끝 -->

				<!-- section#hidden : hidden input 영역 시작 -->
				<section id="hidden">
					<input type="hidden" id="find" value="${find}">
				</section>
				<!-- section#hidden : hidden input 영역 끝 -->

			</form>
			<!-- form 영역 끝 -->
		</main>
	</div>
	<jsp:include page="/ind/footerTmp.jsp" />
</body>
</html>