package controller.board;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.CommandHandler;
import repository.DTO.BoardBean;
import repository.DTO.CmntBean;
import repository.DTO.WriterBean;
import service.AdminService;
import service.AdminServiceImpl;
import service.BoardService;
import service.BoardServiceImpl;

public class Board implements CommandHandler {

	@Override
	public String process(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		BoardService bs = new BoardServiceImpl();
		AdminService as = new AdminServiceImpl();
		
		int bno = Integer.parseInt(req.getParameter("bno"));
		HttpSession session = req.getSession();
		String uId = (String)session.getAttribute("uId_Session");
		
		
		if(uId != null) {
			req.setAttribute("isLogin", "true");
			if(bs.isLogin(uId, bno)) {
				req.setAttribute("myPost", "true");
			} else {
				req.setAttribute("myPost", "false");
			}
		} else {
			req.setAttribute("isLogin", "false");
			req.setAttribute("myPost", "false");
		}
		if(as.isAdmin(uId)) {
			req.setAttribute("isAdmin", "true");
		} else {
			req.setAttribute("isAdmin", "false");
		}
		
		
		req.setAttribute("readonly", "readonly");
		
		int commentCnt = bs.getCmntCnt(bno);
		req.setAttribute("commentCnt", commentCnt);
		
		
		BoardBean boardBean = bs.read(req, resp);
		req.setAttribute("boardBean", boardBean);
		
		
		String writer = boardBean.getWriter();
		WriterBean writerBean = bs.getWriter(writer);
		req.setAttribute("writerBean", writerBean);
		
		List<CmntBean> cmntList = bs.selectCmntList(bno);
		req.setAttribute("cmntList", cmntList);
		
		bs.incrViewCnt(bno);
		
		return "/viewPage/board.jsp";
	}

}