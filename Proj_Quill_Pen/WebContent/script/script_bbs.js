/**
 * 
 */

$(function(){
	// 게시글로 이동하기
	$("div.ContentDiv").click(function(){
		let bno = $(this).children().eq(0).text();
		
		let url = "/Proj_Quill_Pen/boardRead?bno=" + bno;
		location.href = url;
	});
	
	$("button#write_Btn").click(function(){
		let isLogin = $("input#isLogin").val();
		
		if (isLogin == "true") {
			let url = "/Proj_Quill_Pen/boardInsert";
			location.href = url;
		} else {
			alert("로그인 이후 사용 가능합니다.");
		}
	});
	
});