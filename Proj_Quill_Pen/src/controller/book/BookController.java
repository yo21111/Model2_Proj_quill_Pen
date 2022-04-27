package controller.book;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
		
		HttpSession session = req.getSession();
		String uId = (String)session.getAttribute("uId_Session");
		if(uId != null) {
			req.setAttribute("isLogin", "true");
		}
		
		req.setAttribute("pageTitle", "Quill Pen 책방에 오신 걸 환영합니다");
		req.setAttribute("bookList", bookList);
		
		return "/viewPage/book.jsp";
	}
	
}