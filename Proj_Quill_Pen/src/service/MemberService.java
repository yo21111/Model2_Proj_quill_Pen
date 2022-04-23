package service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import repository.DTO.MemberBean;

public interface MemberService {

	// 아이디 중복확인 -> 반환 값이 boolean이면 되지 않을까
	public MemberBean idChk (HttpServletRequest req, HttpServletResponse resp) throws Exception;
	//public MemberBean idChk (String uId) throws Exception;
	
	// 작가명 중복확인 -> 반환 값이 boolean이면 되지 않을까
	public MemberBean writerChk (HttpServletRequest req, HttpServletResponse resp) throws Exception;
	//public MemberBean writerChk (String writer) throws Exception;
	
	// 회원가입 정보 유효성 검사 -> DAO 사용 X 서비스 선에서 작업 후 boolean 반환
	
	// 로그인 -> 로그인 정보가 맞는 지 확인 후 session에 uId_Session으로 값 넣기
	
	// 로그아웃 -> session.invalid();
	
	// 회원가입 완료 -> 왜 MemberBean을 다줘야할까
	public MemberBean newMem (HttpServletRequest req, HttpServletResponse resp) throws Exception;
	//public MemberBean newMem (String uId, String uPw, String uName, String uEmail, String uBirth, String uPhone) throws Exception;
	
	// 아이디 찾기 -> 이름과 휴대폰번호를 받아서 해당 아이디 값 돌려주기
	
	// 비밀번호 찾기 -> 아이디, 휴대폰번호 받아서 새로운 비밀번호로 변경하도록 하기
	
}
