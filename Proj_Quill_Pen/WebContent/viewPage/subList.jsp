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
<script src="/Proj_Quill_Pen/script/script_subList.js"></script>
</head>
<body>
	<jsp:include page="/ind/headerTmp.jsp" />
	<div id="wrap">

		<main>
			<!-- section#subList 구독자 목록 영역 시작 -->
			<section id="subList">
				<h1>해당 작가를 구독하는 ${subCnt }명</h1>
				<c:if test="${subCnt eq 0}">
					<a href="/Proj_Quill_Pen/main"><button type="button" id="mainBtn">메인으로</button></a>
				</c:if>
				<hr class="sepLine">
				<c:forEach var="WriterBean" items="${subsList }">
				<c:set var="i" value="${i+1}" />
				<div class="subsTbl">
					<table>
						<tbody>
							<tr>
								<td class="prof">
									<a href="/Proj_Quill_Pen/myPage?writer=${WriterBean.writer }">
										<img src="/Proj_Quill_Pen/images/test/${WriterBean.fileName }" alt="">
									</a>
								</td>
								<td>
									<a href="/Proj_Quill_Pen/myPage?writer=${WriterBean.writer }">${WriterBean.writer}의 블로그 입니다.</a>
								</td>
								<td>
								<c:if test="${myWriter.writer != WriterBean.writer }" >
									<c:choose>
										<c:when test="${alreadySub[i-1] eq 'true' }">
											<button class="subcancle_Btn" type="button">구독해제</button>
											<input type="hidden" value="${WriterBean.writer }">
										</c:when>
										<c:when test="${alreadySub[i-1] ne 'true' }">
											<button class="subscribe_Btn" type="button">구독하기</button>
											<input type="hidden" value="${WriterBean.writer }">
										</c:when>
									</c:choose>
								</c:if>
								</td>
							</tr>
						</tbody>
					</table>
				</div>
				</c:forEach>
			</section>
			<!-- section#subList 구독자 목록 영역 끝 -->

			<!-- section#hidden : hidden input 영역 시작 -->
			<section id="hidden">
				<input type="hidden" id="subMsg" value="${subMsg}">
				<input type="hidden" id="subCntList" value="${subCnt }">
				<input type="hidden" id="myId" value="${myId }">
			</section>
			<!-- section#hidden : hidden input 영역 끝 -->
		</main>

	</div>
	<jsp:include page="/ind/footerTmp.jsp" />
</body>
</html>