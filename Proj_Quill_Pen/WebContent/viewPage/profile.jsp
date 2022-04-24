<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>설정 페이지(개인정보수정)</title>
<link rel="stylesheet" href="/Proj_Quill_Pen/style/style_Common.css">
<script src="/Proj_Quill_Pen/source/jquery-3.6.0.min.js"></script>
<script src="/Proj_Quill_Pen/script/script.js"></script>
</head>
<body>
	<jsp:include page="/ind/headerTmp.jsp" />
	<div id="wrap">
		<main>
			<!-- section#profile : 개인정보 수정 페이지 시작 -->
			<section id="profile">
				<div id="profile_title">페이지 제목 출력</div>
				<!-- div#profile_title -->
				<div id="profile_infoUpdate">
					<table>
						<tbody>
							<tr>
								<td>아이디</td>
								<td colspan="2">test</td>
							</tr>
							<tr>
								<td>작가명</td>
								<td>test</td>
								<td><button type="button">변경하기</button></td>
							</tr>
							<tr>
								<td>이름</td>
								<td colspan="2">test</td>
							</tr>
							<tr>
								<td>이메일</td>
								<td colspan="2">test@naver.com</td>
							</tr>
							<tr>
								<td>휴대폰 번호</td>
								<td colspan="2">010-1111-1111</td>
							</tr>
							<tr>
								<td>생년 월일</td>
								<td colspan="2">1111-11-11</td>
							</tr>
						</tbody>
					</table>

				</div>
				<!-- div#profile_infoUpdate -->
				<div id="profile_profileUpdate">
					<table>
						<thead>
							<tr>
								<td>이름</td>
								<td>프로필사진</td>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td colspan="2"><textarea cols="30" rows="2"
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
								<td><input type="text"></td>
							</tr>
							<tr>
								<td>비밀번호 변경 확인</td>
								<td><input type="text"></td>
							</tr>
						</tbody>
					</table>
				</div>
				<!-- div#profile_pwUpdate -->
				<div id="profile_withdraw">
					<button type="button">탈퇴하기</button>
				</div>
				<!-- div#profile_withdraw -->
			</section>
			<!-- section#profile : 개인정보 수정 페이지 끝 -->

			<!-- section#hidden : hidden input 영역 시작 -->
			<section id="hidden"></section>
			<!-- section#hidden : hidden input 영역 끝 -->
		</main>
	</div>
	<jsp:include page="/ind/footerTmp.jsp" />
</body>
</html>