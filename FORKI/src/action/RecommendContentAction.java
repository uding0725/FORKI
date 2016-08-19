package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO_DTO.PrBoardDBBean;
import DAO_DTO.PrBoardDataBean;

public class RecommendContentAction implements CommandAction{

	public String requestPro(HttpServletRequest request,HttpServletResponse response)throws Throwable{
		int num = Integer.parseInt(request.getParameter("num"));
		String pageNum = request.getParameter("pageNum");
		PrBoardDataBean article =new PrBoardDataBean();
		PrBoardDBBean pbdb=PrBoardDBBean.getInstance();
		article=pbdb.getArticle(num);
		request.setAttribute("num", new Integer(num));
		request.setAttribute("pageNum",  new Integer(pageNum));
		request.setAttribute("article", article);
		return "recommendContent.jsp";
	}
}
