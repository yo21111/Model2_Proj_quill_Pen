package controller.admin;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.CommandHandler;

// 공지사항 목록(리스트)
public class Notice implements CommandHandler {

	@Override
	public String process(HttpServletRequest req, HttpServletResponse resp) throws Exception {

		return "/viewPage/noticeBBS.jsp";
	}
	
}