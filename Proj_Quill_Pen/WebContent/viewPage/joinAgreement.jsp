<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

	<!DOCTYPE html>
	<html lang="ko">
	<head>
		<meta charset="UTF-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<title>회원가입동의</title>
		<link rel="stylesheet" href="/Proj_Quill_Pen/style/style_joinAgreement.css">
		<script src="/Proj_Quill_Pen/source/jquery-3.6.0.min.js"></script>
		<script src="/Proj_Quill_Pen/script/script_Join.js"></script>
	</head>
	
	<body>
	
				   <div id="termArea">
					<h3>[필수] 블로그 이용약관 동의</h3>
	
					<iframe src="/Proj_Quill_Pen/ind/blogAgree.jsp" id="blogAgree"></iframe>
					<br>
					<label>
						<span id="blogAgreeSpan">이용약관에 동의하십니까?</span>
						<input type="checkbox" class="blogAgreeChk"
						data-link="0"> 동의 <span id="agreeNecessary">*</span>
					</label> 
				   </div>
	
	</body>
	
	</html>