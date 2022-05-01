/**
 * 
 */

$(function() {
	//공지사항 롤링
	$(document).ready(function() {
		let height = $("div#notice_container").height();
		let num = $("div.notice_Content").length;

		let max = height * num;
		let move = 0;
		function noticeRolling() {
			move += height;
			$("div.notice_Content").animate({ "top": -move }, 600, function() {
				if (move >= max) {
					$(this).css("top", 0);
					move = 0;
				}
			})
		}
		noticeRollingOff = setInterval(noticeRolling, 3000);

		$("div.notice_Content").append($("div.notice_Content a").first().clone());


		// 네비게이션 버튼 클릭 시
		$("div#imgSlide_nav #left").click(function() {
			let pos = $("div#imgSlide_img").attr("data-positionX");
			if (pos < 0) {
				let move = Number(pos) + 300;
				$("div#imgSlide_img").attr("data-positionX", move);
				$("div#imgSlide_img").css("transform", "translateX(" + move + "px)");
			}
		});
		$("div#imgSlide_nav #right").click(function() {
			let pos = $("div#imgSlide_img").attr("data-positionX");
			let len = $("div.imgSlide_img").length + 5;
			if (-1 * pos < Number(len) * 300) {
				let move = Number(pos) - 300;
				$("div#imgSlide_img").attr("data-positionX", move);
				$("div#imgSlide_img").css("transform", "translateX(" + move + "px)");
			}
		});
	});
	
	// 공지사항 선택시
	$(".notice_Content").click(function() {
		let bno = $(this).children().eq(0).val();
		let url = "/Proj_Quill_Pen/NoticeContent?bno=" + bno;
		location.href = url;
	});


	$("div.writer_Content").click(function() {
		let writer = $(this).children().children().attr("alt");
		let url = "/Proj_Quill_Pen/myPage?writer=" + writer;
		location.href = url;
	});

});