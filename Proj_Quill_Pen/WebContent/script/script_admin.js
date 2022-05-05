/**
 * 
 */

$(function(){
	// 공지사항 마우스 올릴 시 효과
	$(".noticeSel").hover(function(){
		$(this).css("cursor", "pointer");
		$(this).children().css("font-weight", "bold");
	}, function(){
		$(".noticeSel").children().css("font-weight", "normal");
	});
	
	// 신고글 마우스 올릴 시 효과
	$(".declSel").hover(function(){
		$(this).css("cursor", "pointer");
		$(this).children().css("font-weight", "bold");
	}, function(){
		$(".declSel").children().css("font-weight", "normal");
	});
	
	// 책소개 마우스 올릴 시 효과
	$(".bookSel").hover(function(){
		$(this).css("cursor", "pointer");
		$(this).children().css("font-weight", "bold");
	}, function(){
		$(".bookSel").children().css("font-weight", "normal");
	});
	
	
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
	
	
	// 신고글 삭제
	$("#report_Del").click(function(){
		let dnoArray = new Array();
		
		$("input[name='declDno[]']:checked").each(function(){
			let dno = $(this).val();
			dnoArray.push(dno);
		});
		let url = "/Proj_Quill_Pen/adminDel?dno[]=";
		for(let i=0; i<dnoArray.length; i++) {
			url += dnoArray[i];
			if(i<dnoArray.length-1) {
				url += "&&dno[]=";
			}
		}
		location.href = url;
	});
	
	
	
	// 책소개 삭제
	$("#book_Del").click(function(){
		let bookNoArray = new Array();
		
		$("input[name='bookBookno[]']:checked").each(function(){
			let bookNo = $(this).val();
			bookNoArray.push(bookNo);
		});
		let url = "/Proj_Quill_Pen/adminDel?bookNo[]=";
		for(let i=0; i<bookNoArray.length; i++) {
			url += bookNoArray[i];
			if(i<bookNoArray.length-1) {
				url += "&&bookNo[]=";
			}
		}
		location.href = url;
	});
	
	
	// 공지사항 게시글 선택 시 
	$(".noticeTsel").click(function(){
		let bno = $(this).prev().children().val();
		let url = "/Proj_Quill_Pen/NoticeContent?bno=" + bno;
		location.href = url;
	});
	
	// 신고 게시글 선택 시 
	$(".declTsel").click(function(){
		let bno = $(this).children().val();
		let dno = $(this).children().next().val();
		let url = "/Proj_Quill_Pen/boardRead?bno=" + bno;
		url += "&&dno=" + dno;
		location.href = url;
	});
	
	// 책 썸네일 미리보기
	$(".bookTsel").click(function(){
		let fileName = $(this).children().val();
		$("#sumnail").css("display", "inline-block");
		$("#sumnail").empty();
		$("#sumnail").append("<p><책 표지 미리보기></p>");
		$("#sumnail").append("<img src='/Proj_Quill_Pen/images/test/"+fileName+"'>");		
	});
	
	
	// 책 썸네일 클릭시 사라짐
	$("#sumnail").click(function(){
		$("#sumnail").css("display", "none");
	});
	
	
});