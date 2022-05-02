package controller.myPage;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.CommandHandler;
import service.MyPageService;
import service.MyPageServiceImpl;

public class Subcancle implements CommandHandler {

	@Override
	public String process(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		HttpSession session = req.getSession();
		String uId = (String)session.getAttribute("uId_Session");
		MyPageService ms = new MyPageServiceImpl();
		
		String writer = req.getParameter("writer");
		ms.deleteSub(uId, writer);
		
		String referer = req.getHeader("Referer");
		return "redirect:" + referer;
	}

}
