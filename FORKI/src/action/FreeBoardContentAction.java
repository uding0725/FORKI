package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO_DTO.FreeBoardDBBean;
import DAO_DTO.FreeBoardDataBean;

public class FreeBoardContentAction implements CommandAction {
	
	public String requestPro (HttpServletRequest request, HttpServletResponse response) throws Throwable{
		
		String pageNum = request.getParameter("pageNum");
		int num = Integer.parseInt(request.getParameter("num"));
		System.out.println(num);
		FreeBoardDBBean fbdbb = FreeBoardDBBean.getInstance();
		FreeBoardDataBean article = new FreeBoardDataBean();
		article = fbdbb.updateGetArticle(num);
		request.setAttribute("article", article);
		System.out.println(article.getId());
		
		return "freeBoardContent.jsp";
	}

}
