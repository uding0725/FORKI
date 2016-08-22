package comAction;

import java.util.Vector;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import action.*;

public class SchulCheckAction implements CommandAction{
	
	public String requestPro(HttpServletRequest request,
			HttpServletResponse response) throws Throwable{
	
			request.setCharacterEncoding("UTF-8");

		   String check = request.getParameter("check");//y or n
		   String dong = request.getParameter("dong");//µø¿Ã∏ß
		   LogonDBBean manager = LogonDBBean.getInstance();  
		   Vector SchulList = manager.SchulRead(dong);
		   System.out.println(SchulList.size());
		   System.out.println(check);
		   request.setAttribute("check", check);
		   request.setAttribute("SchulList", SchulList);
		   
		
		return "/content/join/factor/company2/SchulCheck.jsp";
	}
}
