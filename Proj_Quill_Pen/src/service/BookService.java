package service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import repository.DTO.BookBean;

public interface BookService {
	
	// 전체 책 목록 선택시
	public  List<BookBean> bookList (HttpServletRequest req, HttpServletResponse resp) throws Exception;
	
}
