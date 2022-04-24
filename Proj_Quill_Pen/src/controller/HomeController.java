package controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import repository.DTO.BookBean;
import service.HomeService;
import service.HomeServiceImpl;

public class HomeController implements CommandHandler {

	@Override
	public String process(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		//1. 슬라이드 이미지 영역 데이터리스트 가져오기
		HomeService hs = new HomeServiceImpl();
		List<BookBean> bookList = hs.getBookList(req, resp);
		
		//2. req에 setAttribute로 담기
		req.setAttribute("bookList", bookList);
		
		return "/index.jsp";
	}
	
}