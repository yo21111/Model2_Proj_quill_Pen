/**
 * 체크박스 선택시에만 회원탈퇴 버튼 기능
 */

$(document).ready(function() {
	$("#withdrawAgreeChk").change(function() {
		if ($("#withdrawAgreeChk").is(":checked")) {
			$("#withdrawAgreeChk").val(1);

		} else {
			$("#withdrawAgreeChk").val(0);
		}
	});
	
	// 탈퇴하기 버튼 클릭시
	$("#withdraw_btn").click(function() {
	let WBtn = $("#withdrawAgreeChk").val();
	if (WBtn == 0) {
		alert("회원 탈퇴 동의를 체크해주세요.");
		return;
	} else {
		alert("회원 탈퇴가 완료되었습니다!");
		window.location = './updateWithdraw';
	}
	});
});




