/**
 * 
 */

$(function(){
	
	// 공지사항 삭제
	$("#notice_Del").click(function(){
		let bnoArray = new Array();
		
		$("input[name='noticeBno[]']:checked").each(function(){
			let bno = $(this).val();
			bnoArray.push(bno);
		});
		let url = "/Proj_Quill_Pen/adminDel?bno[]=";
		for(let i=0; i<bnoArray.length; i++) {
			url += bnoArray[i];
			if(i<bnoArray.length-1) {
				url += "&&bno[]=";
			}
		}
		location.href = url;
	});
	
	
});