package controller.board;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import controller.CommandHandler;
import repository.DTO.BoardBean;
import service.BoardService;
import service.BoardServiceImpl;

public class Insert implements CommandHandler {

	@Override
	public String process(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		BoardService bs = new BoardServiceImpl();
		String method = req.getMethod();
		HttpSession session = req.getSession();
		String uId = (String)session.getAttribute("uId");
		
		if(uId != null) {
			req.setAttribute("isLogin", "true");
		}
		
		if (method.equals("GET")) {
			req.setAttribute("do", "insert");
			return "/viewPage/board.jsp";
			
		} else {
			String writer = null;
			
			if (uId == null && !bs.isLogin(uId, 0)) {
				req.setAttribute("errorMsg", "로그인 후 사용하실 수 있습니다.");
				req.setAttribute("do", "select");
				req.setAttribute("login", "false");
				return "/viewPage/bbs.jsp";				
			} else {
				req.setAttribute("login", "true");
				writer = bs.findWriter(uId);
			}
			
			
			
			String saveDir = req.getSession().getServletContext().getRealPath("/upload");
			int maxSize = 10 * 1024 * 1024;
			String encoding = "UTF-8";

			MultipartRequest mReq = null;

			ServletContext context = req.getServletContext();

			try {
				mReq = new MultipartRequest(req, saveDir, maxSize, encoding, new DefaultFileRenamePolicy());
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			BoardBean bBean = new BoardBean();
			
			String title = mReq.getParameter("title");
			String subTitle = mReq.getParameter("subTitle");
			String content = mReq.getParameter("content");
			String category = mReq.getParameter("category"); 

			bBean.setTitle(title);
			bBean.setSubTitle(subTitle);
			bBean.setWriter(writer);
			bBean.setCategory(category);
			
			/* 파일관련 정보 출력 세팅 시작 */
			Enumeration files = mReq.getFileNames();
			String fileName = null;
			String fileOName = null;
			
			while(files.hasMoreElements()) {
				String name = (String)files.nextElement();
				fileName = mReq.getFilesystemName(name);
				fileOName = mReq.getOriginalFileName(name);
			}
			
			if(fileName != null && fileOName != null) {
				bBean.setFileName(fileName);
				bBean.setFileOName(fileOName);
			}
			
			boolean result = bs.write(bBean);
			
			
			if (!result) {
				req.setAttribute("errorMsg", "오류가 발생하였습니다. 다시 실행해주세요.");
				req.setAttribute("bBean", bBean);
				req.setAttribute("do", "insert");
				return "/viewPage/board.jsp";
			}

			return "/viewPage/bbs.jsp";
		}
	}
}