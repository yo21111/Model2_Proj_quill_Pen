package service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import repository.DTO.BoardBean;
import repository.DTO.DeclBean;

public interface BoardService {
	
	// 로그인 여부 확인 + 본인 로그인이 맞는지
	public boolean isLogin(String uId, int bno) throws Exception;
	
	// 작가 이름 찾기
	public String findWriter(String uId) throws Exception;
	
	// 글쓰기 선택시
	public boolean write (BoardBean bBean) throws Exception;
	//public MemberBean write (String uId, String uName, String writer) throws Exception;
	
	// 글 수정하기 선택시
	public boolean update (BoardBean bBean) throws Exception;
	
	// 글 삭제하기 선택시
	public boolean delete (String uId, int bno) throws Exception;

	// 게시글 선택시
	public BoardBean read (HttpServletRequest req, HttpServletResponse resp) throws Exception;
	//public BoardBean read (int bno, String category, int viewCnt) throws Exception;
	
	// 신고하기 등록시
	public boolean report(DeclBean dBean) throws Exception;
}
