package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class NullHandler implements CommandHandler {
	@Override
	public String process(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		// 대신에 에러페이지 보내도 될 듯?
		resp.sendError(HttpServletResponse.SC_NOT_FOUND);
		return null;
	}
}
