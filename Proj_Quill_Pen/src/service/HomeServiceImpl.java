package service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import repository.DAO.HomeDao;
import repository.DTO.BookBean;

public class HomeServiceImpl implements HomeService {

	@Override
	public List<BookBean> getBookList(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		HomeDao hDao = new HomeDao();
		List<BookBean> bookList = hDao.selectBookList();
		
		return bookList;
	}

}
