package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO_DTO.FrReplyDBBean;
import DAO_DTO.FreeBoardDBBean;

public class FreeBoardDeleteAction implements CommandAction {
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable{
		
		request.setCharacterEncoding("UTF-8");
		
		int num = Integer.parseInt(request.getParameter("num"));
		String pageNum = request.getParameter("pageNum");
		String id = (String)request.getSession().getAttribute("id");
		int check = -1;
		
		FreeBoardDBBean fbdbb = FreeBoardDBBean.getInstance();
		FrReplyDBBean frdbb = FrReplyDBBean.getInstance();
		int x = frdbb.deleteReply(num, id);
		if(x==1){
			System.out.println("댓글 삭제 성공");
			check = fbdbb.deleteArticle(num,id);
		}
			
			
		
		
		//해당 뷰에서 사용할 속성
		request.setAttribute("pageNum", new Integer(pageNum));
		request.setAttribute("check", new Integer(check));
		
	
		
		return "freeBoardDelete.jsp";
	}

}
