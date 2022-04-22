package service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import repository.DTO.BoardBean;
import repository.DTO.CmntBean;
import repository.DTO.LikeBean;
import repository.DTO.MemberBean;
import repository.DTO.SubsBean;

public interface MyPageService {
	
	// 회원정보 수정
	public MemberBean modUser (HttpServletRequest req, HttpServletResponse resp) throws Exception;
	//public MemberBean modUser (String uId) throws Exception;
	
	// 프로필 편집
	public MemberBean modProf (HttpServletRequest req, HttpServletResponse resp) throws Exception;
	//public MemberBean modProf (String writer) throws Exception;
	
	// 내가 쓴 게시물
	public List<MemberBean> myArticle (HttpServletRequest req, HttpServletResponse resp) throws Exception;
	//public MemberBean myArticle (String uId) throws Exception;
	
	// 구독한 작가 목록
	public List<SubsBean> subWriter (HttpServletRequest req, HttpServletResponse resp) throws Exception;
	//public SubsBean subWriter (String uId, String writer) throws Exception;
	
	// 추천한 글 목록 
	public List<LikeBean> likeArticle (HttpServletRequest req, HttpServletResponse resp) throws Exception;
	//public LikeBean likeArticle (String uId, int bo) throws Exception;
	
	
	//** 추가사항 **//
	
	// 내가 쓴 댓글 목록
	public List<CmntBean> myComment(HttpServletRequest req, HttpServletResponse resp) throws Exception;
	// (bno, content, writeDate)
	
	// 구독한 작가 선택시 or 작가 프로필 선택시
	public MemberBean writerSel (HttpServletRequest req, HttpServletResponse resp);
	// (writer)
	
	// 구독 or 선택한 작가가 쓴 글 목록
	public List<BoardBean> BoawriterArticleList(HttpServletRequest req, HttpServletResponse resp) throws Exception;
	// (writer)
	
	
	
}
