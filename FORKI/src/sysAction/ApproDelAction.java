package sysAction;

import java.util.Iterator;
import java.util.Vector;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import action.*;
import comAction.LogonDataBean;

public class ApproDelAction implements CommandAction{
	
	public String requestPro(HttpServletRequest request,
			HttpServletResponse response) throws Throwable{
		
			request.setCharacterEncoding("UTF-8");
			
			String id = request.getParameter("id");
			
			SystemDBBean manager = SystemDBBean.getInstance();
			int check = 0;
			int x = manager.deleteK_ETC(id);
			if(x==1){
				int y = manager.deleteP_ETC(id);
				
				if(y==1){
					check =  manager.deleteMEMBER(id);
				}
			}
			request.setAttribute("check", new Integer(check));

			return "/content/adminPage/SysApproDel.jsp";
			
	}

}
