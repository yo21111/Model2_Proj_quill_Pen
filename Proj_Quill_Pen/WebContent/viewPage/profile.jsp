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
<title>설정 페이지(개인정보수정)</title>
<link rel="stylesheet" href="/Proj_Quill_Pen/style/style_Common.css">
<link rel="stylesheet" href="/Proj_Quill_Pen/style/style_profile.css">
<script src="/Proj_Quill_Pen/source/jquery-3.6.0.min.js"></script>
<script src="/Proj_Quill_Pen/script/script.js"></script>
</head>
<body>
	<jsp:include page="/ind/headerTmp.jsp" />
	<div id="wrap">
		<main>
		<!-- form 영역 시작 -->
		<form id="profile_Frm" method = "post" action="">
			<!-- section#profile : 개인정보 수정 페이지 시작 -->
			<section id="profile">
				<div id="profile_title">
					<h1>My Quill Pen</h1>
				</div>
				<!-- div#profile_title -->
				<div id="profile_infoUpdate">
					<table>
						<tbody>
							<tr>
								<td>아이디</td>
								<td colspan="2">${mBean.uId}</td>
							</tr>
							<tr>
								<td>작가명</td>
								<td>${mBean.writer}</td>
							</tr>
							<tr>
								<td>이름</td>
								<td colspan="2">${mBean.uName}</td>
							</tr>
							<tr>
								<td>이메일</td>
								<td colspan="2">${mBean.uEmail}</td>
							</tr>
							<tr>
								<td>휴대폰 번호</td>
								<td colspan="2">${mBean.uPhone}</td>
							</tr>
							<tr>
								<td>생년 월일</td>
								<td colspan="2">${mBean.uBirth }</td>
							</tr>
						</tbody>
					</table>

				</div>
				<!-- div#profile_infoUpdate -->
				<div id="profile_profileUpdate">
					<table>
						<thead>
							<tr>
								<td id="writerName">작가명 : ${mBean.writer}</td>
								<td><img src="/Proj_Quill_Pen/images/profile/profile1.jpg" alt="프로필 이미지"></td>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td colspan="2" id="introArea"><textarea cols="30" rows="4"
										placeholder="소개글을 입력해주세요"></textarea></td>
							</tr>
						</tbody>
					</table>
				</div>
				<!-- div#profile_profileUpdate -->
				<div id="profile_pwUpdate">
					<table>
						<tbody>
							<tr>
								<td>비밀번호 변경</td>
								<td><input type="text" placeholder="새로 사용할 비밀번호를 입력해 주세요"></td>
							</tr>
							<tr>
								<td>비밀번호 변경 확인</td>
								<td><input type="text" placeholder="새로 사용할 비밀번호를 입력해 주세요"></td>
							</tr>
						</tbody>
					</table>
				</div>
				<!-- div#profile_pwUpdate -->
				
				
				<div id="profile_withdraw">
					<button type="button">수정하기</button>
					<button type="button">탈퇴하기</button>
				</div>
				<!-- div#profile_withdraw -->
				
			</section>
			<!-- section#profile : 개인정보 수정 페이지 끝 -->

			<!-- section#hidden : hidden input 영역 시작 -->
			<section id="hidden"></section>
			<!-- section#hidden : hidden input 영역 끝 -->
				</form>
				<!-- form 영역 끝 -->
		</main>
	</div>
	<jsp:include page="/ind/footerTmp.jsp" />
</body>
</html>