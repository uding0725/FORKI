package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO_DTO.PrBoardDBBean;
import DAO_DTO.PrBoardDataBean;

public class RecommendUpdateAction implements CommandAction{

	public String requestPro(HttpServletRequest request,HttpServletResponse response)throws Throwable{
		request.setCharacterEncoding("utf-8");
		int num = Integer.parseInt(request.getParameter("num"));
		String pageNum=request.getParameter("pageNum");
		PrBoardDBBean pdb=PrBoardDBBean.getInstance();
		PrBoardDataBean article =pdb.updateGetArticle(num);
		
		request.setAttribute("pageNum",new Integer(pageNum));
		request.setAttribute("article",article);
		return "recommendUpdate.jsp";
	}
}
