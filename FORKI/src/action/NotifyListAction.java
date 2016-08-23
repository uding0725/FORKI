package action;

import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO_DTO.NotifyDBBean;
import DAO_DTO.PrBoardDBBean;



public class NotifyListAction implements CommandAction {

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
		NotifyDBBean ndb=NotifyDBBean.getInstance();
		if(search.equals("")||search==null)
			count= ndb.getArticleCount();
		else
			count= ndb.getArticleCount(searchn, search);
		if(count>0){
			if(search.equals("")||search==null)
				articleList=ndb.getArticles(startRow, endRow);
			else
				articleList=ndb.getArticles(startRow, endRow,searchn,search);
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
		return "notifyList.jsp";
	}
}