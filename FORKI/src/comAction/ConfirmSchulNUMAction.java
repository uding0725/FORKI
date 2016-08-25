package comAction;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import action.*;

public class ConfirmSchulNUMAction implements CommandAction{
	
	public String requestPro(HttpServletRequest request,
			HttpServletResponse response) throws Throwable{
		request.setCharacterEncoding("UTF-8");
		  
		String schul_num = request.getParameter("schul_num");
		LogonDBBean manager = LogonDBBean.getInstance();
		int check= manager.confirmSchulNUM(schul_num);
		
		request.setAttribute("schul_num", schul_num);
		request.setAttribute("check", new Integer(check));
		
		return "/content/join/factor/company2/confirmSchulNUM.jsp";
	}

}
