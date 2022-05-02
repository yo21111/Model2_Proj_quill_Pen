package controller.myPage;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.CommandHandler;
import service.MyPageService;
import service.MyPageServiceImpl;

public class SubscribeInsert implements CommandHandler {

	@Override
	public String process(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		MyPageService ms = new MyPageServiceImpl();
		HttpSession session = req.getSession();
		String uId = (String)session.getAttribute("uId_Session");
		if(uId != null) {
			req.setAttribute("isLogin", "true");
		}
		if (!ms.isLogin(uId)) {
			req.setAttribute("errorMsg", "로그인 시 이용할 수 있는 페이지입니다.");
		}
		
		String writer = req.getParameter("writer");
		
		boolean result = ms.insertSubWriter(uId, writer);
		if(!result) {
			req.setAttribute("subMsg", "오류가 발생했습니다. 다시 시도해주세요.");
		} else {
			req.setAttribute("subMsg", "구독하였습니다.");			
		}
		return "/viewPage/subList.jsp";
	}

}
