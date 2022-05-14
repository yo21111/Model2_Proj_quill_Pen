package controller.myPage;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.CommandHandler;
import service.MyPageService;
import service.MyPageServiceImpl;

public class UpdateWithdraw  implements CommandHandler {

	@Override
	public String process(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		
		MyPageService ms = new MyPageServiceImpl();
		HttpSession session = req.getSession();
		String uId = (String)session.getAttribute("uId_Session");
		if(uId != null) {
			req.setAttribute("isLogin", "true");
		}
		String method = req.getMethod();
				
		if (method.equals("GET")) {
			// 로그인 되어 있는지 확인
			if(ms.isLogin(uId)) {
				//회원탈퇴
				boolean isWithdraw = ms.withdraw(uId);
				req.setAttribute("isWithdraw", isWithdraw );
				return "redirect:/Proj_Quill_Pen/main";
			} else {
				// 로그인이 안되어 있다면?
				return "redirect:/Proj_Quill_Pen/main";
			}
		}
	

		return "redirect:/Proj_Quill_Pen/main";
		
		
	}

}
