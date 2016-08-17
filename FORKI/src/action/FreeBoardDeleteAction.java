package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO_DTO.FreeBoardDBBean;

public class FreeBoardDeleteAction implements CommandAction {
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable{
		
		request.setCharacterEncoding("UTF-8");
		
		int num = Integer.parseInt(request.getParameter("num"));
		String pageNum = request.getParameter("pageNum");
		String id = (String)request.getSession().getAttribute("id");
		
		
		FreeBoardDBBean fbdbb = FreeBoardDBBean.getInstance();
		int check = fbdbb.deleteArticle(num,id);
		
		//해당 뷰에서 사용할 속성
		request.setAttribute("pageNum", new Integer(pageNum));
		request.setAttribute("check", new Integer(check));
		
	
		
		return "freeBoardDelete.jsp";
	}

}
