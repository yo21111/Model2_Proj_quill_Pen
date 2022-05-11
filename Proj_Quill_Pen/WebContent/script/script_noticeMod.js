/**
 * 
 */
$(function(){
	
	// 등록 선택시(수정하기)
	$("#modify_Btn").click(function(){
		let result = confirm("현재 글로 수정하시겠습니까?");
		if(result) {
			/*
			let type = "insert";
			let bno = $("#bno").val();
			let mId =$("#myId").val();
			let title = $("#title").val();
			let content = $("#content").val();			
			let url = "/Proj_Quill_Pen/NoticeMod?bno=" + bno;
			url += "&&mId=" + mId;
			url += "&&title=" + title;
			url += "&&content=" + content;
			url += "&&type=" + type;
			location.replace(url);
			*/			
			$("#reNoticeFrm").submit();
		}
	});
	
	
	// 등록 선택시(글쓰기)
	$("#insert_Btn").click(function(){
		let result = confirm("현재 글을 등록하시겠습니까?");
		if(result) {
			$("#inNoticeFrm").submit();
		}
	});
	
	// 목록으로 선택시
	$("#bbs_Btn").click(function(){
		let url = "/Proj_Quill_Pen/Notice";
		location.href = url;
	});
	
	
	
	
	
	
	
	
	
	
});