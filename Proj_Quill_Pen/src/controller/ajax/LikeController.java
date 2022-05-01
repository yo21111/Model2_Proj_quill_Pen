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

@WebServlet(urlPatterns = "/like")
public class LikeController extends HttpServlet {

	ObjectMapper objectMapper = new ObjectMapper();

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		String uId = (String) session.getAttribute("uId_Session");

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
		String key = map.get("key");
		String value = map.get("value");
		
		BoardService bs = new BoardServiceImpl();
		AjaxBean aBean = new AjaxBean();
		aBean.setKey("result");
		
		int bno = Integer.parseInt(value);
		
		boolean result = false;
		try {
			result = bs.isLike(uId, bno);
			
			// 만약 추천했었다면?
			if (result) {
				bs.unLike(uId, bno);
				aBean.setValue("추천 작가에서 삭제하였습니다.");
			} else {
			// 추천하지 않았었다면?
				bs.like(uId, bno);
				aBean.setValue("추천 작가에 추가하였습니다.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		resp.setContentType("application/json;charset=utf-8");
		PrintWriter out = resp.getWriter();
		out.println(objectMapper.writeValueAsString(aBean));
		out.close();
	}
}