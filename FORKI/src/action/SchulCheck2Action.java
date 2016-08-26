package action;

import java.util.Vector;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import action.*;
import userAction.LogonDBBean;

public class SchulCheck2Action implements CommandAction{
	
	public String requestPro(HttpServletRequest request,
			HttpServletResponse response) throws Throwable{
	
			request.setCharacterEncoding("UTF-8");

		   String check = request.getParameter("check");//y or n
		   String dong = request.getParameter("dong");//���̸�
		   LogonDBBean manager = LogonDBBean.getInstance();  
		   Vector SchulList = manager.SchulRead(dong);
		
		   request.setAttribute("check", check);
		   request.setAttribute("SchulList", SchulList);
		   
		
		return "/content/MyPage/factor/SchulCheck2.jsp";
	}
}
