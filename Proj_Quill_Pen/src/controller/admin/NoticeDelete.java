package controller.admin;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.CommandHandler;
import service.AdminService;
import service.AdminServiceImpl;

public class NoticeDelete implements CommandHandler {

	@Override
	public String process(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		AdminService as = new AdminServiceImpl();
		
		
		
		int bno = Integer.parseInt(req.getParameter("bno"));
		as.deleteNotice(bno);
		
		return "redirect:/Proj_Quill_Pen/main";
	}

}
