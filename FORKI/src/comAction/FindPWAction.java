package comAction;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import comAction.LogonDBBean;
import action.*;

public class FindPWAction implements CommandAction {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		HttpSession session = request.getSession();
		request.setCharacterEncoding("UTF-8");
		String key = request.getParameter("key"); /*이메에서 전송된 파라메타 파라메터로 키값을 받아옴*/
		String sessionKey = (String) session.getAttribute("findKey"); /*세션에 저장되 있던 키값*/
		String id = (String) session.getAttribute("findId");
		int check = 0 ; //인증성공여부를 전달하기 위한 변수
		System.out.println(id);
		if (key.equals(sessionKey)) 
			check = 1;
		/*세션에 저장된 키값과 파라메터로 받은 키값을 비교하여 인증값을 바꾸는 메서드 실행*/
		
		request.setAttribute("check", new Integer(check));
		return "/content/join/ComFindPW.jsp";
	}

}
