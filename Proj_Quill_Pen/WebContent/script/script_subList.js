/**
 * 
 */
$(function(){
	
	$(document).ready(function(){
		let cnt = $("#subCntList").val();
		let txt = "현재 구독자가 없습니다";
		if(cnt==0) {
			$("#subList>h1").text(txt);
		}
	});
	
	
		// 구독 버튼 선택시
	$(".subscribe_Btn").click(function(){
		
		let writer = $(this).next().val();
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
	$(".subcancle_Btn").click(function(){
		let result = confirm("정말 구독을 취소하시겠습니까?")
		if(result) {
			alert("구독이 취소되었습니다.")
			let writer = $(this).next().val();
			let url = "/Proj_Quill_Pen/subcancle?writer=" + writer;
			location.href = url;	
		} 
	});
	
});