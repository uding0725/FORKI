package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO_DTO.FreeBoardDBBean;
import DAO_DTO.FreeBoardDataBean;

public class FreeBoardContentAction implements CommandAction {
	
	public String requestPro (HttpServletRequest request, HttpServletResponse response) throws Throwable{
		
		String pageNum = request.getParameter("pageNum");
		int num = Integer.parseInt(request.getParameter("num"));
		
		FreeBoardDBBean fbdbb = FreeBoardDBBean.getInstance();
		FreeBoardDataBean article = fbdbb.updateGetArticle(num);
		
		request.setAttribute("num", new Integer(num));
        request.setAttribute("pageNum", new Integer(pageNum));
		request.setAttribute("article", article);

		return "freeBoardContent.jsp";
	}

}
