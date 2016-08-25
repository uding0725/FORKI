package sysAction;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import sysAction.SystemDataBean;
import action.*;

public class BlackUCheckAction implements CommandAction{
	
	public String requestPro(HttpServletRequest request,
			HttpServletResponse response) throws Throwable{
		
			request.setCharacterEncoding("UTF-8");
			
			String id = request.getParameter("id");
			SystemDBBean manager = SystemDBBean.getInstance();

			SystemDataBean bl = manager.getBlackUCheck(id);
			
			request.setAttribute("id",bl.getId());
			request.setAttribute("m_grade",bl.getM_grade());
			request.setAttribute("r_date",bl.getR_date());
			request.setAttribute("content",bl.getContent());
			
			return "/content/adminPage/system/blackUCheck.jsp";
			
	}

}