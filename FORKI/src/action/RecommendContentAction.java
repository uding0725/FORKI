package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO_DTO.PrBoardDBBean;
import DAO_DTO.PrBoardDataBean;

public class RecommendContentAction implements CommandAction{

	public String requestPro(HttpServletRequest request,HttpServletResponse response)throws Throwable{
		int num = Integer.parseInt(request.getParameter("num"));
		HttpSession session = request.getSession();
		String pageNum = request.getParameter("pageNum");
		String ref = request.getParameter("ref");
		String id = (String) session.getAttribute("id");
		
		PrBoardDataBean article =new PrBoardDataBean();
		PrBoardDBBean pbdb=PrBoardDBBean.getInstance();
		article=pbdb.getArticle(num);
		int idCheck = pbdb.idCheck(id, ref);
		
		request.setAttribute("idCheck", idCheck);
		request.setAttribute("num", new Integer(num));
		request.setAttribute("pageNum",  new Integer(pageNum));
		request.setAttribute("article", article);
		return "recommendContent.jsp";
	}
}
