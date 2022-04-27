/**
 * 
 */

$(function() {
	// 아이디 찾기 또는 비밀번호 찾기로 이동 버튼 텍스트
	$(document).ready(function() {
		let find = $("input#find").val();
		if (find == null || find == "id" || find == "findId") {
			$("div#findinfo_findinfoBtn button span").text("비밀번호 찾기로 이동");
		} else if (find == "pw" || find == "pwCheck") {
			$("div#findinfo_findinfoBtn button span").text("아이디 찾기로 이동");
		}
	});

	// 아이디 찾기 또는 비밀번호 찾기로 이동 버튼 클릭 시
	$("div#findinfo_findinfoBtn button").click(function() {
		let find = $("input#find").val();
		if (find == null || find == "id" || find == "findId") {
			let url = "/Proj_Quill_Pen/login?find=pw";
			location.href = url;
		} else if (find == "pw" || find == "pwCheck") {
			let url = "/Proj_Quill_Pen/login?find=id";
			location.href = url;
		}
	});


	// 엔터키를 누르면 로그인 버튼이 눌리도록
	$("div.findinfo_input input").keyup(function(key) {
		if (key.keyCode == 13) {
			let first = $("div.findinfo_input").eq(0).children().val().trim();
			$("div.findinfo_input").eq(0).val(first);
			let second = $("div.findinfo_input").eq(1).children().val().trim();
			$("div.findinfo_input").eq(1).val(second);

			if (first == "") {
				$("div#findinfo_error").text("위쪽 입력칸에 정보를 입력해주세요.");
				return;
			}
			if (second == "") {
				$("div#findinfo_error").text("아래쪽 입력칸에 정보를 입력해주세요.");
				return;
			}
			if ($("input#find").val() == "pwCheck") {
				let update = $("input#updatePw").val();
				let updateChk = $("input#updatePwChk").val();
				if (update != updateChk) {
					$("div#findinfo_error").css("color", "red");
					$("div#findinfo_error").text("비밀번호와 비밀번호 확인 입력 내용이 다릅니다.");
					return;
				} else if (update.length < 4) {
					$("div#findinfo_error").css("color", "red");
					$("div#findinfo_error").text("비밀번호 길이가 너무 짧습니다.");
					return;
				}
			}
			$("form#findinfo_Btn").submit();
		}
	});

	// 마우스로 찾기 버튼 클릭
	$("div#findinfo_findBtn button").click(function() {
		let first = $("div.findinfo_input").eq(0).children().val().trim();
		$("div.findinfo_input").eq(0).val(first);
		let second = $("div.findinfo_input").eq(1).children().val().trim();
		$("div.findinfo_input").eq(1).val(second);

		if (first == "") {
			$("div#findinfo_error").css("color", "red");
			$("div#findinfo_error").text("위쪽 입력칸에 정보를 입력해주세요.");
			return;
		}
		if (second == "") {
			$("div#findinfo_error").css("color", "red");
			$("div#findinfo_error").text("아래쪽 입력칸에 정보를 입력해주세요.");
			return;
		}
		if ($("input#find").val() == "pwCheck") {
			let update = $("input#updatePw").val();
			let updateChk = $("input#updatePwChk").val();
			if (update != updateChk) {
				$("div#findinfo_error").css("color", "red");
				$("div#findinfo_error").text("비밀번호와 비밀번호 확인 입력 내용이 다릅니다.");
				return;
			} else if (update.length < 4) {
				$("div#findinfo_error").css("color", "red");
				$("div#findinfo_error").text("비밀번호 길이가 너무 짧습니다.");
				return;
			}
		}
		$("form#findinfo_Btn").submit();

	});


	// 로그인 페이지로 이동 버튼
	$("div#findinfo_loginBtn button").click(function() {
		let url = "/Proj_Quill_Pen/login";
		location.href = url;
	});


	// 비밀번호 변경 관련
	$("input#updatePw").keyup(function() {
		let pw = $("input#updatePw").val();
		if (pw.length < 5) {
			$("div#findinfo_error").css("color", "red");
			$("div#findinfo_error").text("입력하신 비밀번호가 너무 짧습니다.");
		}
	});

	$("input#updatePwChk").keyup(function() {
		let pw = $("input#updatePw").val();
		let pwChk = $("input#updatePwChk").val();
		if (pw != pwChk) {
			$("div#findinfo_error").css("color", "red");
			$("div#findinfo_error").text("입력하신 비밀번호와 일치하지 않습니다.");
		} else if (pw == pwChk) {
			$("div#findinfo_error").css("color", "green");
			$("div#findinfo_error").text("입력하신 비밀번호와 일치합니다.");
			return;
		} else if (pw != pwChk) {
			$("div#findinfo_error").css("color", "red");
			$("div#findinfo_error").text("비밀번호와 비밀번호 확인 입력 내용이 다릅니다.");
			return;
		} else if (pw.length < 4) {
			$("div#findinfo_error").css("color", "red");
			$("div#findinfo_error").text("비밀번호 길이가 너무 짧습니다.");
			return;
		}
	});
});