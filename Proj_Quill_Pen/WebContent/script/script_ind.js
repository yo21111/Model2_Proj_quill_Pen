/**
 * 
 */

$(function() {
	// LNB메뉴 클릭시
	$("div#lnbBtn").click(function() {
		let now = $("nav#lnb").css("display");

		if (now == "block") {
			$("nav#lnb").hide();
		} else {
			$("nav#lnb").show();
		}
	});

	$("div#lnb_top_register button").click(function() {
		let url = "/Proj_Quill_Pen/register";
		location.href = url;
	});

	// 엔터키 눌러서 검색하기
	$("input#searchInput").keyup(function(key) {
		if (key.keyCode == 13) {
			let search = $("input#searchInput").val();
			let url = "/Proj_Quill_Pen/bbs?search=" + search;
			location.href = url;
		}
	});

	$("i#search").click(function() {
		let search = $("input#searchInput").val();
		let url = "/Proj_Quill_Pen/bbs?search=" + search;
		location.href = url;
	});
});