package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO_DTO.KiderDataBean;

public class KiderInputProAction implements CommandAction{

	public String requestPro(HttpServletRequest request,HttpServletResponse response)throws Throwable{
		request.setCharacterEncoding("utf-8");
		KiderDataBean member=new KiderDataBean();
		member.setSchul_nm(request.getParameter("schul_nm"));
		member.setSchul_num(Integer.parseInt(request.getParameter("schul_num")));
		member.setOfcdc(request.getParameter("ofcdc"));
		member.setMatr_gu(request.getParameter("matr_gu"));
		member.setDong(request.getParameter("dong"));
		
		
		return "kiderInputPro.jsp";
	}
}
