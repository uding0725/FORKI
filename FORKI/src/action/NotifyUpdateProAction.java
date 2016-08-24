package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO_DTO.NotifyDBBean;
import DAO_DTO.NotifyDataBean;

public class NotifyUpdateProAction implements CommandAction{

	public String requestPro(HttpServletRequest request,HttpServletResponse response)throws Throwable{
		request.setCharacterEncoding("utf-8");
		int num =Integer.parseInt(request.getParameter("num"));
		String pageNum= request.getParameter("pageNum");
		NotifyDataBean article=new NotifyDataBean();
		article.setNum(num);
		article.setSubject(request.getParameter("subject"));
		article.setContent(request.getParameter("content"));
		NotifyDBBean ndb=NotifyDBBean.getInstance();
		int check =0;
		check= ndb.updateArticle(article);
		request.setAttribute("pageNum", new Integer(pageNum));
		request.setAttribute("check",new Integer(check));
		return "notifyUpdatePro.jsp";
	}
}
