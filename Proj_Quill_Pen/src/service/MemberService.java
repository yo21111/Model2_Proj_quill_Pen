package service;

import repository.DTO.MemberBean;

public interface MemberService {

	// 아이디 중복확인 
	public boolean idChk (String uId) throws Exception;
	
	// 작가명 중복확인
	public boolean writerChk (String writer) throws Exception;
	
	// 로그인 -> 로그인 정보가 맞는 지 확인 후 session에 uId_Session으로 값 넣기
	public boolean loginChk(String uId, String uPw) throws Exception;

	// 회원가입 정보 유효성 검사 -> DAO 사용 X 서비스 선에서 작업 후 boolean 반환
	public boolean validator(MemberBean bean) throws Exception;
	
	// 회원가입 완료
	public boolean newMem (MemberBean bean) throws Exception;
	
	// 작가 테이블 기본 정보 입력
	public boolean defaultWriter (MemberBean bean) throws Exception;
	
	// 아이디 찾기 -> 이름과 휴대폰번호를 받아서 해당 아이디 값 돌려주기
	public String findId(String uName, String uPhone) throws Exception;
	
	// 비밀번호 찾기 -> 아이디, 휴대폰번호 받아서 새로운 비밀번호로 변경하도록 하기
	public boolean findPw(String uId, String uPhone) throws Exception;

	// 비밀번호 바꾸기
	public boolean changePw(String uId, String uPw) throws Exception;
}
