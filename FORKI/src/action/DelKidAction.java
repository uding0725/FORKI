package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO_DTO.KiderDBBean;

public class DelKidAction implements CommandAction {

	public String requestPro(HttpServletRequest request,HttpServletResponse response)throws Throwable{
		int schul_num= Integer.parseInt(request.getParameter("schul_num"));
		KiderDBBean kdb=KiderDBBean.getInstance();
		kdb.delKinder(schul_num);
		return "delKid.jsp";
	}
}
