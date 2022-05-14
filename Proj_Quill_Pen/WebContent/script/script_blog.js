/**
 * 
 */


$(function(){
	
	/* 마우스 올렸을 때 제목 밑줄 효과 */
	$(".noitceListTbl").hover(function(){
		$(this).css("cursor", "pointer");
		$(this).children().children().children().first().css("text-decoration", "underline");
	}, function(){
		$(".writeTitle").css("text-decoration", "none");
	});
	
	// 공지사항 선택시 이동 
	$(".noticeListTbl").click(function(){
		let bno = $(this).children().children().children().children().first().val();
		let result = $("#adminConfirm").val();
		if(result) {
			let url = "/Proj_Quill_Pen/NoticeContent?bno=" + bno;
			location.href = url;			
		}

	});
	
	
	/* 마우스 올렸을 때 제목 밑줄 효과 */
	$(".articleListTbl").hover(function(){
		$(this).css("cursor", "pointer");
		$(this).children().children().children().first().css("text-decoration", "underline");
	}, function(){
		$(".writeTitle").css("text-decoration", "none");
	});
	
	// 공지사항 선택시 이동 
	$(".articleListTbl").click(function(){
		let bno = $(this).children().children().children().children().first().val();
		let url = "/Proj_Quill_Pen/boardRead?bno=" + bno;
		location.href = url;			
	});
	
	
	
	
	
	
	// 관심글 클릭시
	$("#likeWriter").click(function(){
		let uId = $("#submitId").val();
		let url = "/Proj_Quill_Pen/likePost?uId=" + uId;
		location.href = url; 
	});
	
	// 관심글 마우스 올릴시
	$(".likeArticle").hover(function(){
		$(this).css("cursor", "pointer");
		$(this).children().children().children().first().css("text-decoration", "underline");
	}, function(){
		$(".writer_name").css("text-decoration", "none");
	});
	
	// 메인으로 버튼(blogList.jsp)
	$("#subMain").click(function(){
		let url = "/Proj_Quill_Pen/main";
		location.href=url;
	});
   // 수정하기 버튼(profile.jsp)	

	$("#Profile_Btn").click(function(){
		let url ="/Proj_Quill_Pen/profile";
		location.href = url;
	});
	
  // 신고목록 버튼(report.jsp)	
	    $("#reports_Btn").click(function(){
		let url = "/Proj_Quill_Pen/admin";
		location.href = url;
	})
	
	/* 네이게이션 클릭했을때 나타나는 글 전환용 */
	$("#navInt").click(function(){
		$(this).css("border-top","1px solid black");
		$("#info_intro").show();
		$("#navList").css("border-top","none");
		$("#info_writing").hide();
	});
	
	$("#navList").click(function(){
		$(this).css("border-top","1px solid black");
		$("#info_writing").show();
		$("#navInt").css("border-top","none");
		$("#info_intro").hide();
	});
	
	
	// 구독 버튼 선택시
	$("#subscribe_Btn").click(function(){
		
		let writer = $("#writerSub").val();
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
			let writer = $("#writerSub").val();
			let url = "/Proj_Quill_Pen/subcancle?writer=" + writer;
			location.href = url;	
		} 
	});
	
	// 구독자 수 선택시
	$("#subCntBtn").click(function(){
	 	let writer = $("#writerSub").val();
		let url ="/Proj_Quill_Pen/subscribe?writer=" + writer;
		location.href=url; 
	}); 
	
	
	
	
	
	
	
	
	
	
	
	
	
	
});