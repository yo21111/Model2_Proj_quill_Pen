package service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
	public MemberBean myArticle (HttpServletRequest req, HttpServletResponse resp) throws Exception;
	//public MemberBean myArticle (String uId) throws Exception;
	
	// 구독한 작가 목록
	public SubsBean subWriter (HttpServletRequest req, HttpServletResponse resp) throws Exception;
	//public SubsBean subWriter (String uId, String writer) throws Exception;
	
	// 추천한 글 목록 
	public LikeBean likeArticle (HttpServletRequest req, HttpServletResponse resp) throws Exception;
	//public LikeBean likeArticle (String uId, int bo) throws Exception;
	
}
