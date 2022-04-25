package controller.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.CommandHandler;
import repository.DTO.DeclBean;
import service.BoardService;
import service.BoardServiceImpl;

public class Report implements CommandHandler {

	@Override
	public String process(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		BoardService bs = new BoardServiceImpl();
		String method = req.getMethod();
		
		if(method.equals("GET")) {
			return "/viewPage/report.jsp";
		}
		
		String category = req.getParameter("category");
		String content = req.getParameter("content");
		HttpSession session = req.getSession();
		String writer = (String)session.getAttribute("uId_Session");
		int bno = Integer.parseInt(req.getParameter("bno"));
		
		DeclBean dBean = new DeclBean();
		dBean.setCategory(category);
		dBean.setContent(content);
		dBean.setWriter(writer);
		dBean.setBno(bno);
		
		boolean result = bs.report(dBean);
		
		req.setAttribute("bno", bno);
		return "/viewPage/board.jsp";
	}
	
}