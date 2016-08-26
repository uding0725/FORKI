package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RecommendWriteAction implements CommandAction{

	public String requestPro(HttpServletRequest request,HttpServletResponse response)throws Throwable{
		request.setCharacterEncoding("utf-8");
		int num=0,ref=1,re_level=0,re_step=0;
		if(request.getParameter("num")!=null){
			num=Integer.parseInt(request.getParameter("num"));
			ref=Integer.parseInt(request.getParameter("ref"));
			re_level=Integer.parseInt(request.getParameter("re_level"));
			re_step=Integer.parseInt(request.getParameter("re_step"));
		}
		String writer =(String)request.getSession().getAttribute("writer");
		request.setAttribute("writer",writer);;
		request.setAttribute("num", new Integer(num));
		request.setAttribute("ref", new Integer(ref));
		request.setAttribute("re_level",new Integer(re_level));
		request.setAttribute("re_step",new Integer(re_step));
		return "recommendWrite.jsp";
	}
}
