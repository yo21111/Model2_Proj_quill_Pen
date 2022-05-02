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
		if(uId == null) {
			req.setAttribute("isAdmin", "false");
		} else if (as.isAdmin(uId)) {
			req.setAttribute("isAdmin", "true");
		} else {
			req.setAttribute("isAdmin", "false");
		}
		
		NoticeBean nBean = as.getNotice(req, resp);
//		String mid = nBean.getmId();
		String writer = nBean.getWriter();
		
		int subCnt = ms.getSubCnt(writer);
		boolean selectResult = ms.selectSubWriter(uId, writer);
		if(selectResult) {
			req.setAttribute("alreadySub", "true");
		}
		
		
		
		req.setAttribute("noticeBean", nBean);
		req.setAttribute("subCnt", subCnt);
		req.setAttribute("myId", uId);
		
		return "/viewPage/noticeBBS.jsp";
	}

}
