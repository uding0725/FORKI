package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO_DTO.LogonDBBean;
import DAO_DTO.LogonDataBean;

public class WriteMessageAction implements CommandAction{

	public String requestPro(HttpServletRequest request,HttpServletResponse response)throws Throwable{
	
		request.setCharacterEncoding("utf-8");
		String ids=(String)request.getParameter("id");
		System.out.println("writeMessageAction "+ids);
		System.out.println("session id "+request.getSession().getAttribute("id"));
		request.setAttribute("id", ids);
		return "WriteMessage.jsp";
	}
}
