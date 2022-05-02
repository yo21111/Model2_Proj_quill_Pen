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
		$("#info_intro").css("display","block")
		$("#navList").css("border-top","none");
		$("#info_writing").css("display","none")
	});
	
	$("#navList").click(function(){
		$(this).css("border-top","1px solid black");
		$("#info_writing").css("display","block")
		$("#navInt").css("border-top","none");
		$("#info_intro").css("display","none")
	});
	
	// 구독 버튼 선택시
	$("#subscribe_Btn").click(function(){
		let writer = $("#writerSub").val();
		alert(writer);
		let url = "/Proj_Quill_Pen/subscribeInsert?writer=" + writer;
		location.href = url; 
	});
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
});