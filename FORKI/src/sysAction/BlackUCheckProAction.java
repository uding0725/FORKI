package sysAction;

import java.sql.Timestamp;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import sysAction.*;
import action.*;

public class BlackUCheckProAction implements CommandAction{
	
	public String requestPro(HttpServletRequest request,
			HttpServletResponse response) throws Throwable{
		
			request.setCharacterEncoding("UTF-8");
			
			String id = request.getParameter("id");
			SystemDBBean manager = SystemDBBean.getInstance();
			
			int check = manager.deleteblack(id);
			request.setAttribute("check", check);
			
			return "/content/adminPage/system/blackUCheckPro.jsp";
			
	}

}