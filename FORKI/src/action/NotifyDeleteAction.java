package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO_DTO.NotifyDBBean;

public class NotifyDeleteAction implements CommandAction{

	public String requestPro(HttpServletRequest request,HttpServletResponse response)throws Throwable{
		int num =Integer.parseInt(request.getParameter("num"));
		String pageNum=request.getParameter("pageNum");
		int check=0;
		NotifyDBBean ndb=NotifyDBBean.getInstance();
		check=ndb.deleteArticle(num);
		request.setAttribute("pageNum", pageNum);
		request.setAttribute("check", check);
		return "notifyDelete.jsp";
	}
}
