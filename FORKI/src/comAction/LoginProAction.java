package comAction;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import action.*;
import comAction.LogonDataBean;

public class LoginProAction implements CommandAction{
	
	public String requestPro(HttpServletRequest request,
			HttpServletResponse response) throws Throwable{
		
		request.setCharacterEncoding("UTF-8");

		String id = request.getParameter("id");
		String passwd  = request.getParameter("passwd");
		
		HttpSession session = request.getSession();
		

		LogonDBBean manager = LogonDBBean.getInstance();
		int check= manager.userCheck(id,passwd);
		if(check==1){
			LogonDataBean DBdata = manager.getDBdata(id);
			session.setAttribute("id", id);
			session.setAttribute("grade", DBdata.getM_grade());
		}
		request.setAttribute("check", new Integer(check));
		
		return "/content/join/factor/company2/loginPro.jsp";//ÇØ´ç ºä
		
	}
}