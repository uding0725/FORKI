package userAction;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import action.*;

public class DeleteProAction implements CommandAction{
		
	public String requestPro(HttpServletRequest request,
			HttpServletResponse resopnse) throws Throwable{
	request.setCharacterEncoding("UTF-8");
	
	HttpSession session = request.getSession();
	
	String id = (String) session.getAttribute("id");
	String passwd  = request.getParameter("passwd");
	int check = 0;
	
	LogonDBBean manager = LogonDBBean.getInstance();
		manager.deleteHealth(id);
		manager.deleteKID_DATA(id,passwd);
	
	if(manager.deleteP_ETC(id,passwd)==1){
		check = manager.deleteMEMBER(id,passwd);
	}
	
	request.setAttribute("check", new Integer(check));
	
	return "/content/join/UserDeletePro.jsp";//�ش� ��
	}
}
