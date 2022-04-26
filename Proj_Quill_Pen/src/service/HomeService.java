package service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import repository.DTO.BookBean;
import repository.DTO.NoticeBean;
import repository.DTO.WriterBean;

public interface HomeService {

	// 게시판 책 리스트 Dao에서 가져오기
	public List<BookBean> getBookList(HttpServletRequest req, HttpServletResponse resp) throws Exception;
	
	// 공지사항 내용 가져오기
	public List <NoticeBean> getNoticeList() throws Exception;

	// 작가 리스트 가져오기
	public List <WriterBean> getWriterList() throws Exception;
}
