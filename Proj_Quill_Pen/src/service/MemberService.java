package service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import repository.DTO.MemberBean;

public interface MemberService {

	// 아이디 중복확인
	public MemberBean idChk (HttpServletRequest req, HttpServletResponse resp) throws Exception;
	//public MemberBean idChk (String uId) throws Exception;
	
	// 작가명 중복확인
	public MemberBean writerChk (HttpServletRequest req, HttpServletResponse resp) throws Exception;
	//public MemberBean writerChk (String writer) throws Exception;
	
	// 회원가입 완료
	public MemberBean newMem (HttpServletRequest req, HttpServletResponse resp) throws Exception;
	//public MemberBean newMem (String uId, String uPw, String uName, String uEmail, String uBirth, String uPhone) throws Exception;
	
}
