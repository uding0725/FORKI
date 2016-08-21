package action;

import java.util.Vector;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO_DTO.MedicalDBBean;

public class MediDetailAction implements CommandAction{

	public String requestPro(HttpServletRequest request,HttpServletResponse response)throws Throwable{
		int check=Integer.parseInt(request.getParameter("check"));
		int num =Integer.parseInt(request.getParameter("num"));
		Vector vecList=new Vector();
		MedicalDBBean mdb=MedicalDBBean.getInstance();
		if(check==1){
			vecList=mdb.detailHel(num);
		}else{
			vecList=mdb.detailHosp(num);
		}
		request.setAttribute("vecList", vecList);
		return "search-detail.jsp";
	}
}
