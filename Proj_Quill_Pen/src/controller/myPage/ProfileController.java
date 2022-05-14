package controller.myPage;



import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



import controller.CommandHandler;
import repository.DTO.MemberBean;

import service.AdminService;
import service.AdminServiceImpl;
import service.MyPageService;
import service.MyPageServiceImpl;

public class ProfileController implements CommandHandler {
	
	public String process(HttpServletRequest req, HttpServletResponse resp) throws Exception{
	
		MyPageService ms = new MyPageServiceImpl(); 
		AdminService as = new AdminServiceImpl();
		

		HttpSession session = req.getSession();
		String uId = (String) session.getAttribute("uId_Session");
		if(uId != null) {
			req.setAttribute("isLogin", "true");
		}

		if (as.isAdmin(uId)) {
			req.setAttribute("isAdmin", "true");

		}
	
		  MemberBean mBean = ms.userInfo(uId);
		     
		    req.setAttribute("mBean", mBean);
		    req.setAttribute("Writer", uId);
		
		return"/viewPage/profile.jsp";
	}

	
	
}
