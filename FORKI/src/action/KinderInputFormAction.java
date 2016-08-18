package action;

import java.util.Vector;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO_DTO.LogonDBBean;

public class KinderInputFormAction implements CommandAction{

	public String requestPro(HttpServletRequest request, HttpServletResponse response)throws Throwable{
		
		String memId=(String)request.getSession().getAttribute("id");
		LogonDBBean ldb =LogonDBBean.getInstance();
		Vector vecList= ldb.kindRead(memId);
		request.setAttribute("vecList",vecList);
		return "kinderInput.jsp";
	}
}
