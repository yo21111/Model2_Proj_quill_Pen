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
		let url = "/Proj_Quill_Pen/myPage?writer=" + writer;
		location.href=url;
	});
	
	// 구독 버튼 선택시
	$("#subscribe_Btn").click(function(){
		
		let writer = $("#writerProfile").val();
		let myid = $("#myId").val();
		if(myid==""){
			alert("로그인이 필요한 서비스 입니다.");
		} else {
			let result = confirm("구독하시겠습니까?");
			if(result) {
				alert("구독이 완료되었습니다.")
				let url = "/Proj_Quill_Pen/subscribeInsert?writer=" + writer;
				location.href = url;				
			}
	
		}	 
	});
	
	// 구독 해제 선택시
	$("#subcancle_Btn").click(function(){
		let result = confirm("정말 구독을 취소하시겠습니까?")
		if(result) {
			alert("구독이 취소되었습니다.")
			let writer = $("#writerProfile").val();
			let url = "/Proj_Quill_Pen/subcancle?writer=" + writer;
			location.href = url;	
		} 
	});
	
	
	// 구독자 수 선택시
	$("#subCnt").click(function(){
	 	let writer = $("#writerProfile").val();
		let url ="/Proj_Quill_Pen/subscribe?writer=" + writer;
		location.href=url; 
	});
	
	// 삭제하기 선택시
	$("#deleteBtn").click(function(){
		let result = confirm("정말 삭제하시겠습니까?");
		if(result) {
			let bno = $("#submitBno").val();
			let url = "/Proj_Quill_Pen/NoticeDel?bno=" + bno;
			location.href=url;			
		}
	});
	
	// 수정하기 선택시
	$("#modifyBtn").click(function(){
		let result = confirm("현재 글을 수정하시겠습니까?");
		if(result) {
			let bno = $("#submitBno").val();
			let mId =$("#myId").val();
			let title = $("#submitTitle").val();
			let content = $("#submitContent").val();
			let type = "mod";
			let url = "/Proj_Quill_Pen/NoticeMod?bno=" + bno;
			url += "&&mId=" + mId;
			url += "&&title=" + title;
			url += "&&content=" + content;
			url += "&&type=" + type;
			location.href = url;			
		}	
	});
	
	// 글쓰기 선택시
	$("#writeNotice").click(function(){
		let writer = $("#submitWriter").val();
		let type = $("#submitType").val();
		let url = "/Proj_Quill_Pen/NoticeIns?writer=" + writer;
		url += "&&type=" + type;
		location.href = url;
	});
	
	
});