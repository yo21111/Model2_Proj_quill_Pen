/**
 * 
 */

$(function() {
	//이미지 클릭 시 하단 부 세부 내용 출력
	$("div.book_img img").click(function() {
		let title = $(this).parent().next().text();
		let no = $(this).parent().next().next().next().children().eq(0).val();
		let fileName = $(this).parent().next().next().next().children().eq(1).val();
		let subTitle = $(this).parent().next().next().next().children().eq(2).val();
		let imgName = $(this).parent().next().next().next().children().eq(3).val();

		$("div#book_info_title").text(title);

		let imgSrc = "/Proj_Quill_Pen/images/test/" + imgName;
		$("div#content_img img").prop("src", imgSrc);

		$("div#content_subTitle").text(subTitle);

		let fileSrc = "/Proj_Quill_Pen/images/test/" + fileName;
		$("div#book_info_content_img img").prop("src", fileSrc);

		$("input#book_info_no").val(no);

		let link = $(this).parent().next().next().next().children().eq(4).val();
		$("div#book_info_content_btn button").next().val(link);
		
		$("section#book_info").show();
		$("div#content_img").css("margin", "0 auto");
	});

	// 구매하기 버튼 클릭시 책 판매 사이트로 이동
	$("div#book_info_content_btn button").click(function() {
		let link = $(this).next().val();
		location.href = link;
	});

	// 네비게이션 버튼 클릭 시
	$("div#book_slide_nav #left").click(function() {
		let pos = $("div#book_slide_container").attr("data-positionX");
		if (pos < 0) {
			let move = Number(pos) + 300;
			$("div#book_slide_container").attr("data-positionX", move);
			$("div#book_slide_container").css("transform", "translateX(" + move + "px)");
		}
	});
	$("div#book_slide_nav #right").click(function() {
		let pos = $("div#book_slide_container").attr("data-positionX");
		let len = $("div.book_book_container").length + 8;
		if (-1*pos < Number(len) * 150) {
			let move = Number(pos) - 300;
			$("div#book_slide_container").attr("data-positionX", move);
			$("div#book_slide_container").css("transform", "translateX(" + move + "px)");
		}
	});
});