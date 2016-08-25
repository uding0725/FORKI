package sysAction;

import java.util.Iterator;
import java.util.Vector;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import action.*;
import comAction.LogonDataBean;

public class ApproProAction implements CommandAction{
	
	public String requestPro(HttpServletRequest request,
			HttpServletResponse response) throws Throwable{
		
			request.setCharacterEncoding("UTF-8");
			
			String id = request.getParameter("id");
			String schul_num = request.getParameter("schul_num");
			
			SystemDBBean manager = SystemDBBean.getInstance();
			int check = manager.ApproUP(id,schul_num);
			
			request.setAttribute("check", new Integer(check));

			return "/content/adminPage/SysApproPro.jsp";
			
	}

}
