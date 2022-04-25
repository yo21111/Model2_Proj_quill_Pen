package service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import repository.DAO.BookDao;
import repository.DTO.BookBean;

public class BookServiceImple implements BookService {
	BookDao bDao = new BookDao();
	
	@Override
	public List<BookBean> bookList(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		List<BookBean> bookList = bDao.selectBookList(); 
		return bookList;
	}

}
