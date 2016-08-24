package action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO_DTO.KiderDBBean;

public class FavoriteKinderAction implements CommandAction {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		HttpSession session = request.getSession();
		request.setCharacterEncoding("UTF-8");
		String id = (String) session.getAttribute("id");
		List articleList = null;

		KiderDBBean DBpro = KiderDBBean.getInstance();
		String favoriteList = DBpro.getFavorite(id);

		articleList = DBpro.getList(favoriteList);

		request.setAttribute("articleList", articleList);
		return "FavoriteKinder.jsp";
	}

}
