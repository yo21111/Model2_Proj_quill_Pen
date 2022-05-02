package controller.ajax;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;

import repository.DTO.AjaxBean;
import service.BoardService;
import service.BoardServiceImpl;

@WebServlet(urlPatterns = "/board/cmnt")
public class CmntController extends HttpServlet {

	ObjectMapper objectMapper = new ObjectMapper();

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		String uId = (String) session.getAttribute("uId_Session");
		
		System.out.println("들어옴????");
		
		/////////////////////////////////////////////////////////////////////////////////
		// ajax로 보낸 JSON데이터를 스트링으로 바꾸기
		Map<String, String> map = new HashMap<>();
		String data = req.getReader().lines().reduce("", String::concat);
		// {"name":"abc","age":10}
		data = data.replace("\"", "").replace("{", "").replace("}", "");
		String[] arr = data.split(",");

		for (int i = 0; i < arr.length; i++) {
			String[] strArr = arr[i].split(":");
			map.put(strArr[0], strArr[1]);
		}
		/////////////////////////////////////////////////////////////////////////////////
		int bno = Integer.parseInt(map.get("key"));
		String content = map.get("value");

		
		BoardService bs = new BoardServiceImpl();
		boolean result = false;
		try {
			result = bs.writeCmnt(bno, uId, content);
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
		AjaxBean aBean = new AjaxBean();
		aBean.setKey(uId);
		aBean.setValue(content);

		resp.setContentType("application/json;charset=utf-8");
		PrintWriter out = resp.getWriter();
		out.println(objectMapper.writeValueAsString(aBean));
		out.close();
	}

}