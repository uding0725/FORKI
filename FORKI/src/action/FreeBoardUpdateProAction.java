package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO_DTO.FreeBoardDBBean;
import DAO_DTO.FreeBoardDataBean;

public class FreeBoardUpdateProAction implements CommandAction {
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable{
		 request.setCharacterEncoding("UTF-8");

	       String pageNum = request.getParameter("pageNum");

	       FreeBoardDataBean article = new FreeBoardDataBean();
	      
	       article.setNum(Integer.parseInt(request.getParameter("num")));
	       article.setTitle(request.getParameter("title"));
	       article.setSubject(request.getParameter("subject"));
	       article.setContent(request.getParameter("content"));
	       String id = (String)request.getSession().getAttribute("id");
	       
	       
	       
	       FreeBoardDBBean fbdbb = FreeBoardDBBean.getInstance();
	       int check = fbdbb.updateArticle(article, id);

	       request.setAttribute("pageNum", new Integer(pageNum));
	       request.setAttribute("check", new Integer(check));	
	       
	       return "freeBoardUpdatePro.jsp";
	}
	  
}
