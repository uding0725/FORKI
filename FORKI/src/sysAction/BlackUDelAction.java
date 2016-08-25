package sysAction;

import java.sql.Timestamp;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import sysAction.*;
import userAction.*;
import comAction.*;
import action.*;

public class BlackUDelAction implements CommandAction{
	
	public String requestPro(HttpServletRequest request,
			HttpServletResponse response) throws Throwable{
		
			request.setCharacterEncoding("UTF-8");
			
			String id = request.getParameter("id");
			String m_grade = request.getParameter("m_grade");
			
			SystemDBBean sysmanager = SystemDBBean.getInstance();
			int check = 0;
			if("1".equals(m_grade)){
				sysmanager.deleteblack(id);
				sysmanager.deleteKID_DATA(id);
				if(sysmanager.deleteP_ETC(id)==1){
					check = sysmanager.deleteMEMBER(id);
				}
			}
			
			if("2".equals(m_grade)){
				sysmanager.deleteblack(id);
				sysmanager.deleteK_ETC(id);
				if(sysmanager.deleteP_ETC(id)==1){
					check = sysmanager.deleteMEMBER(id);
				}
			}
			request.setAttribute("check", check);

			/*SystemDBBean manager = SystemDBBean.getInstance();
			
			int check = manager.deleteblack(id);
			System.out.println("check::"+check);
			request.setAttribute("check", check);*/
			
			return "/content/adminPage/system/blackUDel.jsp";
			
	}

}