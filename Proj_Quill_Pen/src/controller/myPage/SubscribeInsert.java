package controller.myPage;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.taglibs.standard.tag.compat.fmt.RequestEncodingTag;

import controller.CommandHandler;
import repository.DTO.WriterBean;
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
		
		boolean selectResult = ms.selectSubWriter(uId, writer);
		
		if(selectResult) {
			req.setAttribute("subMsg", "이미 구독한 사람입니다.");
		} else {			
			boolean result = ms.insertSubWriter(uId, writer);
			if(!result) {
				req.setAttribute("subMsg", "오류가 발생했습니다. 다시 시도해주세요.");
			} else {
				req.setAttribute("subMsg", "구독하였습니다.");			
			}
		}
//		return "redirect:/Proj_Quill_Pen/main";
		String referer = req.getHeader("Referer");
		return "redirect:" + referer;
	}

}
