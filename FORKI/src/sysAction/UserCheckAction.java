package sysAction;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import comAction.LogonDataBean;
import action.*;

public class UserCheckAction implements CommandAction{
	
	public String requestPro(HttpServletRequest request,
			HttpServletResponse response) throws Throwable{
		
			request.setCharacterEncoding("utf-8");
			
			System.out.println("나오니?:::::");
			
			
			String id = request.getParameter("id");
			SystemDBBean manager = SystemDBBean.getInstance();

			LogonDataBean m = manager.getMemUserCheck(id);
			
			request.setAttribute("id",m.getId());
			request.setAttribute("yellow_card",m.getYellow_card());
			request.setAttribute("join_date",m.getJoin_date());
			request.setAttribute("email",m.getEmail());
			request.setAttribute("address",m.getAddress());
			
			LogonDataBean p = manager.getP_etcUserCheck(id);
			request.setAttribute("nickname",p.getNickname());
			request.setAttribute("sex",p.getSex());

			
			System.out.println("나오니?:::::");
			
			return "/content/join/factor/system/UserCheck.jsp";
			
	}

}