package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO_DTO.NotifyDBBean;
import DAO_DTO.NotifyDataBean;

public class NotifyUpdateAction implements CommandAction {

	public String requestPro(HttpServletRequest request,HttpServletResponse response)throws Throwable{
		request.setCharacterEncoding("utf-8");
		int num = Integer.parseInt(request.getParameter("num"));
		String pageNum=request.getParameter("pageNum");
		NotifyDBBean ndb=NotifyDBBean.getInstance();
		NotifyDataBean article=ndb.updateGetArticle(num);
		
		request.setAttribute("pageNum",new Integer(pageNum));
		request.setAttribute("article",article);
		return "notifyUpdate.jsp";
	}
}
