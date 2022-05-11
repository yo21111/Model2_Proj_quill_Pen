package controller.admin;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.CommandHandler;
import repository.DTO.NoticeBean;
import service.AdminService;
import service.AdminServiceImpl;

public class NoticeModify implements CommandHandler {

	@Override
	public String process(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		AdminService as = new AdminServiceImpl();
		
		
		int bno = Integer.parseInt(req.getParameter("bno"));
		String mId = req.getParameter("mId");
		String title = req.getParameter("title");
		String content = req.getParameter("content");
		String type = req.getParameter("type");
		
		
		NoticeBean nBean = new NoticeBean(bno, mId, title, content);
		as.updateNotice(nBean);
		req.setAttribute("NoticeBean", nBean);
		
		if(type.equals("insert")) {
			return "/NoticeContent?bno="+bno;	
		} else {
			return "/viewPage/noticeRewrite.jsp";			
		}
	}

}
