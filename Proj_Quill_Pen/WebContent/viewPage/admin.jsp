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
<link rel="stylesheet" href="/Proj_Quill_Pen/style/style_Common.css">
<script src="/Proj_Quill_Pen/source/jquery-3.6.0.min.js"></script>
<script src="/Proj_Quill_Pen/script/script.js"></script>
</head>
<body>
	<jsp:include page="/ind/headerTmp.jsp" />
	<div id="wrap">
		<main>
        <!-- section#noticeList : 공지사항 영역 시작 -->
        <section id="noticeList">
          <div id="noticeList_title">공지사항 영역 제목</div>
          <div id="noticeList_container">공지사항 목록 출력

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
                    <td>test</td>
                    <td>test</td>
                    <td>test</td>
                    <td>test</td>
                  </tr>
                </tbody>
                <tfoot>
                  <tr>
                    <td colspan="4">
                    
                      <button id = "notice_Btn" type="button" >작성하기</button>
                      
                    </td>
                  </tr>
                </tfoot>
              </table>

          </div>
        </section>
        <!-- section#noticeList : 공지사항 영역 끝 -->

        <!-- section#reportList : 신고목록 영역 시작 -->
        <section id="reportList">
          <div id="reportList_title">신고 영역 제목</div>
          <div id="reportList_container">신고 접수 목록 출력

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
                  <td>test</td>
                  <td>test</td>
                  <td>test</td>
                  <td>test</td>
                </tr>
              </tbody>
              <tfoot>
                <tr>
                  <td colspan="4">
                  <form id = "adminReport_Frm" method="" action="">
                    <button type="button">작성하기</button>
                   </form>
                  </td>
                </tr>
              </tfoot>
            </table>

          </div>
        </section>
        <!-- section#reportList : 신고목록 영역 끝 -->

        <!-- section#bookList : 책소개 영역 시작 -->
        <section id="bookList">
          <div id="bookList_title">책소개 영역 제목</div>
          <div id="bookList_container">책소개 목록 출력</div>
        </section>
        <!-- section#bookList : 책소개 영역 끝 -->
      </main>
	</div>
	<jsp:include page="/ind/footerTmp.jsp" />	
</body>
</html>