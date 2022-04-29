package controller.admin;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.CommandHandler;
import repository.DTO.NoticeBean;
import service.AdminService;
import service.AdminServiceImpl;

public class NoticeContent  implements CommandHandler {

	@Override
	public String process(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		AdminService as = new AdminServiceImpl();
		
		HttpSession session = req.getSession();
		String uId = (String)session.getAttribute("uId_Session");
		
		// 관리자일 경우
		if(as.isAdmin(uId)) {
			req.setAttribute("isAdmin", "true");
		}
		
		NoticeBean nBean = as.getNotice(req, resp);
		
		req.setAttribute("noticeBean", nBean);
		return "/viewPage/noticeBBS.jsp";
	}

}
