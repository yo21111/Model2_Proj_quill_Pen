package controller.myPage;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.CommandHandler;
import service.MyPageService;
import service.MyPageServiceImpl;

public class Withdraw  implements CommandHandler {

	@Override
	public String process(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		MyPageService ms = new MyPageServiceImpl();
		HttpSession session = req.getSession();
		String uId = (String)session.getAttribute("uId_Session");
		
		if (!ms.isLogin(uId)) {
			return "redirect:/Proj_Quill_Pen/main";
		}
		
		String method = req.getMethod();
		
		if(method.equals("GET")) {
			return "/viewPage/withdraw.jsp";
		}
		
		ms.withdraw(uId);
		return "redirect:/Proj_Quill_Pen/main";
	}
	
}