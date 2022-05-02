package controller.myPage;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.CommandHandler;
import repository.DTO.BoardBean;
import repository.DTO.WriterBean;
import service.AdminService;
import service.AdminServiceImpl;
import service.BbsService;
import service.BbsServiceImpl;
import service.MyPageService;
import service.MyPageServiceImpl;

public class MyPageController implements CommandHandler {

	@Override
	public String process(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		// 작가 리스트에서 작가를 클릭했을 경우 파라미터로 전달하므로 null이 아님
		String writerName = req.getParameter("writer");
		MyPageService ms = new MyPageServiceImpl();
		AdminService as = new AdminServiceImpl();
		
		if (writerName != null) {
		// 해당 작가의 작가페이지 보여주기
			
			HttpSession session = req.getSession();
			String myId = (String)session.getAttribute("uId_Session");
			String uId = ms.findId(writerName);
			
			WriterBean bean = ms.findWriter(uId);
			
			// 관리자일 경우(신고버튼 감춤용)
			if(as.isAdmin(uId)) {
				req.setAttribute("isAdmin", "true");
			}
			
			String title = bean.getTitle();
			String content = bean.getContent();
			String fileName = bean.getFileName();
			int subCnt = ms.getSubCnt(writerName);
			int LikeCnt = ms.getLikeCnt(uId);
			List<BoardBean> myArticle = ms.myArticle(writerName);
			boolean selectResult = ms.selectSubWriter(myId, writerName);
			if(selectResult) {
				req.setAttribute("alreadySub", "true");
			}
			
			req.setAttribute("myArticle", myArticle);
			req.setAttribute("writer", writerName);
			req.setAttribute("title", title);
			req.setAttribute("content", content);
			req.setAttribute("fileName", fileName);
			req.setAttribute("subCnt", subCnt);
			req.setAttribute("LikeCnt", LikeCnt);
			req.setAttribute("myId", myId);
			req.setAttribute("uId", uId);
		
			return "/viewPage/blog.jsp";
			
		} else {
		// 없는 경우는 마이페이지 인 경우임
		HttpSession session = req.getSession();
		String uId = (String)session.getAttribute("uId_Session");
		if(uId != null) {
			req.setAttribute("isLogin", "true");
		}

		if (!ms.isLogin(uId)) {
			return "redirect:/Proj_Quill_Pen/main";
		}
		
		System.out.println("uId : "+uId);
		WriterBean bean = ms.findWriter(uId);
		
		String writer = bean.getWriter();
		String title = bean.getTitle();
		String content = bean.getContent();
		String fileName = bean.getFileName();
		int subCnt = ms.getSubCnt(writer);
		int LikeCnt = ms.getLikeCnt(uId);
		List<BoardBean> myArticle = ms.myArticle(writer);
		
		req.setAttribute("myArticle", myArticle);
		req.setAttribute("writer", writer);
		req.setAttribute("title", title);
		req.setAttribute("content", content);
		req.setAttribute("fileName", fileName);
		req.setAttribute("subCnt", subCnt);
		req.setAttribute("LikeCnt", LikeCnt);
		
		return "/viewPage/blog.jsp";
		}
	}
	
}