package controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import repository.DTO.BookBean;
import repository.DTO.NoticeBean;
import repository.DTO.WriterBean;
import service.AdminService;
import service.AdminServiceImpl;
import service.HomeService;
import service.HomeServiceImpl;

public class HomeController implements CommandHandler {

	@Override
	public String process(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		//1. 슬라이드 이미지 영역 데이터리스트 가져오기
		HomeService hs = new HomeServiceImpl();
		List<BookBean> bookList = hs.getBookList(req, resp);
		List<NoticeBean> noticeList = hs.getNoticeList();
		List<WriterBean> writerList = hs.getWriterList();
		
		//2. req에 setAttribute로 담기
		req.setAttribute("bookList", bookList);
		req.setAttribute("noticeList", noticeList);
		req.setAttribute("writerList", writerList);
		
		HttpSession session = req.getSession();
		String uId = (String)session.getAttribute("uId_Session");
		if(uId != null) {
			req.setAttribute("isLogin", "true");
		}

		
		return "/index.jsp";
	}
	
}