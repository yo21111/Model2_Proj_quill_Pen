package service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import repository.DTO.BoardBean;
import repository.DTO.BookBean;
import repository.DTO.DeclBean;
import repository.DTO.NoticeBean;

public interface AdminService {

	// admin에서는 모든 메서드 시작 전 관리자가 맞는지 유효성 검사가 필요함!

	// 공지글 목록
	public List<NoticeBean> noticeList (HttpServletRequest req, HttpServletResponse resp) throws Exception;
	//(int bno)
	
	// 신고글 목록
	public List<DeclBean> reportList (HttpServletRequest req, HttpServletResponse resp) throws Exception;
	// (int dno)
	
	// 공지 쓰기
	public NoticeBean writeNotice (HttpServletRequest req, HttpServletResponse resp) throws Exception;
	//public NoticeBean writeNotice (String mId, String title, String content) throws Exception;
	
	// 신고글 삭제
	public BoardBean reportDel (HttpServletRequest req, HttpServletResponse resp) throws Exception;
	//public BoardBean reportDel (int bno) throws Exception;
	
	// 책 소개 페이지 작성, 수정
	public BookBean bookIntro (HttpServletRequest req, HttpServletResponse resp) throws Exception;
	//public BookBean bookIntro (String fileName, String title, String subTitle, String imageName, String category, String link) throws Exception;
	
	// 책 소개 페이지 삭제
	public BookBean bookIntroDel (HttpServletRequest req, HttpServletResponse resp) throws Exception;
	//public BookBean bookIntroDel (String title) throws Exception;
	
}
