package service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import repository.DTO.BoardBean;
import repository.DTO.MemberBean;

public interface BbsService {

	// 전체글 목록 선택시
	public List<BoardBean> articleList (HttpServletRequest req, HttpServletResponse resp) throws Exception;
	// (int bno)
	
	// 카테고리 선택시
	public List<BoardBean> category (HttpServletRequest req, HttpServletResponse resp) throws Exception;
	//public BoardBean category (String category) throws Exception;
	
	// 글쓰기 선택시
	public MemberBean write (HttpServletRequest req, HttpServletResponse resp) throws Exception;
	//public MemberBean write (String uId, String uName, String writer) throws Exception;
	
	// 게시글 선택시
	public BoardBean read (HttpServletRequest req, HttpServletResponse resp) throws Exception;
	//public BoardBean read (int bno, String category, int viewCnt) throws Exception;
}
