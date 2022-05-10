package controller.admin;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.CommandHandler;
import service.AdminService;
import service.AdminServiceImpl;

public class AdminDelete implements CommandHandler {

	@Override
	public String process(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		AdminService as = new AdminServiceImpl();
		
		String[] bno = req.getParameterValues("bno[]");
		int[] iBno = new int[bno.length];
		for (int i = 0; i < bno.length; i++) {
			iBno[i] = Integer.parseInt(bno[i]);
			System.out.println(iBno[i]);
		}
		Integer dno = Integer.parseInt(req.getParameter("dno"));
		Integer bookNo = Integer.parseInt(req.getParameter("bookNo"));
		
		for (int i = 0; i < iBno.length; i++) {
			if(iBno[i] != 0) {
				as.deleteNotice(iBno[i]);			
			}			
		}
		
		if(dno == null) {
			
		}
		
		if(dno != 0) {
			as.deleteDecl(dno);			
		}
		if(bookNo != 0) {
			as.deleteBook(bookNo);
		}
		

		String referer = req.getHeader("Referer");
		return "redirect:" + referer;			

	}

}
