package controller.book;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.CommandHandler;
import repository.DTO.BookBean;
import service.BookService;
import service.BookServiceImple;

// 책소개 게시판(목록)
public class BookController implements CommandHandler {

	@Override
	public String process(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		BookService bs = new BookServiceImple();
		List<BookBean> bookList = bs.bookList(req, resp);
		
		
		req.setAttribute("bookList", bookList);
		
		return "/viewPage/book.jsp";
	}
	
}