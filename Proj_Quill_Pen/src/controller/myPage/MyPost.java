package controller.myPage;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.CommandHandler;
import repository.DTO.BoardBean;
import repository.DTO.WriterBean;
import service.MyPageService;
import service.MyPageServiceImpl;

public class MyPost implements CommandHandler {

	@Override
	public String process(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		MyPageService ms = new MyPageServiceImpl();
		HttpSession session = req.getSession();
		String uId = (String)session.getAttribute("uId_Session");
		
		if (!ms.isLogin(uId)) {
			return "redirect:/Proj_Quill_Pen/main";
		}
		
		WriterBean bean = ms.findWriter(uId);
		String writer = bean.getWriter();
		
		List<BoardBean> myList = ms.myArticle(writer);
		req.setAttribute("myList", myList);
		
		return "/viewPage/bbs.jsp";
	}
	
}