package controller.myPage;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.CommandHandler;
import repository.DTO.MemberBean;
import repository.DTO.WriterBean;
import service.MyPageService;
import service.MyPageServiceImpl;

public class InfoUpdate implements CommandHandler {

	@Override
	public String process(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		MyPageService ms = new MyPageServiceImpl();
		HttpSession session = req.getSession();
		String uId = (String)session.getAttribute("uId_Session");
		
		String method = req.getMethod();
				
		if (method.equals("GET")) {
			// 로그인 되어 있는지 확인
			if(ms.isLogin(uId)) {
				MemberBean mBean = ms.userInfo(uId);
				req.setAttribute("mBean", mBean);
				return "/viewPage/profile.jsp";
			}
			// 로그인이 안되어 있다면?
			return "redirect:/Proj_Quill_Pen/main";
		}
		
		//POST요청을 했다면?
		String uName = req.getParameter("uId");
		String uEmail = req.getParameter("uId");
		String uPhone = req.getParameter("uId");
		String uBirth = req.getParameter("uId");
		String writer = req.getParameter("uId");
		
		if(!ms.writerCheck(writer)) {
			MemberBean mBean = ms.userInfo(uId);
			req.setAttribute("errorMsg", "중복된 작가명입니다. 다른 작가명을 입력해주세요.");
			req.setAttribute("mBean", mBean);
			return "/viewPage/profile.jsp";
		}
		
		boolean result = ms.modUser(uName,uEmail,uPhone,uBirth,writer);
		
		return "/viewPage/profile.jsp";
	}
	
}