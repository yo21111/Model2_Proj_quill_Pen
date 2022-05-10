/**
 * 
 */
$(function() {
	// JSTL 대신 jQuery 사용
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

	// 작가 페이지 이동(작가 영역 클릭시)
	$("div#writer_container").click(function() {
		let writer = $("div#writer_name").text();
		let url = "/Proj_Quill_Pen/myPage?writer=" + writer;
		location.href = url;
	});

	//추천하기 버튼 클릭
	$("button#recomend_Btn").click(function() {
		let isLogin = $("input#isLogin").val();
		let bno = $("input#bno").val();

		if (isLogin == "false") {
			alert("로그인 이후 이용 가능합니다.");
			return;
		} else {
			let send = { key: "writer", value: bno };
			$.ajax({
				type: 'POST',       // 요청 메서드
				url: '/Proj_Quill_Pen/like',  // 요청 URI
				headers: { "content-type": "application/json; charset=utf-8" }, // 요청 헤더
				dataType: 'json', // 전송받을 데이터의 타입
				data: JSON.stringify(send),  // 서버로 전송할 데이터. stringify()로 직렬화 필요.
				success: function(result) {
					alert(result.value);
				},
				error: function() { alert("오류가 발생하였습니다. 다시 시도해주세요.") } // 에러가 발생했을 때, 호출될 함수
			}); // $.ajax()
		}
	});

	// 댓글 작성 상단 버튼 -> 누르면 댓글 위치로 이동
	$("button#comment_Btn").click(function() {
		let offset = $("div#commenticon").offset();
		$('html, body').animate({ scrollTop: offset.top }, 400);
	});

	// 신고하기 버튼 클릭
	$("button#report_Btn").click(function() {
		let isLogin = $("input#isLogin").val();

		if (isLogin == "false") {
			alert("로그인 이후 이용 가능합니다.");
			return;
		} else {
			let bno = $("input#bno").val();
			let url = "/Proj_Quill_Pen/report?bno=" + bno;
			location.href = url;
		}
	});

	//목록 버튼 클릭
	$("button#bbs_Btn").click(function() {
		let url = "/Proj_Quill_Pen/bbs";
		location.href = url;
	});

	//수정 버튼 클릭
	$("button#modify_Btn").click(function() {
		let bno = $("input#bno").val();

		let url = "/Proj_Quill_Pen/boardModify?bno=" + bno;
		location.href = url;
	});

	//삭제 버튼 클릭
	$("button#delete_Btn").click(function() {
		let bno = $("input#bno").val();

		let url = "/Proj_Quill_Pen/boardDelete?bno=" + bno;
		location.href = url;
	});

	//댓글 작성 버튼 클릭
	$("div#commenticon button").click(function() {
		let isLogin = $("input#isLogin").val();

		if (isLogin == "false") {
			alert("로그인 이후 이용 가능합니다.");
			return;
		}
		
		$("div#cmntWrite").show();

	});

	$("button#cmntWriteBtn").click(function() {
		let isLogin = $("input#isLogin").val();
				
		if(isLogin == 'true') {
			$("div#cmntWrite form").submit();
		} else {
			alert("로그인이 필요한 기능입니다.");
			return;
		}

	});


});