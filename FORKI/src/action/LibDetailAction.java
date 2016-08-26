package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO_DTO.LibDBBean;
import DAO_DTO.Pub_LibDataBean;
import DAO_DTO.Tourism_ListDataBean;
import DAO_DTO.Toy_LibDataBean;

public class LibDetailAction implements CommandAction {
	
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable{
	
		
		request.setCharacterEncoding("UTF-8");
		String adres = request.getParameter("adres");
		String select = request.getParameter("select");
		String type = request.getParameter("type");
		
		LibDBBean ldbb = LibDBBean.getInstance();
		
		
		if(type==null){
			
		}else if(type.equals("tour")){
			Tourism_ListDataBean article = new Tourism_ListDataBean();
			article = ldbb.viewTour(adres);
			request.setAttribute("article", article);
		}else if(type.equals("p")){
			Pub_LibDataBean article = new Pub_LibDataBean();
			article = ldbb.viewPublic(adres);
			request.setAttribute("article", article);
		} else if(type.equals("toy")){
			Toy_LibDataBean article = new Toy_LibDataBean();
			article = ldbb.viewToy(adres);
			request.setAttribute("article", article);
		} else{
			
		}
		
		
		request.setAttribute("type",type);
		
		
		
		return "lib_detailPage.jsp";
	}

}
