package userAction;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import action.*;

public class FindSendAction implements CommandAction{
	
	public String requestPro(HttpServletRequest request,
			HttpServletResponse response) throws Throwable{
		
		SendEmail sendEmail = new SendEmail(); /*이메일을 보내는 클레스*/
		CreateCode code = new CreateCode(); /*랜덤코드를 생성하는 클레스*/
		HttpSession session = request.getSession();
		
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String getKey = code.randomCode();

		LogonDBBean manager = LogonDBBean.getInstance();
		int check = manager.findPWD(id, name, email);

		
		if(check == 1){
			session.setAttribute("findId", id); /*회원의 아이디값을 세션의 저장*/
			session.setAttribute("findKey", getKey); /*회원의 키값을 세션의 저장*/
			sendEmail.sendCode(email, getKey, 2);
		}
		request.setAttribute("check", new Integer(check));	
		
		return "/content/join/factor/user/findSend.jsp";//해당 뷰
	}
}
