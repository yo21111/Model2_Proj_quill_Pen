package service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import repository.DTO.BookBean;

public interface BookService {
	
	// 전체 책 목록 선택시
	public  List<BookBean> bookList (HttpServletRequest req, HttpServletResponse resp) throws Exception;
	// (String title)
	
	// 책선택시
	public BookBean bookSelect (HttpServletRequest req, HttpServletResponse resp) throws Exception;
	//public BookBean bookSelect (String title) throws Exception;
	
	// 책구매 선택시 -> 해당 책에 a태그를 넣어서 보내면 됨 / 백단에서는 전체 페이지
	// 구성시 link정보를 같이 보내주기만 하면 끝
	public BookBean bookPur (HttpServletRequest req, HttpServletResponse resp) throws Exception;
	//public BookBean bookPur (String link) throws Exception;
	
	
}
