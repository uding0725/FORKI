package action;

import java.util.Vector;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO_DTO.LogonDBBean;

public class KiderInputFormAction implements CommandAction{

	public String requestPro(HttpServletRequest request, HttpServletResponse response)throws Throwable{
		
		String memId=(String)request.getSession().getAttribute("memId");
		LogonDBBean ldb =new LogonDBBean();
		Vector vecList= ldb.kidRead(memId);
		
		request.setAttribute("vecList",vecList);
		return "/content/kiderInputForm.jsp";
	}
}
