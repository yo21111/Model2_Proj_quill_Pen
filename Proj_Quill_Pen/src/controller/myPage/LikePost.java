package controller.myPage;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.CommandHandler;
import repository.DTO.BoardBean;
import service.MyPageService;
import service.MyPageServiceImpl;

public class LikePost implements CommandHandler {

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
		
		List<BoardBean> likeList = ms.likeArticle(req, resp);
		req.setAttribute("likeList", likeList);
		
		return "/viewPage/blogList.jsp";
	}
}