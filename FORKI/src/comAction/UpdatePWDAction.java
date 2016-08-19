package comAction;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import action.*;

public class UpdatePWDAction implements CommandAction{
	
	public String requestPro(HttpServletRequest request,
			HttpServletResponse response) throws Throwable{
		HttpSession session = request.getSession();
		request.setCharacterEncoding("UTF-8");
		
		String passwd = request.getParameter("passwd");
		String id = (String) session.getAttribute("findId");
		LogonDBBean manager = LogonDBBean.getInstance();
		
		int x = manager.updatePwd(passwd,id);
		System.out.println(x);
		
		request.setAttribute("x", x);
		return "/content/join/ComUpdatePWD.jsp";
	}
}
 