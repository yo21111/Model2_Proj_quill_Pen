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
<link rel="stylesheet" href="/Proj_Quill_Pen/style/style_report.css">
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
					<div id="report_title">
						<h2>신고하기</h2>
					</div>
					<!-- div#report_title -->

					<div id="report">
						<span class="dFlex">홍보, 영리목적 <input type="radio" name="report" value="promote"></span>
						<span class="dFlex">욕설, 비방, 차별, 혐오 <input type="radio" name="report" value="curse"></span>
						<span class="dFlex">폭력성 <input type="radio" name="report" value="violence"></span>
						<span class="dFlex">음란, 청소년 유해 <input type="radio" name="report" value="sexuality"></span>
						<span class="dFlex">기타 <input type="radio" name="report" value="etc"></span>
					
						<br>
					

						불법촬영물 유통 신고<input type="radio" name="report" value="illegal_filming">
						<p>
							불법촬영물등 유통 신고는 전기통신 사업법 시행령에 따라, 신고인의 개인정보 수집 이용 동의와 신고 사유 등 신고서
							제출이 필요합니다. 음란, 청소년 유해 사유로 신고하시면, 신고서 제출 없이 더 빠르게 조치됩니다.
						</p>
						권리침해 신고<input type="radio" name="report"
							value="violate_right">
						<p>권리침해 신고는 먼저 침해한 게시물을 신고후 '깃펜 권리 침해 신고 사이트'에서 침해 증빙 서류를 다운
							받아 내용을 작성하여 고객센터로 온라인 접수하면 처리됩니다.</p>
					</div>

					<div id="report_content">
						<textarea name="report_content" cols="50" rows="5"
							placeholder="신고사유를 입력해 주세요"></textarea>
					</div>
					<!-- div#report_content -->

					<!-- div#report_agreement -->
					<div id="report_btn">
						<button id="reset_Btn" type="reset">취소</button>
						<button id="report_Btn" type="submit">신고</button>
					</div>

					<!-- div#report_btn -->
				</section>
				<!-- section#report : 신고하기 페이지 끝 -->

				<!-- section#hidden : hidden input 영역 시작 -->
				<section id="hidden">
					<input type="hidden" name="category" value="${param.category }">
					<input type="hidden" name="bno" value="${param.bno }">
				</section>
				<!-- section#hidden : hidden input 영역 끝 -->
			</form>
			<!-- form 영역 끝 -->
		</main>
	</div>
	<jsp:include page="/ind/footerTmp.jsp" />
</body>
</html>