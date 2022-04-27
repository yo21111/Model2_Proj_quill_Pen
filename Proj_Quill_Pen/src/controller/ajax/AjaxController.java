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

import com.fasterxml.jackson.databind.ObjectMapper;

import repository.DTO.AjaxBean;
import service.MemberService;
import service.MemberServiceImpl;

@WebServlet(urlPatterns = "/register/ajax")
public class AjaxController extends HttpServlet {

	ObjectMapper objectMapper = new ObjectMapper();

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		/////////////////////////////////////////////////////////////////////////////////		
		// ajax로 보낸 JSON데이터를 스트링으로 바꾸기
		Map<String, String> map = new HashMap<>();
		String data = req.getReader().lines().reduce("", String::concat);
		//{"name":"abc","age":10}
		data = data.replace("\"", "").replace("{", "").replace("}", "");
		String[] arr = data.split(",");
		
		for (int i = 0; i < arr.length; i++) {
			String[] strArr = arr[i].split(":");
			map.put(strArr[0], strArr[1]);
		}
		/////////////////////////////////////////////////////////////////////////////////
		
		String key = map.get("key");
		String value = map.get("value");
		
		System.out.println(key);
		System.out.println(value);
		
		MemberService ms = new MemberServiceImpl();
		if (key.equals("id")) {
			boolean result = false;
			try {
				result = ms.idChk(value);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			AjaxBean aBean = new AjaxBean();
			aBean.setKey("check");
			aBean.setValue(""+result);
			resp.setContentType("application/json;charset=utf-8");
			PrintWriter out = resp.getWriter();
			out.println(objectMapper.writeValueAsString(aBean));
			out.close();
			
		} else if (key.equals("writer")) {
			boolean result = false;
			try {
				result = ms.writerChk(value);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			AjaxBean aBean = new AjaxBean();
			aBean.setKey("yes");
			aBean.setValue(""+result);
			resp.setContentType("application/json;charset=utf-8");
			PrintWriter out = resp.getWriter();
			out.println(objectMapper.writeValueAsString(aBean));
			out.close();
			
		}
		
	}

}