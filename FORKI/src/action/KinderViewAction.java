package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import DAO_DTO.KiderDBBean;
import DAO_DTO.KiderDataBean;

public class KinderViewAction implements CommandAction{

	public String requestPro(HttpServletRequest request, HttpServletResponse response)throws Throwable{
		request.setCharacterEncoding("utf-8");
		int schul_num=0;
		String num=(String)request.getSession().getAttribute("compNum");
		schul_num=Integer.parseInt(num);
		KiderDBBean kdb=KiderDBBean.getInstance();
		int check=0;  
		check=kdb.checkKinder(schul_num);  
		KiderDataBean kdata=new KiderDataBean();
		kdata=kdb.selectKid(schul_num); 
		request.setAttribute("check",new Integer(check));
		request.setAttribute("schul_num", new Integer(schul_num));
		request.setAttribute("kdata", kdata);
		return "kinderView.jsp";
	}
}
