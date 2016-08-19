package userAction;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import action.*;

public class FindIDAction implements CommandAction{
	
	public String requestPro(HttpServletRequest request,
			HttpServletResponse response) throws Throwable{
		
		String name = request.getParameter("name");
		String email = request.getParameter("email");
	    
		LogonDBBean manager = LogonDBBean.getInstance();
		String id = manager.findID(name, email);
		
		request.setAttribute("id", id);
		
		return "/content/join/factor/user/findID.jsp";//ÇØ´ç ºä
	}
	
}