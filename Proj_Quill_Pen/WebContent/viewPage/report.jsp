<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>신고 페이지</title>
<link rel="stylesheet" href="/Proj_Quill_Pen/style/style_Common.css">
<script src="/Proj_Quill_Pen/source/jquery-3.6.0.min.js"></script>
<script src="/Proj_Quill_Pen/script/script.js"></script>
</head>
<body>
	<jsp:include page="/ind/headerTmp.jsp" />
	<div id="wrap">
		<main>
			<!-- section#report : 신고하기 페이지 시작 -->
			<!-- form 영역 시작 -->
			<form id="report_Frm" method="post" action="">
				<section id="report">
					<div id="report_title">페이지 제목 출력</div>
					<!-- div#report_title -->
					<div id="report_category">
						<select>
							<option>욕설</option>
							<option>폭력성</option>
							<option>선정적</option>
						</select>
					</div>
					<!-- div#report_category -->
					<div id="report_content">
						<textarea cols="30" rows="5" placeholder="신고사유를 입력해 주세요"></textarea>
					</div>
					<!-- div#report_content -->
					<div id="report_agreement">
						<p>약관내용</p>
						<input type="checkbox">동의하시겠습니까?
						<p>약관내용</p>
						<input type="checkbox">동의하시겠습니까?
					</div>

					<!-- div#report_agreement -->
					<div id="report_btn">
							<button type="button">신고하기</button>
					</div>
		
			<!-- div#report_btn -->
			</section>
			<!-- section#report : 신고하기 페이지 끝 -->

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