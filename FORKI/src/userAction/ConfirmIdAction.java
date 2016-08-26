package userAction;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.*;

public class ConfirmIdAction implements CommandAction{
	
	public String requestPro(HttpServletRequest request,
			HttpServletResponse response) throws Throwable{
		request.setCharacterEncoding("UTF-8");
		  
		String id = request.getParameter("id");
		LogonDBBean manager = LogonDBBean.getInstance();
		int check= manager.confirmId(id);
		
		request.setAttribute("id", id);
		request.setAttribute("check", new Integer(check));
		
		return "/content/join/factor/user/confirmId.jsp";
	}
	

}
