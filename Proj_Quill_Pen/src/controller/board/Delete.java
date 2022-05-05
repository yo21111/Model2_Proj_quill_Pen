package controller.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.CommandHandler;
import service.BoardService;
import service.BoardServiceImpl;

public class Delete  implements CommandHandler {

	@Override
	public String process(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		BoardService bs = new BoardServiceImpl();
		
		HttpSession session = req.getSession();
		String uId = (String)session.getAttribute("uId_Session");
		int bno = Integer.parseInt(req.getParameter("bno"));
		
		if(uId != null) {
			req.setAttribute("isLogin", "true");
		}
		
		if (uId == null || !bs.isLogin(uId, bno)) {
			req.setAttribute("errorMsg", "로그인 후 사용하실 수 있습니다.");
			req.setAttribute("isLogin", "false");
			return "redirect:/Proj_Quill_Pen/boardRead?bno="+bno;				
		}
		
		bs.delete(uId, bno);
		return "redirect:/Proj_Quill_Pen/bbs";
	}
}