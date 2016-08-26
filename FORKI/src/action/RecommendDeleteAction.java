package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO_DTO.PrBoardDBBean;

public class RecommendDeleteAction implements CommandAction{

	public String requestPro(HttpServletRequest request,HttpServletResponse response)throws Throwable{
		
		request.setCharacterEncoding("utf-8");
		int num =Integer.parseInt(request.getParameter("num"));
		int ref=Integer.parseInt(request.getParameter("ref"));
		int re_level=Integer.parseInt(request.getParameter("re_level"));
		int re_step=Integer.parseInt(request.getParameter("re_step"));
		String pageNum=request.getParameter("pageNum");
		int check=0;
		PrBoardDBBean pbdb=PrBoardDBBean.getInstance();
		check=pbdb.deleteArticle(num, ref, re_level, re_step);
		request.setAttribute("pageNum", pageNum);
		request.setAttribute("check", check);
		return "recommendDelete.jsp";
	}
}
