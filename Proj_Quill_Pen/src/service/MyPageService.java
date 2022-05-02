package service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import repository.DTO.BoardBean;
import repository.DTO.CmntBean;
import repository.DTO.MemberBean;
import repository.DTO.SubsBean;
import repository.DTO.WriterBean;

public interface MyPageService {
	
	public boolean isLogin(String uId) throws Exception;
	
	public boolean writerCheck(String writer) throws Exception;
	
	// 회원정보 수정
	public boolean modUser (String uName, String uEmail, String uPhone, String uBirth, String writer) throws Exception;
	//public MemberBean modUser (String uId) throws Exception;
	
	// 프로필 편집
	public MemberBean userInfo (String uId) throws Exception;
	//public MemberBean modProf (String writer) throws Exception;
	
	// 작가의 게시물
	public List<BoardBean> myArticle (String writer) throws Exception;
	//public MemberBean myArticle (String uId) throws Exception;
	
	// 구독한 작가 목록
	public List<WriterBean> subWriter (HttpServletRequest req, HttpServletResponse resp) throws Exception;
	//public SubsBean subWriter (String uId, String writer) throws Exception;
	
	// 추천한 글 목록 
	public List<BoardBean> likeArticle (HttpServletRequest req, HttpServletResponse resp) throws Exception;
	//public LikeBean likeArticle (String uId, int bo) throws Exception;
	
	//회원 탈퇴하기
	public boolean withdraw (String uId) throws Exception;
	
	//** 추가사항 **//
	
	// 아이디의 작가정보 찾기
	public WriterBean findWriter(String uId) throws Exception;
	
	// 작가명으로 아이디 찾기
	public String findId (String writer) throws Exception;
	
	// 구독자수 찾기
	public int getSubCnt(String Writer) throws Exception;
	
	// 관심 글 수 찾기
	public int getLikeCnt(String uId) throws Exception;
	
	// 구독하기
	public boolean insertSubWriter(String uId, String writer) throws Exception;
	
}
