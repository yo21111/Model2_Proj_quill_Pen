package controller.admin;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.CommandHandler;
import repository.DTO.NoticeBean;
import service.AdminService;
import service.AdminServiceImpl;

public class NoticeInsert implements CommandHandler {

	@Override
	public String process(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		AdminService as = new AdminServiceImpl();
		
		String type = req.getParameter("type");
		if(type.equals("insert")) {
			String writer = req.getParameter("writer");
			req.setAttribute("writer", writer);
			req.setAttribute("type", type);
			return "/viewPage/noticeInsert.jsp";
		} else {
			String mId = req.getParameter("mId");
			String title = req.getParameter("title");
			String content = req.getParameter("content");
			
			NoticeBean nBean = new NoticeBean(0, mId, title, content);
			as.insertNotice(nBean);
			return "redirect:/Proj_Quill_Pen/Notice";			
		}

	}

}
