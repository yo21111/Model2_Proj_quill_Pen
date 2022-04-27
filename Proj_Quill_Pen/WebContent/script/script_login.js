/**
 * 
 */

$(function() {
	// 엔터키를 누르면 로그인 버튼이 눌리도록
	$("section#login input").keyup(function(key) {
		if (key.keyCode == 13) {
			let id = $("div#login_idInput input").val().trim();
			$("div#login_idInput input").val(id);
			let pw = $("div#login_pwInput input").val().trim();
			$("div#login_pwInput input").val(pw);

			if (id == "") {
				$("div#login_error").text("아이디를 입력해주세요.");
			} else if (pw == "") {
				$("div#login_error").text("비밀번호를 입력해주세요.");
			} else {
				$("form#login_Frm").submit();
			}

		}
	});

	// 마우스로 로그인 버튼 클릭
	$("div#login_loginBtn button").click(function() {
		let id = $("div#login_idInput input").val().trim();
		$("div#login_idInput input").val(id);
		let pw = $("div#login_pwInput input").val().trim();
		$("div#login_pwInput input").val(pw);

		if (id == "") {
			$("div#login_error").text("아이디를 입력해주세요.");
		} else if (pw == "") {
			$("div#login_error").text("비밀번호를 입력해주세요.");
		} else {
			$("form#login_Frm").submit();
		}

	});


	// 마우스로 회원가입 버튼 클릭
	$("div#login_registerBtn button").click(function() {
		let url = "/Proj_Quill_Pen/register";
		location.href = url;
	});
	
	// 아이디 기억하기 정보 확인
	$(document).ready(function(){
		let rememId = $("input#rememId").val();
		
		if (rememId == "true") {
			$("div#login_util input").attr("checked", "checked");
		}
		
	});
});