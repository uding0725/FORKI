package action;

import java.sql.Timestamp;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO_DTO.KiderDBBean;
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
		member.setFond(request.getParameter("fond"));
		member.setTelno(request.getParameter("telno"));
		member.setZip(request.getParameter("zip"));
		member.setAdres(request.getParameter("adres"));
		member.setStdnt_co_sm(Integer.parseInt(request.getParameter("stdnt_co_sm")));
		member.setGrlstdn_co(Integer.parseInt(request.getParameter("grlstdn_co")));
		member.setClas_co(Integer.parseInt(request.getParameter("clas_co")));
		member.setFrl_tcher_co_sm(Integer.parseInt(request.getParameter("frl_tcher_co_sm")));
		member.setFrl_female_tcher_c(Integer.parseInt(request.getParameter("frl_female_tcher_c")));
		member.setRm(request.getParameter("rm"));
		member.setState(request.getParameter("state"));
		member.setReg_date(new Timestamp(System.currentTimeMillis()));
		KiderDBBean kdb=KiderDBBean.getInstance();
		kdb.insertKid(member);
		
		return "kiderInputPro.jsp";
	}
}
