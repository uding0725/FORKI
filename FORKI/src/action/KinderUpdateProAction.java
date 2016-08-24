package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO_DTO.KiderDBBean;
import DAO_DTO.KiderDataBean;

public class KinderUpdateProAction implements CommandAction{
	
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable{
		request.setCharacterEncoding("utf-8");
		KiderDataBean kdata=new KiderDataBean();
		kdata.setSchul_nm(request.getParameter("schul_nm"));
		kdata.setSchul_num(Integer.parseInt(request.getParameter("schul_num")));
		kdata.setOfcdc(request.getParameter("ofcdc"));
		kdata.setMatr_gu(request.getParameter("matr_gu"));
		kdata.setDong(request.getParameter("dong"));
		kdata.setFond(request.getParameter("fond"));
		kdata.setTelno(request.getParameter("telno"));
		kdata.setZip(request.getParameter("zipcode"));
		kdata.setAdres(request.getParameter("address"));
		kdata.setStdnt_co_sm(Integer.parseInt(request.getParameter("stdnt_co_sm")));
		kdata.setGrlstdn_co(Integer.parseInt(request.getParameter("grlstdn_co")));
		kdata.setClas_co(Integer.parseInt(request.getParameter("clas_co")));
		kdata.setFrl_tcher_co_sm(Integer.parseInt(request.getParameter("frl_tcher_co_sm")));
		kdata.setFrl_female_tcher_co(Integer.parseInt(request.getParameter("frl_female_tcher_co")));
		kdata.setRm(request.getParameter("rm"));
		KiderDBBean kdb=KiderDBBean.getInstance();
		int x=kdb.updateKinder(kdata);
		request.setAttribute("x", x);
		return "kinderUpdatePro.jsp";
	}
}