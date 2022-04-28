/**
 * 
 */

$(function() {


	$("#idChkBtn").click(function() {
		let chkId = $("#idChkInput").val();

		let regExp = /[^a-z|A-Z|0-9]/g;
		let rExpRes = regExp.test(chkId);

		if (chkId == "") {    // 전체 공백 체크
			alert("아이디를 입력해주세요.");
			return;
		} else if (chkId.length < 3) {    // 글자수 체크
			alert("아이디가 너무 짧습니다.");
			return;
		} else if (rExpRes) {    // 정규표현식 체크
			alert("올바르지 않은 형식입니다.");
			return
		} else {
			let send = { key: "id", value: chkId };
			let recieve = {};
			$.ajax({
				type: 'POST',       // 요청 메서드
				url: '/Proj_Quill_Pen/register/ajax',  // 요청 URI
				headers: { "content-type": "application/json; charset=utf-8" }, // 요청 헤더
				dataType: 'json', // 전송받을 데이터의 타입
				data: JSON.stringify(send),  // 서버로 전송할 데이터. stringify()로 직렬화 필요.
				success: function(result) {
					if (result.value == "true") {
						alert("사용 가능한 아이디입니다.");
						$("input#idChk").val("true");
					} else {
						alert("중복된 아이디입니다.");
						$("input#idChk").val("false");
					}
				},
				error: function() { alert("오류가 발생하였습니다. 다시 시도해주세요.") } // 에러가 발생했을 때, 호출될 함수
			}); // $.ajax()
		}
	});


	$("#writerChkBtn").click(function() {
		let chkWriter = $("#writerChkInput").val();

		let regExp = /[^ㄱ-ㅎ|ㅏ-ㅣ|가-힣]/g;
		let rExpRes = regExp.test(chkWriter);
		let regExp2 = /[^가-힣]/g;
		let rExpRes2 = regExp2.test(chkWriter);

		if (chkWriter == "") {
			alert("작가명을 입력해주세요.");
			return;
		} else if (chkWriter.length < 2) {    // 글자수 체크
			alert("작가명이 너무 짧습니다.");
			return;
		} else if (rExpRes) {    // 정규표현식 체크
			alert("올바르지 않은 형식입니다..");
			return;
		} else if (rExpRes2) {    // 정규표현식 체크
			alert("올바르지 않은 형식입니다..");
			return;
		} else {
			let send = { key: "writer", value: chkWriter };
			let recieve = {};
			$.ajax({
				type: 'POST',       // 요청 메서드
				url: '/Proj_Quill_Pen/register/ajax',  // 요청 URI
				headers: { "content-type": "application/json; charset=utf-8" }, // 요청 헤더
				dataType: 'json', // 전송받을 데이터의 타입
				data: JSON.stringify(send),  // 서버로 전송할 데이터. stringify()로 직렬화 필요.
				success: function(result) {
					if (result.value == "true") {
						alert("사용 가능한 작가명입니다.");
						$("input#writerChk").val("true");
					} else {
						alert("중복된 작가명입니다.");
						$("input#writerChk").val("false");
					}
				},
				error: function() { alert("오류가 발생하였습니다. 다시 시도해주세요.") } // 에러가 발생했을 때, 호출될 함수
			}); // $.ajax()
		}

	});


	//아이디 유효성 검사
	$("#register_id>input").keyup(function() {
		let uId = $(this).val().trim();
		$(this).val(uId);

		let regExp = /[^a-z|A-Z|0-9]/g;
		let rExpRes = regExp.test(uId);

		if (uId == "") {    // 전체 공백 체크

			$("#register_idValid").text("아이디를 입력해주세요");
			$("#register_idValid").css("color", "red");

		} else if (uId.length < 3) {    // 글자수 체크

			$("#register_idValid").text("아이디는 최소 3글자 이상입니다.");
			$("#register_idValid").css("color", "red");

		} else if (rExpRes) {    // 정규표현식 체크

			$("#register_idValid").text("아이디는 영어대/소문자, 숫자 조합만 가능합니다.");
			$("#register_idValid").css("color", "red");

		} else {

			$("#register_idValid").text("아이디는 3~20글자, 영문,숫자만 입력 가능합니다.");
			$("#register_idValid").css("color", "black");

		}

	});



	//작가명 유효성 검사
	$("#register_writer>input").keyup(function() {
		let writer = $(this).val().trim();
		$(this).val(writer);

		let regExp = /[^ㄱ-ㅎ|ㅏ-ㅣ|가-힣]/g;
		let rExpRes = regExp.test(writer);
		let regExp2 = /[^가-힣]/g;
		let rExpRes2 = regExp2.test(writer);

		if (writer == "") {
			$("#register_writerValid").text("작가명을 입력안할 경우 ID가 작가명으로 자동 지정됩니다.");
			$("#register_writerValid").css("color", "red");

		} else if (writer.length < 2) {    // 글자수 체크

			$("#register_writerValid").text("작가명은 최소 2글자 이상입니다.");
			$("#register_writerValid").css("color", "red");

		} else if (rExpRes) {    // 정규표현식 체크

			$("#register_writerValid").text("작가명은 한글만 입력가능합니다.");
			$("#register_writerValid").css("color", "red");

		} else if (rExpRes2) {    // 정규표현식 체크

			$("#register_writerValid").text("작가명을 똑바로 입력해주세요");
			$("#register_writerValid").css("color", "red");

		} else {

			$("#register_writerValid").text("작가명은 10글자 이내의 한글만 입력 가능합니다.");
			$("#register_writerValid").css("color", "black");

		}

	});

	//비밀번호 유효성 검사
	$("#register_pw>input").keyup(function() {
		let uPw = $(this).val().trim();
		$(this).val(uPw);

		let regExp = /[^a-z|A-Z|0-9|~!@#$%^&*()_+|<>?:{}]/g;
		let rExpRes = regExp.test(uPw);

		if (uPw == "") {    // 전체 공백 체크

			$("#register_pwValid").text("비밀번호를 입력해주세요.");
			$("#register_pwValid").css("color", "red");

		} else if (uPw.length < 6) {    // 글자수 체크

			$("#register_pwValid").text("비밀번호는 최소 6글자 이상입니다.");
			$("#register_pwValid").css("color", "red");

		} else if (rExpRes) {    // 정규표현식 체크

			$("#register_pwValid").text("비밀번호는 영어대/소문자, 숫자, 특수문자 조합만 가능합니다.");
			$("#register_pwValid").css("color", "red");

		} else {

			$("#register_pwValid").text("비밀번호는 6~20글자, 영어, 숫자, 특수문자만 입력 가능합니다.");
			$("#register_pwValid").css("color", "black");

		}

	});

	// 비밀번호 확인 유효성 검사
	$("#register_pwCheck>input").keyup(function() {
		let uPw = $("#register_pw>input").val();
		let uPw_Re = $(this).val();

		if (uPw != "" && uPw == uPw_Re) {
			$("#register_pwCheckValid").text("입력한 비밀번호와 일치합니다.");
			$("#register_pwCheckValid").css("color", "black");
		} else {
			$("#register_pwCheckValid").text("입력한 비밀번호와 다릅니다.");
			$("#register_pwCheckValid").css("color", "red");
		}
	});

	//이름 유효성 검사
	$("#register_name>input").keyup(function() {

		let name = $(this).val().trim();
		$(this).val(name);

		let regExp = /[^ㄱ-ㅎ|ㅏ-ㅣ|가-힣]/g;
		let rExpRes = regExp.test(name);
		let regExp2 = /[^가-힣]/g;
		let rExpRes2 = regExp2.test(name);

		if (name == "") {
			$("#register_nameValid").text("이름을 입력해 주세요.");
			$("#register_nameValid").css("color", "red");

		} else if (name.length < 1) {    // 글자수 체크

			$("#register_nameValid").text("이름은 최소 1글자 이상입니다.");
			$("#register_nameValid").css("color", "red");

		} else if (rExpRes) {    // 정규표현식 체크

			$("#register_nameValid").text("이름은 한글만 입력가능합니다.");
			$("#register_nameValid").css("color", "red");

		} else if (rExpRes2) {    // 정규표현식 체크

			$("#register_nameValid").text("이름을 똑바로 입력해주세요");
			$("#register_nameValid").css("color", "red");

		} else {

			$("#register_nameValid").text("이름을 입력해 주세요");
			$("#register_nameValid").css("color", "black");

		}

	});


	//휴대폰 번호 유효성 검사
	$("#register_phone>input").keyup(function() {
		let phone = $(this).val().trim();
		$(this).val(phone);

		let regExp = /[^0-9]/g;
		let rExpRes = regExp.test(phone);

		if (phone == "") {

			$("#register_phoneValid").text("휴대폰 번호를 입력해 주세요.");
			$("#register_phoneValid").css("color", "red");

		} else if (phone.length != 11) {    // 글자수 체크

			$("#register_phoneValid").text("휴대폰 번호를 올바르게 입력해 주세요.");
			$("#register_phoneValid").css("color", "red");

		} else if (rExpRes) {    // 정규표현식 체크

			$("#register_phoneValid").text("휴대폰 번호는 숫자만 입력 가능합니다.");
			$("#register_phoneValid").css("color", "red");

		} else {

			$("#register_phoneValid").text("휴대폰 번호를 입력해 주세요.");
			$("#register_phoneValid").css("color", "black");

		}

	});


	$("#register_phone>button").click(function() {
		let phone = $("#register_phone>input").val().trim();
		$("#register_phone>input").val(phone);

		let regExp = /[^0-9]/g;
		let rExpRes = regExp.test(phone);

		if (phone == "") {

			$("#register_phoneValid").text("휴대폰 번호를 입력해 주세요.");
			$("#register_phoneValid").css("color", "red");
			$("#register_phone>input").focus();

		} else if (phone.length != 11) {    // 글자수 체크

			$("#register_phoneValid").text("휴대폰 번호를 올바르게 입력해 주세요.");
			$("#register_phoneValid").css("color", "red");
			$("#register_phone>input").focus();

		} else if (rExpRes) {    // 정규표현식 체크

			$("#register_phoneValid").text("휴대폰 번호는 숫자만 입력 가능합니다.");
			$("#register_phoneValid").css("color", "red");
			$("#register_phone>input").focus();

		} else {

			$("#register_phoneValid").text("인증이 완료되었습니다.");
			$("#register_phoneValid").css("color", "green");
		}
	});









	//생년월일 유효성 검사
	$("#register_birth>input").keyup(function() {
		let birth = $(this).val().trim();
		$(this).val(birth);

		let regExp = /[^0-9]/g;
		let rExpRes = regExp.test(birth);

		if (birth.length != 8) {    // 글자수 체크

			$("#register_birthValid").text("생년월일을 올바르게 입력해 주세요.");
			$("#register_birthValid").css("color", "red");

		} else if (rExpRes) {    // 정규표현식 체크

			$("#register_birthValid").text("생년월일은 숫자만 입력 가능합니다.");
			$("#register_birthValid").css("color", "red");

		} else {

			$("#register_birthValid").text("생년월일을 입력해 주세요.");
			$("#register_birthValid").css("color", "black");

		}

	});





	// 선택된 Email 도메인 자동입력  
	$("select#emailDomain").change(function() {
		let emailDomain = $(this).val().trim();
		$("input#uEmail_02").val(emailDomain);
		if (emailDomain == "") {
			$("input#uEmail_02").focus();
		} else {
			$("input#uEmail_01").focus();
		}
	});


	/* 회원가입 버튼 전송 실행 */
	$("#registerSubBtn").click(function() {
		let uId = $("#uId").val();
		$("#uId").val(uId);
		let uPw = $("#uPw").val();
		$("#uPw").val(uPw);
		let uPw_Re = $("#uPw_Re").val();
		let uName = $("#uName").val();
		$("#uName").val(uName);
		let uEmail_01 = $("#uEmail_01").val();
		let uEmail_02 = $("#uEmail_02").val();
		$("#uEmail").val(uEmail_01 + "@" + uEmail_02);
		let uBirthday = $("#uBirthday").val();

		if (uId == "") {
			alert("아이디를 입력해주세요.");
			$("#uId").focus();
			return;
		} else if (uPw == "") {
			alert("비밀번호를 입력해주세요.");
			$("#uPw").focus();
			return;
		} else if (uPw_Re == "" || uPw != uPw_Re) {
			alert("비밀번호 일치여부를 확인해주세요.");
			$("#uPw_Re").focus();
			return;
		} else if (uName == "") {
			alert("이름을 입력해주세요.");
			$("#uName").focus();
			return;
		} else if (uEmail_01 == "") {
			alert("이메일 주소를 입력해주세요.");
			$("#uEmail_01").focus();
			return;
		} else if (uEmail_02 == "") {
			alert("이메일 주소를 입력해주세요.");
			$("#uEmail_02").focus();
			return;
		} else if (uBirthday != "" && !isNaN(Number(uBirthday))) {
			// 생년월일 숫자유효성 검사
			alert("생년월일은 숫자만 입력할 수 있습니다.");
			$("#uBirthday").val("").focus();
			return;
		} else {
			if ($("input#idChk").val() != "true") {
				alert("아이디 중복 여부를 확인하세요.");
				return;
			} else if ($("input#writerChk").val() != "true") {
				alert("작가명 중복 여부를 확인하세요.");
				return;
			}


			let chkSbmTF = confirm("회원가입하시겠습니까?");
			if (chkSbmTF) {
				$("#register_Frm").attr("action", "/Proj_Quill_Pen/register");
				$("#register_Frm").submit();
			}
		}

	});






});