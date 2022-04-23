package service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import repository.DTO.BoardBean;
import repository.DTO.CmntBean;
import repository.DTO.DeclBean;
import repository.DTO.LikeBean;
import repository.DTO.SubsBean;
import repository.DTO.WriterBean;

public interface BoardService {
	
	// 글쓰기 선택시
	public BoardBean write (HttpServletRequest req, HttpServletResponse resp) throws Exception;
	//public MemberBean write (String uId, String uName, String writer) throws Exception;
	
	// 글 수정하기 선택시
	public BoardBean update (HttpServletRequest req, HttpServletResponse resp) throws Exception;
	
	// 글 삭제하기 선택시
	public BoardBean delete (HttpServletRequest req, HttpServletResponse resp) throws Exception;

	// 게시글 선택시
	public BoardBean read (HttpServletRequest req, HttpServletResponse resp) throws Exception;
	//public BoardBean read (int bno, String category, int viewCnt) throws Exception;
	
	// 댓글달기
	public CmntBean comment (HttpServletRequest req, HttpServletResponse resp) throws Exception;
	//public CmntBean comment (int bno, String writer, String content, String writeDate) throws Exception;

	// 답글달기
	public CmntBean reply (HttpServletRequest req, HttpServletResponse resp) throws Exception;
	//public CmntBean reply (int bno, int cOrder, String writer, String content, String writeDate) throws Exception;
	
	// 구독하기
	public SubsBean sub (HttpServletRequest req, HttpServletResponse resp) throws Exception;
	//public SubsBean sub (String writer) throws Exception;
	
	// 추천하기
	public LikeBean recom (HttpServletRequest req, HttpServletResponse resp) throws Exception;
	//public LikeBean recom (int bno) throws Exception;
	
	// 작가 프로필 선택시
	public List<WriterBean> writerProf (HttpServletRequest req, HttpServletResponse resp) throws Exception;
	//public BoardBean writerProf (String writer) throws Exception;
	
	// 신고하기
	public DeclBean report (HttpServletRequest req, HttpServletResponse resp) throws Exception;
	//public DeclBean report (String writer, int bno) throws Exception;
	
}
