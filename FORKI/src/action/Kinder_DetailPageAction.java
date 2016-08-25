package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO_DTO.KiderDataBean;
import DAO_DTO.KiderDBBean;

public class Kinder_DetailPageAction implements CommandAction {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		request.setCharacterEncoding("UTF-8");
		
		KiderDBBean DBpro = KiderDBBean.getInstance();
		String kinderNum = request.getParameter("num");
		KiderDataBean  DBData= DBpro.selectDetKid(kinderNum);
		String totalPer = DBpro.getTotal(kinderNum);
		int check = DBpro.imgCheck(kinderNum);
		
		request.setAttribute("check", check);
		
		request.setAttribute("name", DBData.getSchul_nm());
		request.setAttribute("addres", DBData.getAdres());
		request.setAttribute("tel", DBData.getTelno());
		request.setAttribute("classNo", DBData.getClas_co());
		request.setAttribute("studentNo", DBData.getStdnt_co_sm());
		request.setAttribute("girlNo", DBData.getGrlstdn_co());
		request.setAttribute("tcherNo", DBData.getFrl_tcher_co_sm());
		request.setAttribute("famTcherNo", DBData.getFrl_female_tcher_co());
		request.setAttribute("rm", DBData.getRm());
		request.setAttribute("totalPer", totalPer);
		
			
		return "kinder_DetailPage.jsp";
	}

}
