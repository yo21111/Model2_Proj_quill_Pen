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
	
});