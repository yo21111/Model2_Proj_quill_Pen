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
		String uId = (String) session.getAttribute("uId_Session");

		if (method.equals("GET")) {
			if (uId != null) {
				String writer = bs.findWriter(uId);
				req.setAttribute("writer", writer);
				req.setAttribute("nowPage", "insert");
				req.setAttribute("isLogin", "true");
				return "/viewPage/boardRewrite.jsp";
			} else {
				req.setAttribute("errorMsg", "로그인 후 사용하실 수 있습니다.");
				req.setAttribute("isLogin", "false");
				return "/viewPage/bbs.jsp";
			}

		} else {
			String writer = null;

			if (uId == null && !bs.isLogin(uId, 0)) {
				req.setAttribute("errorMsg", "로그인 후 사용하실 수 있습니다.");
				req.setAttribute("isLogin", "false");
				return "/viewPage/bbs.jsp";
			} else {
				req.setAttribute("login", "true");
				writer = bs.findWriter(uId);
			}
			
			
			String saveDir = req.getRealPath("/images/test");
			int maxSize = 10 * 1024 * 1024;
			String encoding = "UTF-8";

			MultipartRequest mReq = null;


			try {
				mReq = new MultipartRequest(req, saveDir, maxSize, encoding, new DefaultFileRenamePolicy());
			} catch (IOException e) {
				e.printStackTrace();
			}

			BoardBean bBean = new BoardBean();

			String title = mReq.getParameter("title");
			String subTitle = mReq.getParameter("subTitle");
			String content = mReq.getParameter("content");
			
			
			// #category로 태그를 붙힌 내용을 찾음
			int categoryIndex =  0;
			String category = "default";
			categoryIndex = content.indexOf("#");
			
			if(content != null && categoryIndex != -1 && content.length() > 11) {
				category = content.substring(categoryIndex+1, categoryIndex+11); 
			} else {
				category = "not select";
			}
			
			
			bBean.setTitle(title);
			bBean.setSubTitle(subTitle);
			bBean.setWriter(writer);
			bBean.setContent(content);
			bBean.setCategory(category);

			/* 파일관련 정보 출력 세팅 시작 */
			Enumeration files = mReq.getFileNames();
			String fileName = mReq.getFilesystemName("fileName");
			String fileOName = mReq.getOriginalFileName("fileName");
			
			
			while (files.hasMoreElements()) {
				String name = (String) files.nextElement();
				fileName = mReq.getFilesystemName(name);
				fileOName = mReq.getOriginalFileName(name);
				bBean.setFileName(fileName);
				bBean.setFileOName(fileOName);
			}

			boolean result = bs.write(bBean);

			if (!result) {
				req.setAttribute("errorMsg", "오류가 발생하였습니다. 다시 실행해주세요.");
				req.setAttribute("bBean", bBean);
				req.setAttribute("writer", writer);
				req.setAttribute("nowPage", "insert");
				return "/viewPage/boardRewrite.jsp";
			}
			
			
			return "redirect:/Proj_Quill_Pen/bbs";
		}
	}
}