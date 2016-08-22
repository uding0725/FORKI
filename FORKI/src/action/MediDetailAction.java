package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO_DTO.HealCenDataBean;
import DAO_DTO.HospitalDataBean;
import DAO_DTO.MedicalDBBean;

public class MediDetailAction implements CommandAction{

	public String requestPro(HttpServletRequest request,HttpServletResponse response)throws Throwable{
		int check=Integer.parseInt(request.getParameter("check"));
		int num =Integer.parseInt(request.getParameter("num"));
		HospitalDataBean hosp=new HospitalDataBean();
		HealCenDataBean hel=new HealCenDataBean();
		MedicalDBBean mdb=MedicalDBBean.getInstance();
		if(check==1){
			hel=mdb.detailHel(num);
			
		}else{
			hosp=mdb.detailHosp(num);
		}
		request.setAttribute("hel", hel);
		request.setAttribute("hosp", hosp);
		request.setAttribute("check", new Integer(check));
		return "search-detailPage.jsp";
	}
}
