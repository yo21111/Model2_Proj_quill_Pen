package controller.admin;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.CommandHandler;
import repository.DTO.DeclBean;
import service.AdminService;
import service.AdminServiceImpl;

//신고 세부 페이지
public class DeclBoard implements CommandHandler {

	@Override
	public String process(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		AdminService as = new AdminServiceImpl();

		// 관리자인지 확인하기
		HttpSession session = req.getSession();
		String uId = (String) session.getAttribute("uId_Session");

		if (uId == null) {
			req.setAttribute("errorMsg", "로그인 시 이용할 수 있는 페이지입니다.");
			return "/index.jsp";

			// 로그인이 되었으나 관리자 등급이 아닌 경우
		} else if (!as.isAdmin(uId)) {
			req.setAttribute("errorMsg", "관리자만 이용할 수 있는 페이지입니다.");
			return "/index.jsp";

		}

		// 어떤 요청인지 확인하기
		int dno = Integer.parseInt(req.getParameter("dno"));

		String type = req.getParameter("do");

		if (type.equals("delete")) {
			// 삭제하기
			boolean result = as.deleteDecl(dno);
			if (!result) {
				req.setAttribute("errorMsg", "오류가 발생했습니다. 다시 시도해주세요.");
				return "/viewPage/board.jsp";
			}
			return "redirect:/Proj_Quill_Pen/Decl";
		}

		// 글 가져오기
		DeclBean dBean = as.getReport(req, resp);
		req.setAttribute("dBean", dBean);

		return "/viewPage/board.jsp";

	}

}