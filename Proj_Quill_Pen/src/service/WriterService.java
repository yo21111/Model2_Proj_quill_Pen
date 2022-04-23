package service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import repository.DTO.BoardBean;
import repository.DTO.MemberBean;
import repository.DTO.WriterBean;

public interface WriterService {
	
	
	// 작가가 쓴 게시물
	public List<BoardBean> myArticle (HttpServletRequest req, HttpServletResponse resp) throws Exception;
	//public MemberBean myArticle (String uId) throws Exception;
	
	// 작가가 구독한 작가 목록
	public List<WriterBean> subWriter (HttpServletRequest req, HttpServletResponse resp) throws Exception;
	//public SubsBean subWriter (String uId, String writer) throws Exception;
	
	// 작가가 추천한 글 목록 
	public List<BoardBean> likeArticle (HttpServletRequest req, HttpServletResponse resp) throws Exception;
	//public LikeBean likeArticle (String uId, int bo) throws Exception;
	
	
	
	// 구독한 작가 선택시 or 작가 프로필 선택시 -> 해당 블록의 writer의 value가지고 페이지이동
	public MemberBean writerSel (HttpServletRequest req, HttpServletResponse resp);
	// (writer)
	
	// 구독 or 선택한 작가가 쓴 글 목록 -> 해당 블록의 bno value를 가지고 페이지 이동
	public List<BoardBean> BoawriterArticleList(HttpServletRequest req, HttpServletResponse resp) throws Exception;
	// (writer)
	
	
}
