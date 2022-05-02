/**
 * 
 */


$(function(){
	
	/* 마우스 올렸을 때 제목 밑줄 효과 */
	$("#info_writing").hover(function(){
		$("#writeTitle").css("text-decoration", "underline");
	}, function(){
		$("#writeTitle").css("text-decoration", "none");
	});
	
	
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