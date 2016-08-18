package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO_DTO.PrBoardDBBean;
import DAO_DTO.PrBoardDataBean;

public class RecommendUpdateProAction implements CommandAction{

	public String requestPro(HttpServletRequest request,HttpServletResponse response)throws Throwable{
		request.setCharacterEncoding("utf-8");
		int num =Integer.parseInt(request.getParameter("num"));
		String pageNum= request.getParameter("pageNum");
		PrBoardDataBean article =new PrBoardDataBean();

		article.setNum(num);
		article.setSubject(request.getParameter("subject"));
		article.setContent(request.getParameter("content"));
		PrBoardDBBean pbdb=PrBoardDBBean.getInstance();
		int check =0;
		check=pbdb.updateArticle(article);
		request.setAttribute("pageNum", new Integer(pageNum));
		request.setAttribute("check",new Integer(check));
		return "recommendUpdatePro.jsp";
	}
}
