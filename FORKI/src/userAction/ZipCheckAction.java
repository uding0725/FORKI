package userAction;

import java.util.Vector;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import action.*;

public class ZipCheckAction implements CommandAction{
	
	public String requestPro(HttpServletRequest request,
			HttpServletResponse response) throws Throwable{
	
			request.setCharacterEncoding("UTF-8");

		   String check = request.getParameter("check");//y or n
		   String area4 = request.getParameter("area4");//µø¿Ã∏ß
		   LogonDBBean manager = LogonDBBean.getInstance();  
		   Vector zipcodeList = manager.zipcodeRead(area4);
		   request.setAttribute("check", check);
		   request.setAttribute("zipcodeList", zipcodeList);
		   
		
		return "/content/join/factor/user/ZipCheck.jsp";
	}
}
