package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO_DTO.FrReplyDBBean;

public class FrReplyDelProAction implements CommandAction {
	
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable{
		
		
		int num = Integer.parseInt(request.getParameter("num"));
		int re_num = Integer.parseInt(request.getParameter("re_num"));
		
		int pageNum = Integer.parseInt(request.getParameter("pageNum"));
		String writer = (String)request.getSession().getAttribute("writer");
		
		
		
		FrReplyDBBean frdb = FrReplyDBBean.getInstance();
		int check = frdb.deleteReply(num, writer, re_num);
		
		
		request.setAttribute("num", num);
		request.setAttribute("pageNum", pageNum);
		request.setAttribute("check", check);
		return "frReplyDelete.jsp";
	}

}
