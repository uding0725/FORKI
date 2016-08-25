package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO_DTO.KiderDBBean;

public class InsertFavorAction implements CommandAction {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {

		request.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("id");
		String kinderNum = request.getParameter("num");
		
		KiderDBBean DBpro = KiderDBBean.getInstance();
		int check = DBpro.setFavor(id, kinderNum);
		
		request.setAttribute("check", new Integer(check));
		return "InsertFavor.jsp";
	}

}
