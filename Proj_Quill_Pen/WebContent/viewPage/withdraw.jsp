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
<title>회원탈퇴 페이지</title>
<link rel="stylesheet" href="/Proj_Quill_Pen/style/style_withdraw.css">
<script src="/Proj_Quill_Pen/source/jquery-3.6.0.min.js"></script>
<script src="/Proj_Quill_Pen/script/script.js"></script>
</head>
<body>
	<jsp:include page="/ind/headerTmp.jsp" />
	<div id="wrap">
		<main>
			<!-- form 영역 시작 -->
			<form id="withdraw_Frm" method="post" action="">
				<!-- section#withdraw : 탈퇴하기 페이지 시작 -->
				<section id="withdraw">
					<div id="withdraw_title">
						<h1>깃펜 탈퇴하기</h1>
					</div>
					<!-- div#withdraw_title -->
					<div id="withdraw_info">
						<p>
							탈퇴하시면 이용 중인 깃펜이 폐쇄되며, <span>모든 데이터는 복구가 불가능합니다.</span>
						</p>
						<p>아래 사항을 확인하신 후에 신중하게 결정해 주세요.</p>

					</div>
					<!-- div#withdraw_info -->
					<div id="withdraw_content">
						<ul>
							<li class="withdrawLi">작성한 글, 매거진, 첨부파일 등 모든 정보가 삭제됩니다.</li>
							<li class="withdrawLi">깃펜 프로필 및 연결된 SNS 정보 등이 모두 삭제됩니다.</li>
							<li class="withdrawLi">작성한 댓글은 삭제되지 않고 남게 되오니 탈퇴 전 미리 확인하시기
								바랍니다.</li>
						</ul>
					</div>
					<!-- div#withdraw_content -->
					<div id="withdraw_agreement">
						<input type="checkbox" class="withdrawAgreeChk"><span>안내
							사항을 모두 확인하였으며, 이에 동의합니다.</span>
					</div>
					<!-- div#withdraw_agreement -->
					<div id="withdraw_btn">
						<button id="withdraw_btn" type="submit">탈퇴하기</button>
					</div>
					<!-- div#withdraw_btn -->
				</section>
				<!-- section#withdraw : 탈퇴하기 페이지 끝 -->

				<!-- section#hidden : hidden input 영역 시작 -->
				<section id="hidden"></section>
				<!-- section#hidden : hidden input 영역 끝 -->
			</form>
			<!-- form 영역 끝 -->
		</main>
	</div>

</body>
</html>