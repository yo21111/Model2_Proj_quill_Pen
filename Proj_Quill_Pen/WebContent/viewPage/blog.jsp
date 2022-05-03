<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>	
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
<title>마이페이지, 작가페이지</title>
<link rel="stylesheet" href="/Proj_Quill_Pen/style/style_Common.css">
<link rel="stylesheet" href="/Proj_Quill_Pen/style/style_blog.css">
<script src="/Proj_Quill_Pen/source/jquery-3.6.0.min.js"></script>
<script src="/Proj_Quill_Pen/script/script_blog.js"></script>
</head>
<body>
	<jsp:include page="/ind/headerTmp.jsp" />
	<div id="wrap">
		<main>
			<!-- section#blog_title : 작가 정보 영역 시작 -->
			<section id="blog_title">
				<div id="blog_title_container">
					<table id=profileTbl>
						<thead>
							<tr>
								<th>${writer}</th>
								<th rowspan="2">
									<div id="profileImg"><img src="/Proj_Quill_Pen/images/test/${fileName }" alt="${fileName }"></div>
								</th>
							</tr>
							<tr>
								<th id=introMent>${title}</th>
							</tr>
						</thead>
					</table>
				</div>
			</section>
			<!-- section#blog_title : 작가 정보 영역 끝 -->

			<!-- section#blog_subs : 작가 구독 영역 시작 -->
			<section id="blog_subs">
				<div id="blog_subs_container">
					<table id="subArea">
						<tbody>
							<tr>
								<td id="cntArea">
									<div>
										<button type="button" id="subCntBtn">구독자${subCnt }</button>
									</div>
									<div>
										<button type="button" id="likeWriter">관심작가${LikeCnt}</button> 
									</div>
								</td>
								<!-- <form id = "blog_Frm" method="" action=""> -->
								<td>
									<c:choose>
										<c:when test="${myId eq uId }"></c:when>
										<c:when test="${alreadySub eq 'true' }">
											<button id="subcancle_Btn" type="button">구독해제</button>
										</c:when>
										<c:when test="${alreadySub ne 'true' }">
											<button id="subscribe_Btn" type="button">구독하기</button>
										</c:when>
									</c:choose>
									<c:if test="${isAdmin ne 'true'}">
										<button id = "report_Btn" type="button">신고하기</button>
									</c:if>
								</td>
								<!-- </form> -->
							</tr>
						</tbody>
					</table>
				</div>
			</section>
			<!-- section#blog_subs : 작가 구독 영역 끝 -->

			<!-- section#blog_info : 작가 세부 정보 영역 시작 -->
			<section id="blog_info">
				<div id="blog_infos_container">
					<div id="info_content">
						<ul class="dFlex">
							<li><a href="#" id="navInt">작가소개</a></li>
							<li><a href="#" id="navList">작가의 글</a></li>
						</ul>
					</div>
					<div id="info_intro">
						<h1>소개</h1>
						<p>${content}</p>
					</div>
					<div id="info_writing">
						
						
							<!-- 관리자일 경우 -->
							<c:if test="${isAdmin eq 'true'}">
								<c:choose>
									<c:when test="${myNotice eq null}">
										<div id="nullTbl">게시글이 아직 없습니다.</div>
									</c:when>
									<c:when test="${myArticle ne null}">
										<c:forEach var="NoticeBean" items="${myNotice}">
											<table class="articleListTbl">
												<tbody>
													<tr>
														<td colspan="2" class="writeTitle">
															<input type="hidden" value="${NoticeBean.bno }">
															<a href="#">${NoticeBean.title}</a>
														</td>
														<td rowspan="3">
															<a href="#"><img src="/Proj_Quill_Pen/images/test/admin_profile.jpg" alt="썸네일"></a>
														</td>
													</tr>
													<tr>
														<td colspan="2" class="writeSubTitle">
															<div>${NoticeBean.content }</div>
														</td>
													</tr>
													<tr>
														<td colspan="2" class="etcArea">
																<div>${NoticeBean.writeDate }</div>
														</td>
													</tr>
												</tbody>
											</table>
											<hr class="sepLine">
										</c:forEach>
									</c:when>
								</c:choose>					
							</c:if>
							
							
							<!-- 유저일 경우 -->
							<c:if test="${isAdmin ne 'true'}">
								<c:choose>
									<c:when test="${myArticle eq '[]'}">
										<div id="nullTbl">게시글이 아직 없습니다.</div>
									</c:when>
									<c:when test="${myArticle ne '[]'}">
										<c:forEach var="BoardBean" items="${myArticle}">
											<table class="articleListTbl">
												<tbody>
													<tr>
														<td colspan="2" class="writeTitle">
															<input type="hidden" value="${BoardBean.bno }">
															<a href="#">${BoardBean.title}</a>
														</td>
														<td rowspan="3">
															<a href="#"><img src="/Proj_Quill_Pen/images/test/${BoardBean.fileName }" alt="썸네일"></a>
														</td>
													</tr>
													<tr>
														<td colspan="2" class="writeSubTitle">
															<span>${BoardBean.subTitle }</span>${BoardBean.content }
														</td>
													</tr>
													<tr>
														<td colspan="2" class="etcArea">
																<div>댓글0</div>
																<div>${BoardBean.modifyDate }</div>
														</td>
													</tr>
												</tbody>
											</table>
											<hr class="sepLine">
										</c:forEach>
									</c:when>
								</c:choose>					
							</c:if>			
					</div>
				</div>
			</section>
			<!-- section#blog_info : 작가 세부 정보 영역 끝 -->

			<!-- section#hidden : hidden input 영역 시작 -->
			<section id="hidden">				
				<input type="hidden" id="adminConfirm" value="${isAdmin eq 'true'}">
				<input type="hidden" id="writerSub" name=writer value="${writer }">
				<input type="hidden" id="myId" value="${myId }">
				
			</section>
			<!-- section#hidden : hidden input 영역 끝 -->
		</main>
	</div>
	<jsp:include page="/ind/footerTmp.jsp" />
</body>
</html>