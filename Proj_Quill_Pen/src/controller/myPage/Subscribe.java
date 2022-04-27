package controller.myPage;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.CommandHandler;
import repository.DTO.WriterBean;
import service.MyPageService;
import service.MyPageServiceImpl;

public class Subscribe implements CommandHandler {

	@Override
	public String process(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		MyPageService ms = new MyPageServiceImpl();
		HttpSession session = req.getSession();
		String uId = (String)session.getAttribute("uId_Session");
		if(uId != null) {
			req.setAttribute("isLogin", "true");
		}
		if (!ms.isLogin(uId)) {
			return "redirect:/Proj_Quill_Pen/main";
		}
		
		List<WriterBean> subsList = ms.subWriter(req, resp);
		req.setAttribute("subsList", subsList);
		
		return "/viewPage/blogList.jsp";
	}
	
}