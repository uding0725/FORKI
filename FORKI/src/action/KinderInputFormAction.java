package action;

import java.util.Vector;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO_DTO.KetcDataBean;
import DAO_DTO.KiderDBBean;
import DAO_DTO.LogonDBBean;

public class KinderInputFormAction implements CommandAction{

	public String requestPro(HttpServletRequest request, HttpServletResponse response)throws Throwable{
		
		String memId=(String)request.getSession().getAttribute("id");
		LogonDBBean ldb =LogonDBBean.getInstance();
		KetcDataBean ketc=new KetcDataBean();
		ketc= ldb.kindRead(memId);
		KiderDBBean kdb=KiderDBBean.getInstance();
		int schul_num=ketc.getSchul_num();
		int check=0;
		check=kdb.checkKinder(schul_num);
		request.setAttribute("check",new Integer(check));
		request.setAttribute("ketc",ketc);
		return "kinderInput.jsp";
	}
}
