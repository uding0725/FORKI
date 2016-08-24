package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SiteMapAction implements CommandAction{
	public String requestPro(HttpServletRequest request, HttpServletResponse Response) throws Throwable{
		System.out.println("site");
		return "siteMap.jsp";
	}
	

}
