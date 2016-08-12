package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO_DTO.FreeBoardDBBean;
import DAO_DTO.FreeBoardDataBean;

public class FreeBoardUpdateFormAction implements CommandAction{
	
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable{
		
		 	int num = Integer.parseInt(request.getParameter("num"));
	        String pageNum = request.getParameter("pageNum");

	        FreeBoardDBBean fbdbb = FreeBoardDBBean.getInstance();
	        FreeBoardDataBean article =  fbdbb.updateGetArticle(num);

		
	        request.setAttribute("pageNum", new Integer(pageNum));
	        request.setAttribute("article", article);
	        
	        
	        return "freeBoardUpdate.jsp";
	}

}
