<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
request.setCharacterEncoding("UTF-8");
String uId_Session = (String)session.getAttribute("uId_Session");
%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>구독자 목록 페이지</title>
<link rel="stylesheet" href="/Proj_Quill_Pen/style/style_Common.css">
<link rel="stylesheet" href="/Proj_Quill_Pen/style/style_subList.css">
<script src="/Proj_Quill_Pen/source/jquery-3.6.0.min.js"></script>
</head>
<body>
	<jsp:include page="/ind/headerTmp.jsp" />
	<div id="wrap">

		<main>
			<!-- section#subList 구독자 목록 영역 시작 -->
			<section id="subList">
				<h1>해당 작가를 구독하는 0명</h1>
				<hr class="sepLine">
				<c:forEach var="WriterBean" items="${subsList }">
				<div class="subsTbl">
					<table>
						<tbody>
							<tr>
								<td rowspan="2" class="prof">
									<img src="/Proj_Quill_Pen/images/test/${WriterBean.fileName }" alt="">
								</td>
								<td>${WriterBean.writer}</td>
								<td rowspan="2" class="subBtn">
									<button type="button">구독하기</button>
								</td>
							</tr>
							<tr>
								<td>${WriterBean.writer}의 블로그입니다.</td>
							</tr>
						</tbody>
					</table>
				</div>
				</c:forEach>
			</section>
			<!-- section#subList 구독자 목록 영역 끝 -->

			<!-- section#hidden : hidden input 영역 시작 -->
			<section id="hidden"></section>
			<!-- section#hidden : hidden input 영역 끝 -->
		</main>

	</div>
	<jsp:include page="/ind/footerTmp.jsp" />
</body>
</html>