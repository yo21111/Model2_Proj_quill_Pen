package service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import repository.DAO.AdminDao;
import repository.DTO.BookBean;
import repository.DTO.DeclBean;
import repository.DTO.NoticeBean;

public class AdminServiceImpl implements AdminService {
	AdminDao aDao = new AdminDao();

	@Override
	public boolean isAdmin(String uId) throws Exception {
		boolean result = aDao.isAdmin(uId);
		return result;
	}

	@Override
	public List<NoticeBean> noticeList(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		String pageNo = req.getParameter("pageNo");
		int num = 1;

		if (pageNo != null) {
			num = Integer.parseInt(pageNo);
		}

		List<NoticeBean> noticeList = aDao.selectNoticeList(num);
		return noticeList;
	}

	@Override
	public List<DeclBean> reportList(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		String pageNo = req.getParameter("pageNo");
		int num = 1;

		if (pageNo != null) {
			num = Integer.parseInt(pageNo);
		}

		List<DeclBean> declList = aDao.selectDeclList(num);
		return declList;
	}

	@Override
	public NoticeBean getNotice(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		int bno = Integer.parseInt(req.getParameter("bno"));
		
		NoticeBean nBean = aDao.selectNotice(bno);
		return nBean;
	}

	@Override
	public DeclBean getReport(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		int bno = Integer.parseInt(req.getParameter("bno"));
		
		DeclBean dBean = aDao.selectDecl(bno);
		return dBean;
	}

	@Override
	public List<BookBean> bookList(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		String pageNo = req.getParameter("pageNo");
		int num = 1;

		if (pageNo != null) {
			num = Integer.parseInt(pageNo);
		}

		List<BookBean> bookList = aDao.selectBookList(num);
		return bookList;
	}

	@Override
	public BookBean getBook(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		int bookNo = Integer.parseInt(req.getParameter("bookNo"));
		
		BookBean bBean = aDao.selectBook(bookNo);
		return bBean;
	}
	
	@Override	
	public boolean deleteDecl(int dno) throws Exception {
		int result = aDao.deleteDecl(dno);
		
		return result==1 ? true : false;
	}
	
	@Override
	public boolean deleteNotice(int bno) throws Exception {
		int result = aDao.deleteNotice(bno);
		
		return result==1 ? true : false;
	}
	
	@Override
	public boolean deleteBook(int bookNo) throws Exception {
		int result = aDao.deleteBook(bookNo);
		
		return result==1 ? true : false;
	}
	
	@Override
	public boolean insertNotice(NoticeBean bean) throws Exception {
		int result = aDao.insertNotice(bean);
		
		return result==1 ? true : false;
	}
	
	@Override
	public boolean insertBook(BookBean bean) throws Exception {
		int result = aDao.insertBook(bean);
		
		return result==1 ? true : false;
	}
	
	@Override
	public boolean updateNotice(NoticeBean bean) throws Exception {
		int result = aDao.updateNotice(bean);
		
		return result==1 ? true : false;
	}
	
	@Override
	public boolean updateBook(BookBean bean) throws Exception {
		int result = aDao.updateBook(bean);
		
		return result==1 ? true : false;
	}
}
