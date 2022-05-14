package controller.admin;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.CommandHandler;
import service.AdminService;
import service.AdminServiceImpl;
import service.BoardService;
import service.BoardServiceImpl;

public class AdminDelete implements CommandHandler {

	@Override
	public String process(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		AdminService as = new AdminServiceImpl();
		BoardService bs = new BoardServiceImpl();
		
		// 공지사항 삭제
		if(req.getParameterValues("bno[]") != null) {
			String[] bno = req.getParameterValues("bno[]");
			int[] iBno = new int[bno.length];
			for (int i = 0; i < bno.length; i++) {
				iBno[i] = Integer.parseInt(bno[i]);
			}
		
			for (int i = 0; i < iBno.length; i++) {
				if(iBno[i] != 0) {
					as.deleteNotice(iBno[i]);			
				}			
			}		
		}
	
		
		// 신고글 삭제
		if(req.getParameterValues("dno[]") != null) {
			String[] dno = req.getParameterValues("dno[]");
			int[] iDno = new int[dno.length];
			for(int i = 0; i < dno.length; i++) {
				iDno[i] = Integer.parseInt(dno[i]);
			}
			for (int i = 0; i < iDno.length; i++) {
				if(iDno[i] != 0) {
					as.deleteDecl(iDno[i]);			
				}			
			}	
		}
		
		
		//신고게시글 삭제
		if(req.getParameter("bno") != null) {
			int dno = Integer.parseInt(req.getParameter("dno"));
			int bno = Integer.parseInt(req.getParameter("bno"));
			String writer = req.getParameter("writer");
			
			bs.adminDelete(writer, bno);
			as.deleteDecl(dno);
			
			return "redirect:/Proj_Quill_Pen/admin";
		}
		
		
		// 책소개 삭제
		if(req.getParameterValues("bookNo[]") != null) {
			String[] bookNo = req.getParameterValues("bookNo[]");
			int[] iBookNo = new int[bookNo.length];
			for (int i = 0; i < iBookNo.length; i++) {
				iBookNo[i] = Integer.parseInt(bookNo[i]);
			}
			for (int i = 0; i < iBookNo.length; i++) {
				if(iBookNo[i] != 0) {
					as.deleteBook(iBookNo[i]);
				}			
			}	
		}
		

		
		

		

		


		String referer = req.getHeader("Referer");
		return "redirect:" + referer;			

	}

}
