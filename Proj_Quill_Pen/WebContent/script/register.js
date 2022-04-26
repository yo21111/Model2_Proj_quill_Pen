/**
 * 
 */

$(function(){

	/*	
		$("#idChkBtn").click(function(){
			
			let chkId = $("#idChkInput").val();
			
			let root = "/Proj_Quill_Pen/register?check=" + chkId;
			
			let width = screen.width;
			let popWidth = 400;
			let leftPos = (width - popWidth) / 2;
	
			let height = screen.height;
			let popHeight = 200;
			let topPos = (height - popHeight) / 2;
			
			let prop = "width=" + popWidth + ", height=" + popHeight + ", left=" + leftPos + ", top=" + topPos;
			
			window.open(root,prop);
					
		});
		
		
		$("#writerChkBtn").click(function(){
			
			let chkWriter = $("#writerChkInput").val();
			
			let root = "/Proj_Quill_Pen/register?check=" + chkWriter;
			
			let width = screen.width;
			let popWidth = 400;
			let leftPos = (width - popWidth) / 2;
	
			let height = screen.height;
			let popHeight = 200;
			let topPos = (height - popHeight) / 2;
			
			let prop = "width=" + popWidth + ", height=" + popHeight + ", left=" + leftPos + ", top=" + topPos;
			
			window.open(root,prop);
					
		});
	*/	

		//아이디 유효성 검사
		$("#register_id>input").keyup(function(){
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
		$("#register_writer>input").keyup(function(){

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
		$("#register_pw>input").keyup(function(){
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
		$("#register_name>input").keyup(function(){

			let name = $(this).val().trim();
			$(this).val(name);
			
			let regExp = /[^ㄱ-ㅎ|ㅏ-ㅣ|가-힣]/g;
			let rExpRes = regExp.test(name);
			let regExp2 = /[^가-힣]/g;
			let rExpRes2 = regExp2.test(name);
		
			if (writer == "") {
			$("#register_writerValid").text("이름을 입력해 주세요.");
			$("#register_writerValid").css("color", "red");
				
			} else if (writer.length < 1) {    // 글자수 체크
		
			$("#register_nameValid").text("이름은 최소 1글자 이상입니다.");
			$("#register_nameValid").css("color", "red");
			
			} else if (rExpRes) {    // 정규표현식 체크
		
			$("#register_nameValid").text("이름은 한글만 입력가능합니다.");
			$("#register_nameValid").css("color", "red");
			
			} else if (rExpRes2) {    // 정규표현식 체크
		
			$("#register_nameValid").text("이름을 똑바로 입력해주세요");
			$("#register_nameValid").css("color", "red");
			
			} else {
				
			$("#register_nameValid").text("");
				
			}
		
		});


			//휴대폰 번호 유효성 검사
		$("#register_phone>input").keyup(function(){
			let phone = $(this).val().trim();
			$(this).val(phone);
			
			let regExp = /[^0-9]/g;
			let rExpRes = regExp.test(phone);
			
			if(phone == "") {
				
			$("#register_phoneValid").text("휴대폰 번호를 입력해 주세요.");					
				
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


			//휴대폰 번호 유효성 검사
		$("#register_birth>input").keyup(function(){
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
		$("select#emailDomain").change(function(){
			let emailDomain = $(this).val().trim();
			$("input#uEmail_02").val(emailDomain);
			if (emailDomain == "") {
				$("input#uEmail_02").focus();
			} else {
				$("input#uEmail_01").focus();
			}
		});
		
	
			/* 회원가입 버튼 전송 실행 */	
		$("#registerSubBtn").click(function(){		
			fnJoinSbm();		
		});
		
		function fnJoinSbm() {
			
			let uId = $("#uId").val().trim();
			$("#uId").val(uId);
			let uPw = $("#uPw").val().trim();		
			$("#uPw").val(uPw);		
			let uPw_Re = $("#uPw_Re").val().trim();	
			let uName = $("#uName").val().trim();
			$("#uName").val(uName);
			let uEmail_01 = $("#uEmail_01").val().trim();
			let uEmail_02 = $("#uEmail_02").val().trim();
			$("#uEmail").val(uEmail_01+"@"+uEmail_02);
			let uBirthday = $("#uBirthday").val().trim();
			
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
			} else if (uBirthday != "" && isNaN(uBirthday)) {
				// 생년월일 숫자유효성 검사
				alert("생년월일은 숫자만 입력할 수 있습니다.");
				$("#uBirthday").val("").focus();
				return;
			} else {
				let chkSbmTF = confirm("회원가입하시겠습니까?");
				if (chkSbmTF) {
					$("#register_Frm").attr("action", "/register");
					$("#register_Frm").submit();
				}
			}
			 
		}
	    
	
	
	
	
});