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
		System.out.println(memId);
		LogonDBBean ldb =LogonDBBean.getInstance();
		KetcDataBean ketc=new KetcDataBean();
		ketc= ldb.kindRead(memId);
		KiderDBBean kdb=KiderDBBean.getInstance();
		int schul_num=ketc.getSchul_num();
		String schul_nm=ketc.getSchul_nm();
		int check=0;
		check=kdb.checkKinder(schul_nm,schul_num);//-1이면 가입이 안된것 1이면 유치원등록되있는것 0이면 승인대기중
		request.setAttribute("check",new Integer(check));
		request.setAttribute("ketc",ketc);
		return "kinderInput.jsp";
	}
}
