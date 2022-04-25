package controller.admin;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.CommandHandler;
import repository.DTO.NoticeBean;
import service.AdminService;
import service.AdminServiceImpl;

//공지사항 세부페이지
public class NoticeBoard implements CommandHandler {

	@Override
	public String process(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		AdminService as = new AdminServiceImpl();
		
		// 관리자인지 확인하기
		HttpSession session = req.getSession();
		String uId = (String)session.getAttribute("uId_Session");
		
		if (uId == null) {
			req.setAttribute("errorMsg", "로그인 시 이용할 수 있는 페이지입니다.");
			return "/index.jsp";
		
		// 로그인이 되었으나 관리자 등급이 아닌 경우
		} else if (!as.isAdmin(uId)) {
			req.setAttribute("errorMsg", "관리자만 이용할 수 있는 페이지입니다.");
			return "/index.jsp";

		}
		
		
		// 어떤 요청인지 확인하기
		String method = req.getMethod();
		String type = req.getParameter("do");

		int bno = Integer.parseInt(req.getParameter("bno"));
		
		
		// 글 가져오기, 글 삭제하기 / GET 방식
		if (method.equals("GET")) {
			
			if(type.equals("delete")) {
				// 삭제하기
				boolean result = as.deleteNotice(bno);
				if(!result) {
					req.setAttribute("errorMsg", "오류가 발생했습니다. 다시 시도해주세요.");
					return "/viewPage/board.jsp";
				}
				return "redirect:/Proj_Quill_Pen/Notice";
			}
			
			if(type.equals("insert")) {
				req.setAttribute("do", "insert");
				return "/viewPage/board.jsp";
			}
			
			if(type.equals("update")) {
				req.setAttribute("do", "update");
				return "/viewPage/board.jsp";				
			}
			
			NoticeBean nBean = as.getNotice(req, resp);
			req.setAttribute("nBean", nBean);
			
			return "/viewPage/board.jsp";

		// 글 등록하기, 글 수정하기 / POST 방식
		} else {
			String mId = req.getParameter("mId");
			String title = req.getParameter("title");
			String content = req.getParameter("content");
			
			NoticeBean nBean = new NoticeBean(bno, mId, title, content);
			
			// 수정하기
			if(type.equals("update")) {
				boolean result = as.updateNotice(nBean);
				if(!result) {
					req.setAttribute("errorMsg", "오류가 발생했습니다. 다시 시도해주세요.");
					return "/viewPage/board.jsp";
				}
				req.setAttribute("do", "read");
				return "/viewPage/board.jsp";
			}
			
			// 글 등록하기
			boolean result = as.insertNotice(nBean);
			if(!result) {
				req.setAttribute("errorMsg", "오류가 발생했습니다. 다시 시도해주세요.");
				return "/viewPage/board.jsp";
			}
			req.setAttribute("do", "read");
			return "/viewPage/board.jsp";
		}
		
	}

}