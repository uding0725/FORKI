package action;

import java.util.Collections;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO_DTO.KiderDataBean;
import DAO_DTO.KiderDBBean;

public class Kinder_DetailPageAction implements CommandAction {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		System.out.println("占쏙옙占쏙옙占�"+request.getParameter("num"));
		System.out.println("id"+ session.getAttribute("id"));
		System.out.println("grade"+session.getAttribute("grade"));
		String schul_num = request.getParameter("num");
		String id = (String) session.getAttribute("id");
		String grade = (String) session.getAttribute("grade");

		KiderDBBean DBpro = KiderDBBean.getInstance();
		KiderDataBean  DBData= DBpro.selectDetKid(schul_num);
		String totalPer = DBpro.getTotal(schul_num);
		
		int check = DBpro.imgCheck(schul_num);
		int number = 0;
		int checkFavor = 0;

		if (grade == "1") {

			checkFavor = DBpro.checkFavor(id, schul_num);
		}
		
		List imgList = null;
		
		if (check > 0) {
			imgList = DBpro.getImgList(schul_num, check);
		} else {
			imgList = Collections.EMPTY_LIST;
		}
		
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
		request.setAttribute("check", check);
		request.setAttribute("imgList", imgList);
		request.setAttribute("checkFavor", checkFavor);
			
		return "kinder_DetailPage.jsp";
	}

}
