package controller.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.CommandHandler;
import repository.DTO.BoardBean;
import service.BoardService;
import service.BoardServiceImpl;

public class Board implements CommandHandler {

	@Override
	public String process(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		BoardService bs = new BoardServiceImpl();
		
		int bno = Integer.parseInt(req.getParameter("bno"));
		HttpSession session = req.getSession();
		String uId = (String)session.getAttribute("uId");
		
		if(uId != null) {
			req.setAttribute("isLogin", "true");
		}
		
		if(bs.isLogin(uId, bno)) {
			req.setAttribute("login", "true");
		} else {
			req.setAttribute("login", "false");
		}
		
		BoardBean bBean = bs.read(req, resp);
		req.setAttribute("bBean", bBean);
		
		return "/viewPage/board.jsp";
	}

}