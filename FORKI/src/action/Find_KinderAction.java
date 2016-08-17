package action;

import java.util.Vector;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO_DTO.KiderDBBean;

public class Find_KinderAction implements CommandAction{

	public String requestPro(HttpServletRequest request,HttpServletResponse response)throws Throwable{
		KiderDBBean kdb=KiderDBBean.getInstance();
		String gu=request.getParameter("gu");
		int guNum=0;
		String dong= request.getParameter("dong");
		String schul_nm=request.getParameter("schul_nm");
		Vector vecList=new Vector();
		if(gu==null){
			gu="0";
			guNum=Integer.parseInt(gu);
		}else{
			guNum=Integer.parseInt(gu);
			vecList=kdb.selectKinder(guNum,dong,schul_nm);
		}
		
			int count=0;
		count=vecList.size();
		request.setAttribute("count", count);
		request.setAttribute("vecList", vecList);
		return "findkinder.jsp";
	}
}
