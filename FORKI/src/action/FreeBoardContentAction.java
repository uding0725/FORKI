package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO_DTO.FreeBoardDBBean;
import DAO_DTO.FreeBoardDataBean;

public class FreeBoardContentAction implements CommandAction {
	
	public String requestPro (HttpServletRequest request, HttpServletResponse response) throws Throwable{
		
		String pageNum = request.getParameter("pageNum");
		int number = Integer.parseInt(request.getParameter("number"));
		System.out.println(number);
		FreeBoardDBBean fbdbb = FreeBoardDBBean.getInstance();
		FreeBoardDataBean article = new FreeBoardDataBean();
		article = fbdbb.updateGetArticle(number);
		request.setAttribute("article", article);
		System.out.println(article.getId());
		
		return "freeBoardContent.jsp";
	}

}
