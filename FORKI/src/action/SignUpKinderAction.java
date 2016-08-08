package action;

import java.util.Vector;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO_DTO.KiderDBBean;

public class SignUpKinderAction implements CommandAction{

	public String requsetPro(HttpServletRequest request,HttpServletResponse response)throws Throwable{
		
		KiderDBBean kdb=KiderDBBean.getInstance();
		Vector vecList = kdb.signKinder();
		String schul_nm=(String)vecList.get(0);
		int schul_num=(int)vecList.get(1);
		
		
		return "signUpKinder.jsp";
	}
}
