package action;

import java.util.Collections;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO_DTO.ImgDataBean;
import DAO_DTO.KiderDBBean;

public class ModifyImgAction implements CommandAction {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		request.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();
		String schul_num = (String) session.getAttribute("schul_num");
		
		List imgList = null;
		KiderDBBean DBpro = KiderDBBean.getInstance();
		int check = DBpro.imgCheck(schul_num);
		int number = 0;
		
		if (check > 0) {
			imgList = DBpro.getImgList(schul_num, check);
		} else {
			imgList = Collections.EMPTY_LIST;
		}
		
		request.setAttribute("check", check);
		request.setAttribute("imgList", imgList);
		request.setAttribute("number", new Integer(number));
		
		return "ModifyImg.jsp";
	}

}
