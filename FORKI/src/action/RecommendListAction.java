package action;

import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO_DTO.PrBoardDBBean;

public class RecommendListAction implements CommandAction{

	public String requestPro(HttpServletRequest request,HttpServletResponse response)throws Throwable{
		
		request.setCharacterEncoding("utf-8");
		String pageNum=request.getParameter("pageNum");
		String search=request.getParameter("search");
		int searchn=0;
		if(pageNum==null){
			pageNum="1";
		}
		if(search==null){
			search="";
		}else{
			searchn=Integer.parseInt(request.getParameter("searchn"));
		}
		int pageSize=10;
		int currentPage=Integer.parseInt(pageNum);
		int startRow=(currentPage-1)*pageSize+1;
		int endRow=currentPage*pageSize;
		int count=0;
		int number=0;
		List articleList=null;
		PrBoardDBBean pbdb=PrBoardDBBean.getInstance();
		if(search.equals("")||search==null)
			count= pbdb.getArticleCount();
		else
			count= pbdb.getArticleCount(searchn, search);
		if(count>0){
			if(search.equals("")||search==null)
			articleList=pbdb.getArticles(startRow, endRow);
			else
				articleList=pbdb.getArticles(startRow, endRow,searchn,search);
		}
		SimpleDateFormat sim=new SimpleDateFormat("yyyy-MM-dd");
		number=count-(currentPage-1)*pageSize;
		request.setAttribute("currentPage",new Integer(currentPage));
		request.setAttribute("startRow",new Integer(startRow));
		request.setAttribute("endRow",new Integer(endRow));
		request.setAttribute("count",new Integer(count));
		request.setAttribute("sim", sim);
		request.setAttribute("pageSize",new Integer(pageSize));
		request.setAttribute("number",new Integer(number));
		request.setAttribute("articleList", articleList);
		return "recommendList.jsp";
	}
}
