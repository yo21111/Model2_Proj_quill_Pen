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
<title>게시판 내용 출력 페이지</title>
<link rel="stylesheet" href="/Proj_Quill_Pen/style/style_Common.css">
<link rel="stylesheet" href="/Proj_Quill_Pen/style/style_notice.css">
<script src="/Proj_Quill_Pen/source/jquery-3.6.0.min.js"></script>
<script src="/Proj_Quill_Pen/script/script_notice.js"></script>
</head>
<body>
	<jsp:include page="/ind/headerTmp.jsp" />
	<div id="wrap">

		<main>
			<!-- section#bbs_title : 게시판 제목 영역 시작 -->
			<section id="noticeBBS">
				<div id="noticeBBS_title">
					<h1><c:out value= "${noticeBean.title}" /></h1>
				</div>
				
				<div id="notice_header_info">
					<span><a href="#">${noticeBean.mId}</a></span>
					<span>${noticeBean.writeDate}</span>
				</div>
				<div id="noticeBBS_container">
					<c:out value= "${noticeBean.title}" />
				</div>
			</section>
			<!-- section#bbs_title : 게시판 제목 영역 끝 -->
			
			<!-- section#bbs_profile : 관리자 프로필 시작 -->
			<section id="noticeBBS_profile">
				<div id="admin_profile">
					<table>
						<tbody>
							<tr>
								<td id="admin_name"><a href="#"><c:out value= "${noticeBean.mId}" /></a></td>
								<td rowspan="2">
									<a href="#" id="adminImg">
										<img src="/Proj_Quill_Pen/images/profile/admin_profile.jpg" alt="관리자 프로필">
									</a>
								</td>
							</tr>
							<tr>
								<td id="admin_subName">Team Quill Pen</td>
							</tr>
							<tr>
								<td colspan="2" id="introMent">누구나 자유롭게 글을 쓰는 공간 Quill Pen.</td>
							</tr>
							<tr>
								<td id="subCnt">
									<button type="button">구독자${subCnt }</button>
								</td>
								<td id="subBtn">
									<c:choose>
										<c:when test="${isAdmin eq 'true'}"></c:when>
										<c:when test="${alreadySub eq 'true' }">
											<button id="subcancle_Btn" type="button">구독해제</button>
										</c:when>
										<c:when test="${alreadySub ne 'true' }">
											<button id="subscribe_Btn" type="button">구독하기</button>
										</c:when>
									</c:choose>
								</td>
							</tr>
						</tbody>
					</table>
				</div>
				<div id="btnArea">
					<c:if test="${isAdmin eq 'true'}">
						<button type="button" id=writeNotice class=noticeBtn>글쓰기</button>
					</c:if>
					<button type="button" id="noticeList" class=noticeBtn>목록으로</button>
				</div>
			</section>

			<!-- section#hidden : hidden input 영역 시작 -->
			<section id="hidden">
				<input type="hidden" id="writerProfile"  name="writerProfile" value="${noticeBean.writer}">
				<input type="hidden" id="myId" value="${myId}">
			</section>
			<!-- section#hidden : hidden input 영역 끝 -->
		</main>

	</div>
	<jsp:include page="/ind/footerTmp.jsp" />
</body>
</html>