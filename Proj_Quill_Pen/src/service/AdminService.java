package service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import repository.DTO.BookBean;
import repository.DTO.DeclBean;
import repository.DTO.NoticeBean;

public interface AdminService {

	// admin에서는 모든 메서드 시작 전 관리자가 맞는지 유효성 검사가 필요함!
	public boolean isAdmin(String uId) throws Exception;
	
	// 공지글 목록
	public List<NoticeBean> noticeList (HttpServletRequest req, HttpServletResponse resp) throws Exception;
	//(int bno)
	
	// 신고글 목록
	public List<DeclBean> reportList (HttpServletRequest req, HttpServletResponse resp) throws Exception;
	// (int dno)
	
	// 공지 글 가져오기
	public NoticeBean getNotice (HttpServletRequest req, HttpServletResponse resp) throws Exception;
	//public NoticeBean writeNotice (String mId, String title, String content) throws Exception;
	
	// 신고글 가져오기
	public DeclBean getReport (HttpServletRequest req, HttpServletResponse resp) throws Exception;
	//public BoardBean reportDel (int bno) throws Exception;
	
	// 책 소개 목록 가져오기
	public List<BookBean> bookList (HttpServletRequest req, HttpServletResponse resp) throws Exception;
	//public BookBean bookIntro (String fileName, String title, String subTitle, String imageName, String category, String link) throws Exception;
	
	// 책 페이지 가져오기
	public BookBean getBook (HttpServletRequest req, HttpServletResponse resp) throws Exception;
	//public BookBean bookIntroDel (String title) throws Exception;
	
	public boolean deleteDecl(int dno) throws Exception;
	
	public boolean deleteNotice(int bno) throws Exception;
	
	public boolean deleteBook(int bookNo) throws Exception;
	
	public boolean insertNotice(NoticeBean bean) throws Exception;
	
	public boolean insertBook(BookBean bean) throws Exception;
	
	public boolean updateNotice(NoticeBean bean) throws Exception;
	
	public boolean updateBook(BookBean bean) throws Exception;
}
