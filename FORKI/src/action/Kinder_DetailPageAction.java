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
		//KiderDataBean DBdata = new KiderDataBean();
		String kinderNum = request.getParameter("num");
		System.out.println("메서드 실행 전");
		KiderDataBean  DBData= DBpro.selectDetKid(kinderNum);
		System.out.println("메서드 실행 후");
		request.setAttribute("name", DBData.getSchul_nm());
		request.setAttribute("addres", DBData.getAdres());
		request.setAttribute("tel", DBData.getTelno());
		request.setAttribute("classNo", DBData.getClas_co());
		request.setAttribute("studentNo", DBData.getStdnt_co_sm());
		request.setAttribute("girlNo", DBData.getGrlstdn_co());
		request.setAttribute("tcherNo", DBData.getFrl_tcher_co_sm());
		request.setAttribute("famTcherNo", DBData.getFrl_female_tcher_c());
		request.setAttribute("rm", DBData.getRm());
			
		return "kinder_DetailPage.jsp";
	}

}
