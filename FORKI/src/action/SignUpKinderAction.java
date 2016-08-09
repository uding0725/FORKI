package action;

import java.util.Vector;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO_DTO.KiderDBBean;

public class SignUpKinderAction implements CommandAction{

	public String requestPro(HttpServletRequest request,HttpServletResponse response)throws Throwable{
		
		KiderDBBean kdb=KiderDBBean.getInstance();
		Vector vecList = kdb.signKinder();
		
		request.setAttribute("vecList", vecList);
		
		return "/content/adminPage/signUpLayout.jsp";
	}
}
