package controller.member;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import controller.CommandHandler;
import repository.DTO.MemberBean;
import service.MemberService;
import service.MemberServiceImpl;

// 회원가입 컨트롤러
public class RegisterController implements CommandHandler {

	@Override
	public String process(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		// 어떤 method로 왔는지 확인하기
		String method = req.getMethod();

		if (method.equals("GET")) {
			// 만약 get 방식으로 왔다면
			// 폼으로 이동시키기
			return "/viewPage/register.jsp";
		} else {
			req.setCharacterEncoding("UTF-8");
			MemberService ms = new MemberServiceImpl();
			String uId = (String) req.getParameter("uId");
			String uPw = (String) req.getParameter("uPw");
			String writer = (String) req.getParameter("writer");
			String uName = (String) req.getParameter("uName");
			String uEmail = (String) req.getParameter("uEmail");
			String uBirth = (String) req.getParameter("uBirth");
			String uPhone = (String) req.getParameter("uPhone");
			MemberBean bean = new MemberBean(uId, uPw, writer, uName, uEmail, uBirth, uPhone);

			boolean result = false;

			// 회원가입 유효성 검사에 통과를 못했다면?
			if (!ms.validator(bean)) {
				req.setAttribute("errorMsg", "잘못 입력된 정보가 있습니다. 다시 입력해주세요");

				return "/viewPage/register.jsp";
			}

			// 회원 가입 유효성 검사에 통과했다면?
			result = ms.newMem(bean);

			// DAO 또는 DB에서 오류 발생 시
			if (!result) {
				req.setAttribute("errorMsg", "알 수 없는 오류가 발생하였습니다. 다시 시도해주세요.");

				return "/viewPage/register.jsp";
			}

			// 메인페이지로 리다이렉트
			return "redirect:/Proj_Quill_Pen/main";
		}
	}
}