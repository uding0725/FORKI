package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FreeBoardWriteFormAction implements CommandAction { 
	
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable{
	int num=0;
	String writer = "ho";
	
	
	try{
		if(request.getParameter("num")!=null){
			num = Integer.parseInt(request.getParameter("num"));
		   }
		}catch(Exception e){e.printStackTrace();}
			//해당 뷰에서 사용할 속성
			request.setAttribute("num", new Integer(num));
			request.getSession().setAttribute("writer", writer);
			
			
			
			return "freeBoardWrite.jsp";
		}
}
