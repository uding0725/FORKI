package sysAction;

import java.util.Iterator;
import java.util.Vector;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import action.*;

public class MemberCareAction implements CommandAction{
	
	public String requestPro(HttpServletRequest request,
			HttpServletResponse response) throws Throwable{
		
			request.setCharacterEncoding("UTF-8");
			
			System.out.println("������?:::::");
			
			SystemDBBean manager = SystemDBBean.getInstance();
			Vector Memlist = manager.getMemcare();
			
			System.out.println("������?:::::"+Memlist.size());
			System.out.println("������?:::::"+Memlist);
			
			request.setAttribute("Memlist", Memlist);
			return "/content/adminPage/SysMemberCare.jsp";
			
	}

}
