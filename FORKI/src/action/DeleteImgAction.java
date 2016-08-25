package action;

import java.util.Collections;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO_DTO.KiderDBBean;

public class DeleteImgAction implements CommandAction{

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		request.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();
		String schul_num = (String) session.getAttribute("schul_num");
		String name = request.getParameter("name");

		KiderDBBean DBpro = KiderDBBean.getInstance();
		int check = DBpro.deleteImg(schul_num, name);
		
		request.setAttribute("num", schul_num);
		request.setAttribute("check", check);
		
		return "DeleteImg.jsp";
	}

}
