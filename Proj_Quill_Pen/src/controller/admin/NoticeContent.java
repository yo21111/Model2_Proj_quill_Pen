package controller.admin;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.CommandHandler;
import repository.DTO.NoticeBean;
import repository.DTO.WriterBean;
import service.AdminService;
import service.AdminServiceImpl;
import service.MyPageService;
import service.MyPageServiceImpl;

public class NoticeContent  implements CommandHandler {

	@Override
	public String process(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		AdminService as = new AdminServiceImpl();
		MyPageService ms = new MyPageServiceImpl();
		
		HttpSession session = req.getSession();
		String uId = (String)session.getAttribute("uId_Session");
		
		// 관리자일 경우
		if(as.isAdmin(uId)) {
			req.setAttribute("isAdmin", "true");
		}
		
		
		NoticeBean nBean = as.getNotice(req, resp);
		String mid = nBean.getmId();
		WriterBean wbean = ms.findWriter(mid);
		
		String writer = wbean.getWriter();
		int subCnt = ms.getSubCnt(writer);
		
		req.setAttribute("noticeBean", nBean);
		req.setAttribute("subCnt", subCnt);
		
		return "/viewPage/noticeBBS.jsp";
	}

}
