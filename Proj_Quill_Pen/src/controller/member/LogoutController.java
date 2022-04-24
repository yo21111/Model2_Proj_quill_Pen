package controller.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.CommandHandler;

//로그아웃 컨트롤러
public class LogoutController implements CommandHandler {

	@Override
	public String process(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		// 1. Session에서 로그아웃 시키고 메인페이지로 리다이렉트
		HttpSession session=req.getSession();
		session.invalidate();
		
		return "redirect:/Proj_Quill_Pen/main";
	}
	
}