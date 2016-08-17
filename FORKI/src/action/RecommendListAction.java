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
		if(pageNum==null){
			pageNum="1";
		}
		int pageSize=10;
		int currentPage=Integer.parseInt(pageNum);
		int startRow=(currentPage-1)*pageSize+1;
		int endRow=currentPage*pageSize;
		int count=0;
		int number=0;
		List articleList=null;
		PrBoardDBBean pbdb=PrBoardDBBean.getInstance();
		count= pbdb.getArticleCount();
		if(count>0){
			articleList=pbdb.getArticles(startRow, endRow);
		}else{
			articleList=Collections.EMPTY_LIST;
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
