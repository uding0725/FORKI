package sysAction;

import java.util.Vector;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import action.*;

public class Black_ListAction implements CommandAction{
	
	public String requestPro(HttpServletRequest request,
			HttpServletResponse response) throws Throwable{
		
			request.setCharacterEncoding("utf-8");
			
			System.out.println("������?:::::");
			
			SystemDBBean manager = SystemDBBean.getInstance();
			Vector Blist = manager.getBLACKLIST();
			
			System.out.println("������?:::::"+Blist.size());
			
			request.setAttribute("Blist", Blist);
			
			return "/content/join/factor/system/black_list.jsp";
			
	}

}
