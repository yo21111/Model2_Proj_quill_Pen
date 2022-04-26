package service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import repository.DAO.HomeDao;
import repository.DTO.BookBean;
import repository.DTO.NoticeBean;
import repository.DTO.WriterBean;

public class HomeServiceImpl implements HomeService {
	HomeDao hDao = new HomeDao();

	@Override
	public List<BookBean> getBookList(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		List<BookBean> bookList = hDao.selectBookList();
		
		return bookList;
	}

	@Override
	public List<NoticeBean> getNoticeList() throws Exception {
		List<NoticeBean> noticeList = hDao.selectNoticeList();
		return noticeList;
	}

	@Override
	public List<WriterBean> getWriterList() throws Exception {
		List<WriterBean> writerList = hDao.selectWriterList();
		return writerList;
	}
	
	

}
