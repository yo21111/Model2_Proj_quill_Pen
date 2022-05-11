package controller.ajax;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.CommandHandler;
import service.BoardService;
import service.BoardServiceImpl;

public class CmntController implements CommandHandler{
	
	@Override
	public String process(HttpServletRequest req, HttpServletResponse resp) throws Exception{
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		HttpSession session = req.getSession();
		String uId = (String)session.getAttribute("uId_Session");
		int bno = Integer.parseInt(req.getParameter("cmntBno"));

		String cmnt = req.getParameter("cmnt");
		
		BoardService bs = new BoardServiceImpl();
		
		String cmntKind = req.getParameter("cmntkind");
		
		if(cmntKind == null) {
			cmntKind = "insertCmnt";
		}
		
		if(cmntKind.equals("updateCmnt")) {
			int cno = Integer.parseInt(req.getParameter("cmntNumber"));
			boolean result = bs.updateCmnt(bno, cno, cmnt);
		} else if(cmntKind.equals("deleteCmnt")) {
			int cno = Integer.parseInt(req.getParameter("cmntNumber"));
			boolean result = bs.deleteCmnt(cno);
		} else {
			boolean result = bs.writeCmnt(bno, uId, cmnt);
		}
		
		
		return "redirect:/Proj_Quill_Pen/boardRead?bno=" + bno;
	}
	
}