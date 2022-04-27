package controller.member;

import java.io.PrintWriter;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.CommandHandler;
import service.MemberService;
import service.MemberServiceImpl;

//로그인 컨트롤러
public class LoginController implements CommandHandler {

	@Override
	public String process(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		req.setCharacterEncoding("UTF-8");

		String uId = (String) req.getParameter("uId");
		String uPw = (String) req.getParameter("uPw");
		String uName = (String) req.getParameter("uName");
		String uPhone = (String) req.getParameter("uPhone");
		String rememId = req.getParameter("rememId");

		if (rememId == null) {
			req.setAttribute("rememId", "false");
		} else {
			req.setAttribute("rememId", "true");
		}

		// GET방식인지 POST방식인지 확인
		String method = req.getMethod();
		// 아이디 비밀번호 찾기 페이지에서 ?check=id 또는 ?check=pw 보내기
		String find = req.getParameter("find");

		req.setAttribute("find", "pwCheck");

		MemberService ms = new MemberServiceImpl();
		// check를 id로 보냈을 때

		if (find != null && find.equals("id")) {
			// GET 방식일 때
			if (method.equals("GET")) {
				req.setAttribute("find", "id"); // 아이디 찾기 페이지로 돌아가기
				req.setAttribute("title", "아이디 찾기");
				return "/viewPage/findInfo.jsp";

				// POST 방식일 때
			} else {
				String id = ms.findId(uName, uPhone);
				if (id == null) {
					req.setAttribute("title", "아이디 찾기");
					req.setAttribute("errorMsg", "아이디가 존재하지 않습니다.");
					req.setAttribute("find", "id"); // 아이디 찾기 페이지로 돌아가기
					return "/viewPage/findInfo.jsp";
				} else {
					req.setAttribute("title", "아이디 찾기");
					req.setAttribute("findId", id); // 찾은 아이디 정보
					req.setAttribute("find", "findId"); // 아이디 찾기 페이지로 돌아가기
					return "/viewPage/findInfo.jsp";
				}
			}
			// check를 pw로 보냈을 때
		} else if (find != null && (find.equals("pw") || find.equals("pwCheck"))) {
			// GET 방식일 때
			if (method.equals("GET")) {
				req.setAttribute("find", "pw"); // 비밀번호 찾기 페이지로 돌아가기
				req.setAttribute("title", "비밀번호 찾기");
				return "/viewPage/findInfo.jsp";

				// POST 방식일 때
			} else {

				req.setAttribute("title", "비밀번호 찾기");
				if (find != null && (find.equals("pw") || find.equals("pwCheck"))) {
					// 입력이 잘못 되었으면?

					if (find != null && find.equals("pw")) {
						if (!ms.findPw(uId, uPhone)) {
							req.setAttribute("errorMsg", "잘못된 입력입니다. 다시 입력해주세요.");
							req.setAttribute("find", "pw"); // 비밀번호 찾기 페이지로 돌아가기
							System.out.println("find : pw");
							return "/viewPage/findInfo.jsp";
						} else {
							req.setAttribute("uId", uId);
							req.setAttribute("title", "비밀번호 변경하기");
							req.setAttribute("find", "pwCheck"); // 비밀번호 찾기 페이지로 돌아가기
							System.out.println("find : pwCheck");
							return "/viewPage/findInfo.jsp";
						}
					} else if (find != null && find.equals("pwCheck")) {
						if (!ms.changePw(uId, uPw)) {
							req.setAttribute("title", "비밀번호 변경하기");
							req.setAttribute("find", "pwCheck");
							System.out.println("find : pwCheck2");
							req.setAttribute("uId", uId);
							req.setAttribute("errorMsg", "오류가 발생했습니다. \n다시 시도해주세요.");
							return "/viewPage/findInfo.jsp";
						} else {
							System.out.println("업데이트 완료");
							req.setAttribute("updateComp", "true");
							return "/viewPage/login.jsp";
						}

					}
				}
			}
		}

		// 쿠키에 저장되어있는 정보가 있는지
		Cookie[] cookies = req.getCookies();
		String cId = "";

		if (cookies != null) {
			for (int i = 0; i < cookies.length; i++) {
				if (cookies[i].getName().trim().equals("cId")) {
					cId = cookies[i].getValue();
				}
			}
		}

		// 아직 로그인 버튼 안눌러서 아이디, 비밀번호가 리퀘스트에 없는 경우
		if (find == null && uId == null && uPw == null) {
			// 1. 원래 가려했던 페이지가 있는지 확인한다.
			if (req.getParameter("to") == null) {
				// NullPointException 예외 방지용
				req.setAttribute("to", "");
			}

			return "/viewPage/login.jsp";

		} else if (find == null && uId != null && uPw != null) {
			// 아이디 비밀번호에 대한 검사 진행 후 (아이디, 비밀번호에 해당하는 계정이 있는지)
			boolean check = ms.loginChk(uId, uPw);

			// 만약 로그인 정보가 유효하지 않다면 에러메시지와 함께 로그인페이지로 돌아가기
			if (!check) {
				req.setAttribute("errorMsg", "아이디 또는 비밀번호를 확인해주세요.");
				return "/viewPage/login.jsp";
			}

			// 세션에 아이디 값 넣기
			HttpSession session = req.getSession();
			session.setAttribute("uId_Session", uId);

			// 아이디 기억하기 체크시 -> on

			Cookie cookie = null;

			if (rememId != null && rememId.trim().equals("on")) {
				cookie = new Cookie("cId", uId);
				cookie.setMaxAge(60 * 60 * 24); // 1일을 유효기간으로
				resp.addCookie(cookie);
			} else {
				cookie = new Cookie("cId", null);
				cookie.setMaxAge(0); // 쿠키 없애기
				resp.addCookie(cookie);
			}

			// 원래 가려던 페이지가 있는지 확인하기
			String to = (String) req.getParameter("to");

			// 있다면 가려했던 페이지로 리다이렉트
			if (to != null) {
				return "redirect:/Proj_Quill_Pen" + to;
			}

			// 없다면 메인페이지로 리다이렉트
			return "redirect:/Proj_Quill_Pen/main";
		} else {
			return "redirect:/Proj_Quill_Pen/login";
		}
	}
}