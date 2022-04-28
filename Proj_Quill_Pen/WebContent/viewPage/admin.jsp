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
<title>관리자 페이지</title>
<link rel="stylesheet" href="/style/style_admin.css">
<script src="/Proj_Quill_Pen/source/jquery-3.6.0.min.js"></script>
<script src="/Proj_Quill_Pen/script/script.js"></script>
</head>
<body>
	<!-- <jsp:include page="/ind/headerTmp.jsp" /> -->
	<div id="wrap">
		<main>
        <!-- section#noticeList : 공지사항 영역 시작 -->
        <section id="noticeList">
          <div id="noticeList_title">공지사항 영역 제목</div>
          <div id="noticeList_container">

              <table>
                <thead>
                  <tr>
                    <td>번호</td>
                    <td>제목</td>
                    <td>작성자</td>
                    <td>작성일시</td>
                  </tr>
                </thead>
                <tbody>
                  <tr>
                    <td><input type="checkbox" value="${bno}">${bno}</td>
                    <td>${title}</td>
                    <td>${mid}</td>
                    <td>${writeDate}</td>
                  </tr>
                </tbody>
                <tfoot>
 
                </tfoot>
              </table>

              <form id="admin_notice_frm">

                <button class = "notice_Btn" type="button" >작성하기</button>
                <button class = "notice_Btn" type="button" >수정하기</button>
                <button class = "notice_Btn" type="button" >삭제하기</button>
                
                   </form>
          </div>
        </section>
        <!-- section#noticeList : 공지사항 영역 끝 -->

        <!-- section#reportList : 신고목록 영역 시작 -->
        <section id="reportList">
          <div id="reportList_title">신고 영역 제목</div>
          <div id="reportList_container">

            <table>
              <thead>
                <tr>
                  <td>번호</td>
                  <td>제목</td>
                  <td>작성자</td>
                  <td>작성일시</td>
                </tr>
              </thead>
              <tbody>
                <tr>
                  <td><input type="checkbox" value="${bno}">${bno}</td>
                  <td>게시글${title}</td>
                  <td>${writer}</td>
                  <td>${writeDate}</td>
                </tr>
              </tbody>
        
            </table>

            <form id = "adminReport_Frm" method="" action="">
              <button type="button">삭제하기</button>
             </form>
          </div>
        </section>
        <!-- section#reportList : 신고목록 영역 끝 -->

        <!-- section#bookList : 책소개 영역 시작 -->
        <section id="bookList">
          <div id="bookList_title">책소개 영역 제목</div>
          <div id="bookList_container">
            
            <table>
              <thead>

                <tr>
               
                  <td>제목</td>
                  <td>소개글</td>
                  <td>작성자</td>
                  <td>카테고리</td>

           
          
                </tr>
                
              </thead>

                <tbody>
                <tr>
                
                  <td><input type="checkbox" value="${bookNo}">${title}</td>
                  <td>${subTitle}</td>
                  <td>${title}</td>
                  <td>${category}</td>

                </tr>
              </tbody>
            </table>

          <form  id="bookfrm">
            <button id="bookBtn" type="button">삭제하기</button>
            <button id="bookBtn" type="button">등록하기</button>
          </form>
            
            
          </div>
        </section>
        <!-- section#bookList : 책소개 영역 끝 -->
      </main>
	</div>
	<!-- <jsp:include page="/ind/footerTmp.jsp" />	 -->
</body>
</html>