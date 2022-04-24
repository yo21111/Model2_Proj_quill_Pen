<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>회원탈퇴 페이지</title>
<link rel="stylesheet" href="/Proj_Quill_Pen/style/style_Common.css">
<script src="/Proj_Quill_Pen/source/jquery-3.6.0.min.js"></script>
<script src="/Proj_Quill_Pen/script/script.js"></script>
</head>
<body>
<jsp:include page="/ind/headerTmp.jsp"/>
	<div id="wrap">
		<main>
        <!-- section#withdraw : 탈퇴하기 페이지 시작 -->
        <section id="withdraw">
          <div id="withdraw_title">페이지 제목 출력</div>
          <!-- div#withdraw_title -->
          <div id="withdraw_info">탈퇴 관련 안내 멘트</div>
          <!-- div#withdraw_info -->
          <div id="withdraw_content">탈퇴 관련 안내</div>
          <!-- div#withdraw_content -->
          <div id="withdraw_agreement">
            <input type="checkbox">동의하시겠습니까?
          </div>
          <!-- div#withdraw_agreement -->
          <div id="withdraw_btn">
            <button type="button">탈퇴하기</button>
          </div>
          <!-- div#withdraw_btn -->
        </section>
        <!-- section#withdraw : 탈퇴하기 페이지 끝 -->

        <!-- section#hidden : hidden input 영역 시작 -->
        <section id="hidden"></section>
        <!-- section#hidden : hidden input 영역 끝 -->
      </main>
	</div>
	<jsp:include page="/ind/footerTmp.jsp"/>
</body>
</html>