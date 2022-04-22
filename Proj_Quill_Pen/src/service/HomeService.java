package service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import repository.DTO.BoardBean;
import repository.DTO.MemberBean;
import repository.DTO.NoticeBean;

public interface HomeService {

	// 공지사항 클릭시
	public List<NoticeBean> read (HttpServletRequest req, HttpServletResponse resp) throws Exception;
	//public NoticeBean read (int bno) throws Exception;
	
	// 카테고리 선택시
	public List<BoardBean> category (HttpServletRequest req, HttpServletResponse resp) throws Exception;
	//public BoardBean category (String category) throws Exception;
	
	// 검색어 입력시
	public List<BoardBean> search (HttpServletRequest req, HttpServletResponse resp) throws Exception;
	//public BoardBean search (String title, String content, String writer, String category) throws Exception;
	
	// 글쓰기 선택시
	public MemberBean write (HttpServletRequest req, HttpServletResponse resp) throws Exception;
	//public MemberBean write (String uId, String uName, String writer) throws Exception;
	
	// 내 블로그 선택시
	public MemberBean myPage (HttpServletRequest req, HttpServletResponse resp) throws Exception;
	//public MemberBean myPage (String uId) throws Exception;
	
	// 내 글 목록 선택시
	public List<MemberBean> myArticle (HttpServletRequest req, HttpServletResponse resp) throws Exception;
	//public MemberBean myArticle (String uId) throws Exception;
	
	// 피드 선택시
	public List<BoardBean> writer (HttpServletRequest req, HttpServletResponse resp) throws Exception;
	//public BoardBean writer (String writer) throws Exception;
	
}
