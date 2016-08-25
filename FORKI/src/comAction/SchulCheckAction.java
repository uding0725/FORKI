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
		   String schul_nm = request.getParameter("schul_nm");//유치원명
		   LogonDBBean manager = LogonDBBean.getInstance();  
		   Vector SchulList = manager.SchulRead(schul_nm);
		   
		   request.setAttribute("check", check);
		   request.setAttribute("SchulList", SchulList);
		   
		
		return "/content/join/factor/company2/SchulCheck.jsp";
	}
}
