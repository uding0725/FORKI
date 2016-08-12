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
		KiderDataBean DBdata = new KiderDataBean();
		String kinderNum = request.getParameter("num");
		System.out.println("메서드 실행 전");
		DBpro.selectDetKid(kinderNum);
		System.out.println("메서드 실행 후");
		request.setAttribute("name", DBdata.getSchul_nm());
		request.setAttribute("addres", DBdata.getAdres());
		request.setAttribute("tel", DBdata.getAdres());
		request.setAttribute("classNo", DBdata.getClas_co());
		request.setAttribute("studentNo", DBdata.getStdnt_co_sm());
		request.setAttribute("girlNo", DBdata.getGrlstdn_co());
		request.setAttribute("tcherNo", DBdata.getFrl_tcher_co_sm());
		request.setAttribute("famTcherNo", DBdata.getFrl_female_tcher_c());
		request.setAttribute("rm", DBdata.getRm());
			
		return "kinder_DetailPage.jsp";
	}

}
