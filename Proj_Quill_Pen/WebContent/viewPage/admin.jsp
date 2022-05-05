<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
request.setCharacterEncoding("UTF-8");
String uId_Session = (String) session.getAttribute("uId_Session");
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>관리자 페이지</title>
<link rel="stylesheet" href="/Proj_Quill_Pen/style/style_admin.css">
<script src="/Proj_Quill_Pen/source/jquery-3.6.0.min.js"></script>
<script src="/Proj_Quill_Pen/script/script_admin.js"></script>
</head>
<body>
	<jsp:include page="/ind/headerTmp.jsp" />
	<div id="wrap">
		<main>
        <!-- section#noticeList : 공지사항 영역 시작 -->
        <section id="noticeList">
          <div id="noticeList_title"><h1>공지사항 목록</h1></div>
          <div id="noticeList_container">


                <c:choose>
                	<c:when test="${noticeList eq '[]' }">
                		<div class="nullTbl">게시글이 존재하지 않습니다.</div>
                	</c:when>
                	<c:when test="${noticeList ne '[]' }">
						  <table class="noticeTbl">
			                <thead>
			                  <tr>
			                    <td>번호</td>
			                    <td>제목</td>
			                    <td>작성자</td>
			                    <td>작성일시</td>
			                  </tr>
			                </thead>
						<c:forEach var="NoticeBean" items="${noticeList }">
			                <tbody>
			                  <tr class="noticeSel">
			                    <td><input type="checkbox" name="noticeBno[]" value="${NoticeBean.bno}">${NoticeBean.bno}</td>
			                    <td class="noticeTsel">${NoticeBean.title}</td>
			                    <td>${NoticeBean.mId}</td>
			                    <td>${NoticeBean.writeDate}</td>
			                  </tr>
			                </tbody>
		                </c:forEach>                	
			              </table>
                	</c:when>
                </c:choose>
                
              <form id="admin_notice_frm">
			  			
                <button id="notice_Ins" class = "notice_Btn" type="button" >작성하기</button>
                <button id="notice_Del" class = "notice_Btn" type="button" >삭제하기</button>
                
              </form>
          </div>
        </section>
        <!-- section#noticeList : 공지사항 영역 끝 -->

        <!-- section#reportList : 신고목록 영역 시작 -->
        <section id="reportList">
          <div id="reportList_title"><h1>신고글 목록</h1></div>
          <div id="reportList_container">

              <c:choose>
              	<c:when test="${declList eq '[]' }">
 					<div class="nullTbl">게시글이 존재하지 않습니다.</div>          	
              	</c:when>
              	<c:when test="${declList ne '[]' }">
		             <table>
		              <thead>
		                <tr>
		                  <td>번호</td>
		                  <td>제목</td>
		                  <td>작성자</td>
		                  <td>작성일시</td>
		                </tr>
		              </thead>
              		<c:forEach var="DeclBean" items="${declList }">
		              <tbody>
		                <tr class="declSel">
		                  <td><input type="checkbox" name="declDno[]" value="${DeclBean.dno}">${DeclBean.dno}</td>
		                  <td class="declTsel">
		                  	${DeclBean.bno}번게시글을 신고하였습니다.
		                  	<input type="hidden" class="declBno" value="${DeclBean.bno }">
		                  	<input type="hidden" class="declDno" value="${DeclBean.dno }">
		                  </td>
		                  <td>${DeclBean.writer}</td>
		                  <td>${DeclBean.writeDate}</td>
		                </tr>
		              </tbody>
		        	</c:forEach>
		             </table>
              	</c:when>
              </c:choose>

            <form id = "adminReport_Frm" method="get" action="">
              <button id="report_Del" type="button">삭제하기</button>
            </form>
          </div>
        </section>
        <!-- section#reportList : 신고목록 영역 끝 -->

        <!-- section#bookList : 책소개 영역 시작 -->
        <section id="bookList">
          <div id="bookList_title"><h1>책 소개 글 목록</h1></div>
          <div id="bookList_container">
            
              <c:choose>
              	<c:when test="${bookList eq '[]' }">
              		<div class="nullTbl">게시글이 존재하지 않습니다.</div>
              	</c:when>
              	<c:when test="${bookList ne '[]' }">
		        	 <table id="bookTbl">
		              <thead>
		                <tr>
		                  <td>제목</td>
		                  <td>소개글</td>
		                  <td>작성자</td>
		                  <td>카테고리</td>
		                </tr>
		              </thead>
		        	<c:forEach var="BookBean" items="${bookList }">
		              <tbody>
		                <tr class="bookSel">
		                  <td><input type="checkbox" name="bookBookno[]" value="${BookBean.bookNo}">${BookBean.title}</td>
		                  <td class="bookTsel">${BookBean.subTitle}<input type="hidden" value="${BookBean.fileName}"></td>
		                  <td>${BookBean.title}</td>
		                  <td>${BookBean.category}</td>
		                </tr>
		              </tbody>
		            </c:forEach>
		             </table>
              	</c:when>
              </c:choose>
            
          <form  id="bookfrm">
            <button id="book_Ins" class="bookBtn" type="button">등록하기</button>
            <button id="book_Del" class="bookBtn" type="button">삭제하기</button>
          </form>
          <div id="sumnail"></div>
            
          </div>
        </section>
        <!-- section#bookList : 책소개 영역 끝 -->
      </main>
	</div>
	<jsp:include page="/ind/footerTmp.jsp" />
</body>
</html>