package service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import repository.DTO.BoardBean;
import repository.DTO.CmntBean;
import repository.DTO.DeclBean;
import repository.DTO.WriterBean;

public interface BoardService {
	
	// 로그인 여부 확인 + 본인 로그인이 맞는지
	public boolean isLogin(String uId, int bno) throws Exception;
	
	// 작가 이름 찾기
	public String findWriter(String uId) throws Exception;
	
	// 글쓰기 선택시
	public boolean write (BoardBean bBean) throws Exception;
	//public MemberBean write (String uId, String uName, String writer) throws Exception;
	
	// 작가정보 가져오기
	public WriterBean getWriter(String writer) throws Exception;
	
	// 글 수정하기 선택시
	public boolean update (BoardBean bBean) throws Exception;
	
	// 글 삭제하기 선택시(관리자)
	public boolean adminDelete (String uId, int bno) throws Exception;
	
	// 글 삭제하기 선택시
	public boolean delete (String uId, int bno) throws Exception;

	// 게시글 선택시
	public BoardBean read (HttpServletRequest req, HttpServletResponse resp) throws Exception;
	//public BoardBean read (int bno, String category, int viewCnt) throws Exception;

	// 조회수 증가
	public void incrViewCnt (int bno) throws Exception;
	
	// 해당 게시글 댓글 갯수 가져오기
	public int getCmntCnt(int bno) throws Exception;
	
	// 신고하기 등록시
	public boolean report(DeclBean dBean) throws Exception;
	
	//  댓글 목록 가져오기
	public List<CmntBean> selectCmntList(int bno) throws Exception;
	
	// 추천 여부 확인하기
	public boolean isLike(String uId, int bno) throws Exception;
	
	// 추천하기
	public void like(String uId, int bno) throws Exception;
	
	// 추천 취소하기
	public void unLike(String uId, int bno) throws Exception;

	// 댓글 작성하기
	public boolean writeCmnt(int bno, String uId, String content) throws Exception;

	// 댓글 수정하기
	public boolean updateCmnt(int bno, int cno, String content) throws Exception;

	// 댓글 수정하기
	public boolean deleteCmnt(int cno) throws Exception;
	
	
}
