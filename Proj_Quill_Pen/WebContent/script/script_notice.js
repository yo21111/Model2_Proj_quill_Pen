/**
 * 
 */

$(function(){
	
	
	// 공지사항 리스트에서 글쓰기 선택시
	$("#write_Btn").click(function(){
		let errorMsg = $("#errorMsg").val();
		if(errorMsg != "") {
			alert(errorMsg);
		}
	});
	
	
	// 공지사항 페이지에서 목록으로 선택시 
	$("#noticeList").click(function(){
		let url = "/Proj_Quill_Pen/Notice";
		location.href=url;
	});
	
	
	// 공지사항 리스트에서 게시글 선택시
	$(".ContentDiv").click(function() {
		let bno = $(this).children().eq(0).text();
		let url = "/Proj_Quill_Pen/NoticeContent?bno=" + bno;
		location.href = url;
	});
	
	
	// 관리자 프로필 선택시
	$("#adminImg").click(function(){
		let writer = $("#writerProfile").val();
		alert(writer);
		let url = "/Proj_Quill_Pen/myPage?writer=" + writer;
		location.href=url;
	});
	
	
	
});