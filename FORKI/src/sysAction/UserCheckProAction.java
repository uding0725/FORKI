package sysAction;

import java.sql.Timestamp;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import comAction.LogonDataBean;
import action.*;

public class UserCheckProAction implements CommandAction{
	
	public String requestPro(HttpServletRequest request,
			HttpServletResponse response) throws Throwable{
		
			request.setCharacterEncoding("UTF-8");
			
			String id = request.getParameter("id");
			System.out.println("id:::"+id);
			SystemDBBean manager = SystemDBBean.getInstance();
			
			SystemDataBean GetM = manager.getMemCheck(id);
			int check = manager.insertBlack(GetM);
			System.out.println("check::"+check);
			request.setAttribute("check", check);
			
			return "/content/adminPage/system/UserCheckPro.jsp";
			
	}

}