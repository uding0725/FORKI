package userAction;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.*;

public class ConfirmNickAction implements CommandAction{
	
	public String requestPro(HttpServletRequest request,
			HttpServletResponse response) throws Throwable{
		request.setCharacterEncoding("UTF-8");
		  
		String nickname = request.getParameter("nickname");
		LogonDBBean manager = LogonDBBean.getInstance();
		int check= manager.confirmNick(nickname);
		
		request.setAttribute("nickname", nickname);
		request.setAttribute("check", new Integer(check));
		
		return "/content/join/factor/user/confirmNick.jsp";
	}

}
