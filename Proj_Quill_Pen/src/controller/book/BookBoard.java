package controller.book;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import controller.CommandHandler;
import repository.DTO.BookBean;
import service.AdminService;
import service.AdminServiceImpl;

public class BookBoard implements CommandHandler  {

	@Override
	public String process(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		AdminService as = new AdminServiceImpl();
		
		
		
		// 관리자인지 확인하기
		HttpSession session = req.getSession();
		String uId = (String)session.getAttribute("uId_Session");
	
		// 어떤 요청인지 확인하기
		String method = req.getMethod();
		String type = req.getParameter("do");

		int bookNo = Integer.parseInt(req.getParameter("bookNo"));
		
		// 관리자 등급인 경우
		// read, insert, update, delete 가능
		if (as.isAdmin(uId)) {
			
			// 글 가져오기, 글 삭제하기 / GET 방식
			if (method.equals("GET")) {
				
				if(type.equals("delete")) {
					// 삭제하기
					boolean result = as.deleteBook(bookNo);
					if(!result) {
						req.setAttribute("errorMsg", "오류가 발생했습니다. 다시 시도해주세요.");
						return "/viewPage/board.jsp";
					}
					return "redirect:/Proj_Quill_Pen/admin";
				}
				
				if(type.equals("insert")) {
					req.setAttribute("do", "insert");
					return "/viewPage/board.jsp";
				}
				
				if(type.equals("update")) {
					req.setAttribute("do", "update");
					return "/viewPage/board.jsp";				
				}
				
				BookBean bBean = as.getBook(req, resp);
				req.setAttribute("bBean", bBean);
				
				return "/viewPage/board.jsp";

			// 글 등록하기, 글 수정하기 / POST 방식
			} else {
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
				
				BookBean bBean = new BookBean();
				
				String title = mReq.getParameter("title");
				String subTitle = mReq.getParameter("subTitle");
				String category= mReq.getParameter("category");
				String link = mReq.getParameter("link");
				bBean.setTitle(title);
				bBean.setSubTitle(subTitle);
				bBean.setCategory(category);
				bBean.setLink(link);
				
				/* 파일관련 정보 출력 세팅 시작 */
				Enumeration files = mReq.getFileNames();
				List<String> saveFiles = new ArrayList<>();
				List<String> origFiles = new ArrayList<>();
				
				while(files.hasMoreElements()) {
					String name = (String)files.nextElement();
					saveFiles.add(mReq.getFilesystemName(name));
					origFiles.add(mReq.getOriginalFileName(name));
				}
				
				
				if(saveFiles.size() != 0) {
					String fileName = saveFiles.get(0);
					String fileOName = origFiles.get(0);
					String imageName = saveFiles.get(1);
					String imageOName = origFiles.get(1);
					bBean.setFileName(fileName);
					bBean.setFileOName(fileOName);
					bBean.setImageName(imageName);
					bBean.setImageOName(imageOName);
				}
				
				
				// 수정하기
				if(type.equals("update")) {
					boolean result = as.updateBook(bBean);
					if(!result) {
						req.setAttribute("errorMsg", "오류가 발생했습니다. 다시 시도해주세요.");
						return "/viewPage/board.jsp";
					}
					req.setAttribute("do", "read");
					return "/viewPage/board.jsp";
				}
				
				// 글 등록하기
				boolean result = as.insertBook(bBean);
				if(!result) {
					req.setAttribute("errorMsg", "오류가 발생했습니다. 다시 시도해주세요.");
					return "/viewPage/board.jsp";
				}
				req.setAttribute("do", "read");
				return "/viewPage/board.jsp";
			}
			
			
			

		} else {
		// 관리자 등급이 아닌 일반 유저인 경우
		// read만 가능
			BookBean bBean = as.getBook(req, resp);
			req.setAttribute("bBean", bBean);
			
			return "redirect:/Proj_Quill_Pen/book";
		}
	}
	
}
