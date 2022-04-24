package service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import repository.DTO.BookBean;

public interface HomeService {

	// 게시판 책 리스트 Dao에서 가져오기
	public List<BookBean> getBookList(HttpServletRequest req, HttpServletResponse resp) throws Exception;
	
}
