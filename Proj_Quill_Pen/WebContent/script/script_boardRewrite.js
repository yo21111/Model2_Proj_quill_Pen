/**
 * 
 */

$(function() {

	$(document).ready(function() {
		let fileName = $("input#fileImg").val();

		let url = "url('/Proj_Quill_Pen/images/test/" + fileName + "')";
		$("div#board_header").css("background-image", url);


		let myPost = $("input#myPost").val();

		if (myPost == "false") {
			$("button#modify_Btn").hide();
			$("button#delete_Btn").hide();
		} else {
			$("button#modify_Btn").show();
			$("button#delete_Btn").show();
		}
	});

	$("button#insert_Btn").click(function() {
		let title = $("input#title").val();
		if (title == "") {
			alert("게시글의 제목을 입력해주세요.");
			return;
		}

		let file = $("input#fileInput").val();
		//lastIndexOf() : 오른쪽부터 세어서 "."의 인덱스 번호 찾기
		let dotIdx = file.lastIndexOf(".");

		// ext : extension, 확장자
		let ext = file.substring(dotIdx + 1);
		// .의 위치 다음부터 마지막 인덱스까지 문자열 자르기

		ext = ext.toLowerCase(); //소문자로 변환

		const forbidExt = ["exe", "cab", "dll", "js", "css", "html", "jsp"]; //이외 원하는 확장자 계속 추가
		let chk = false;
		//for-Of : 변수가 인덱스 번호의 값을 반환
		for (let x of forbidExt) { //for-in 구문 : 변수가 인덱스 번호 반환
			if (x == ext) {
				chk = true;
			}
		}

		if (chk) {
			alert("확장자가 " + ext + "인 파일은 업로드 하실 수 없습니다.");
			return;
		}

		let nowPage = $("input#nowPage").val();

		$("form#rewriteFrm").attr("action", "/Proj_Quill_Pen/boardInsert");

		$("form#rewriteFrm").submit();
	});

	$("button#modify_Btn").click(function() {
		let title = $("input#title").val();
		if (title == "") {
			alert("게시글의 제목을 입력해주세요.");
			return;
		}

		let file = $("input#fileInput").val();
		//lastIndexOf() : 오른쪽부터 세어서 "."의 인덱스 번호 찾기
		let dotIdx = file.lastIndexOf(".");

		// ext : extension, 확장자
		let ext = file.substring(dotIdx + 1);
		// .의 위치 다음부터 마지막 인덱스까지 문자열 자르기

		ext = ext.toLowerCase(); //소문자로 변환

		const forbidExt = ["exe", "cab", "dll", "js", "css", "html", "jsp"]; //이외 원하는 확장자 계속 추가
		let chk = false;
		//for-Of : 변수가 인덱스 번호의 값을 반환
		for (let x of forbidExt) { //for-in 구문 : 변수가 인덱스 번호 반환
			if (x == ext) {
				chk = true;
			}
		}

		if (chk) {
			alert("확장자가 " + ext + "인 파일은 업로드 하실 수 없습니다.");
			return;
		}

		let nowPage = $("input#nowPage").val();

		$("form#rewriteFrm").attr("action", "/Proj_Quill_Pen/boardModify");

		$("form#rewriteFrm").submit();
	});

	$("button#reWrite_Btn").click(function() {
		location.reload();
	});
});