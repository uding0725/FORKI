package comAction;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import action.*;

public class MainAction implements CommandAction{
	
	public String requestPro(HttpServletRequest request,
			HttpServletResponse response) throws Throwable{
		
			
		HttpSession session = request.getSession();
		String sessionid = (String) session.getAttribute("memId");
		request.setAttribute("memId", sessionid);
		
		return "/content/join/factor/company2/main.jsp";
	}

}