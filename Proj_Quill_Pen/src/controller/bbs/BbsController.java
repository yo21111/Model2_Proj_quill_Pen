package controller.bbs;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.CommandHandler;
import repository.DTO.BoardBean;
import service.BbsService;
import service.BbsServiceImpl;

// 게시글 목록
public class BbsController implements CommandHandler {

	@Override
	public String process(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		BbsService bs = new BbsServiceImpl();
		
		String search = req.getParameter("search");
		String category = req.getParameter("category");
		List<BoardBean> bbsList =  null;
		
		// 검색어 입력이 있다면
		if(search != null) {
			bbsList = bs.search(search);
			
		// 카테고리 입력이 있다면
		} else if (category != null) {
			bbsList = bs.category(category);
			
		// 그냥 게시글 목록 보려 한다면	
		} else {
			bbsList = bs.articleList();
			
		}
		
		req.setAttribute("bbsList", bbsList);
		return "/viewPage/bbs.jsp";
	}
	
}